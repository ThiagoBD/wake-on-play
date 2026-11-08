package dev.wakeonplay.adapter.in.spring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Public API metadata shown in Swagger UI ({@code /swagger-ui.html}).
 */
@Configuration
class OpenApiConfig {

    @Bean
    OpenAPI wakeOnPlayOpenApi() {
        return new OpenAPI().info(new Info()
                .title("Wake on Play API")
                .version("0.1.0")
                .description("Starts game servers on demand and shuts them down on their own "
                        + "when the last player leaves, without losing the save."));
    }
}
