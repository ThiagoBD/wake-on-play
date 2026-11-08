package dev.wakeonplay.adapter.in.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MVP entry point. Component scanning covers only {@code adapter.in.spring}:
 * use cases and outbound adapters are registered explicitly in the {@code *Config}
 * classes of this package, never annotated with {@code @Component} in the domain.
 */
@SpringBootApplication
public class WakeOnPlayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WakeOnPlayApplication.class, args);
    }
}
