package com.retail.loyalty.config;

import com.google.common.base.Predicates;
import com.retail.loyalty.models.Customer;
import com.retail.loyalty.models.CustomerAddress;
import com.retail.loyalty.models.CustomerClubcard;
import com.retail.loyalty.models.CustomerContactDetails;
import com.retail.loyalty.security.request.JwtRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docketApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.retail.loyalty.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(apiKey())).protocols(Collections.singleton("HTTP"))
                .ignoredParameterTypes(Customer.class, CustomerAddress.class, CustomerContactDetails.class, CustomerClubcard.class, JwtRequest.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Customer Loyalty Api")
                .description("Api to work with Customer Profile and Transaction data.")
                .termsOfServiceUrl("localhost")
                .version("1.0")
                .contact(new Contact("Kavitha S","https://github.com/KavithaKMurthy","kavitha.kmurthy10@gmail.com"))
                .build();
    }


    private ApiKey apiKey() {
        return new ApiKey("jwtToken", "Authorization", "header");
    }
}