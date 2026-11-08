# Wake on Play

Starts cloud game servers when someone asks for one and shuts them down on their own when the last player leaves, without ever losing the save.

This repository is the **backend**: domain, use cases, API and the AWS platform. The agents that talk to each game live in the `wake-on-play-agents` repository.

> Status: initial MVP skeleton. The functional and technical specifications are in the Wake on Play project in Linear.

## Prerequisites

- JDK 25 (for example, Eclipse Temurin 25 or Amazon Corretto 25)
- Maven 3.9+ (only to generate the wrapper the first time)
- Docker, for DynamoDB Local

## Getting started

```bash
# 1. Generate the Maven Wrapper (once only; afterwards always use ./mvnw)
mvn -N wrapper:wrapper -Dmaven=3.9.11

# 2. Start DynamoDB Local
docker compose up -d

# 3. Compile and run all tests (including the architecture rules)
./mvnw verify

# 4. Start the MVP backend
./mvnw spring-boot:run
```

With the backend running:

- Swagger UI: http://localhost:8080/swagger-ui.html
- Health: http://localhost:8080/actuator/health

## Build profiles

| Profile | Command | Produces |
| --- | --- | --- |
| `mvp` (default) | `./mvnw verify` | Executable Spring Boot JAR, to run locally |
| `lambda` | `./mvnw -Plambda package` | `target/wake-on-play-*-lambda.jar`, without Spring, for AWS Lambda (v2) |

The `lambda` profile excludes the `adapter.in.spring` package from compilation, to keep cold starts small.

## Structure

```
src/main/java/dev/wakeonplay/
├── domain/                  # entities, state machine, rules (plain Java)
├── application/
│   ├── port/in/             # use cases
│   ├── port/out/            # CloudProvider, GameAdapter, repositories
│   └── service/             # use case implementations
└── adapter/
    ├── in/spring/           # MVP REST API (the only place with Spring)
    ├── in/lambda/           # v2 handlers
    ├── out/dynamodb/        # persistence
    ├── out/aws/             # CloudProvider: customer servers via CloudFormation
    └── out/agent/           # GameAdapter: command queue for the agent
src/test/java/.../architecture/ArchitectureTest.java   # hexagonal boundaries
contracts/                   # agent protocol contract (OpenAPI)
infra/terraform/             # platform only; never resources of a customer server
docs/adr/                    # architecture decisions
```

## Architecture rules

Checked during the build by `ArchitectureTest`:

- `domain` depends only on the JDK.
- `application` knows nothing about adapters, Spring or AWS SDKs.
- Spring exists only in `adapter.in.spring`.
- The CloudFormation SDK exists only in `adapter.out.aws`.
- Outbound adapters do not depend on each other; neither do inbound adapters.

## Decisions

See [`docs/adr`](docs/adr).
