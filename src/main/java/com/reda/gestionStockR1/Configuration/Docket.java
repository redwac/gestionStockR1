package com.reda.gestionStockR1.Configuration;

import org.hibernate.mapping.Collection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

import static com.reda.gestionStockR1.utils.Constant.APP_ROOT;

@Configuration // execution au demmarage de l'application
@EnableSwagger2
class SwaggerConfiguration {

    public static final String AUTHORIZATION_HEADER = "Authozization";

    @Bean
   public Docket api(){

       return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(
                       new ApiInfoBuilder()
                            .description("Gestion de Stock API Documentation ")
                            .title("Gestion de stock REST 1 ")
                            .build()
               )
               .groupName("REST API V1")
               .securityContexts(Collections.singletonList(securityContext()))
               .securitySchemes(Collections.singletonList(apiKey()))
               .select()
               .apis(RequestHandlerSelectors.basePackage("com.reda.gestionStockR1"))
               .paths(PathSelectors.any())
               .build();
   }

   private ApiKey apiKey(){
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
   }

   private SecurityContext securityContext(){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
   }
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(
                new SecurityReference("JWT", authorizationScopes));
    }

}
