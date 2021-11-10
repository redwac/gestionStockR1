package com.reda.gestionStockR1.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.reda.gestionStockR1.utils.Constant.APP_ROOT;

@Configuration // execution au demmarage de l'application
@EnableSwagger2
class SwaggerConfiguration {

   public Docket api(){

       return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(
                       new ApiInfoBuilder()
                            .description("Gestion de Stock API Documentation ")
                            .title("Gestion de stock REST 1 ")
                            .build()
               )
               .groupName("REST API V1")
               .select()
               .apis(RequestHandlerSelectors.basePackage("com.reda.gestionStockR1"))
               .paths(PathSelectors.any())
               .build();
   }

}
