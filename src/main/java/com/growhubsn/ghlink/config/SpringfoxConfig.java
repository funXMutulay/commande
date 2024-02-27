package com.growhubsn.compta.budget.config ;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Value;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;



@Configuration
@EnableSwagger2
public class SpringfoxConfig {

    @Value("${swagger.host.url}")
    private String hostUrl;

    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                    .host(hostUrl)
                    .groupName("Spring Actuator")
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any())
                    .build();
    }


}
