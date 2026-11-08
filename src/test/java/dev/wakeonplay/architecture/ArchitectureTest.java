package dev.wakeonplay.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

/**
 * Hexagonal architecture boundaries (ADR 001). Since the backend is a single project,
 * without modules, these tests are what stop a wrong import from passing the build.
 *
 * <p>Starting point for the "Create the ArchUnit tests" task: new rules go here.
 */
@AnalyzeClasses(packages = "dev.wakeonplay", importOptions = ImportOption.DoNotIncludeTests.class)
class ArchitectureTest {

    @ArchTest
    static final ArchRule domain_depends_only_on_the_jdk =
            classes().that().resideInAPackage("dev.wakeonplay.domain..")
                    .should().onlyDependOnClassesThat()
                    .resideInAnyPackage("dev.wakeonplay.domain..", "java..")
                    .because("the domain is plain Java and runs the same in the MVP and on Lambda");

    @ArchTest
    static final ArchRule application_does_not_depend_on_adapters =
            noClasses().that().resideInAPackage("dev.wakeonplay.application..")
                    .should().dependOnClassesThat().resideInAPackage("dev.wakeonplay.adapter..")
                    .because("the application knows only ports, never implementations");

    @ArchTest
    static final ArchRule application_is_framework_free =
            noClasses().that().resideInAPackage("dev.wakeonplay.application..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("org.springframework..", "software.amazon..", "com.amazonaws..")
                    .because("frameworks and SDKs belong in the adapters");

    @ArchTest
    static final ArchRule spring_only_in_the_mvp_entry_adapter =
            noClasses().that().resideOutsideOfPackage("dev.wakeonplay.adapter.in.spring..")
                    .should().dependOnClassesThat().resideInAPackage("org.springframework..")
                    .because("the Lambda package is built without Spring (ADR 007)");

    @ArchTest
    static final ArchRule cloudformation_only_in_the_aws_adapter =
            noClasses().that().resideOutsideOfPackage("dev.wakeonplay.adapter.out.aws..")
                    .should().dependOnClassesThat()
                    .resideInAPackage("software.amazon.awssdk.services.cloudformation..")
                    .because("the CloudProvider port stays neutral (ADR 017)");

    @ArchTest
    static final ArchRule outbound_adapters_are_independent =
            slices().matching("dev.wakeonplay.adapter.out.(*)..")
                    .should().notDependOnEachOther()
                    .because("each outbound adapter implements one port and only that port");

    @ArchTest
    static final ArchRule inbound_adapters_are_independent =
            slices().matching("dev.wakeonplay.adapter.in.(*)..")
                    .should().notDependOnEachOther()
                    .because("Spring and Lambda are interchangeable entry points");
}
