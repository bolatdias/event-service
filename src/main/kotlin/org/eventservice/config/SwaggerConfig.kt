package org.eventservice.config

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme

@Configuration
@io.swagger.v3.oas.annotations.security.SecurityScheme(
    name = "BearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
class SwaggerConfig {

    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("AuthService API")
                    .description("API documentation with JWT authentication")
                    .version("1.0")
            )
            .addSecurityItem(SecurityRequirement().addList("BearerAuth"))
            .components(
                io.swagger.v3.oas.models.Components().addSecuritySchemes(
                    "BearerAuth",
                    SecurityScheme()
                        .name("BearerAuth")
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                )
            )
    }
}
