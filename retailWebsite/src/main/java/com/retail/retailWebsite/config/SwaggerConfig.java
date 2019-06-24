package com.retail.retailWebsite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket swaggerDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.retail.retailWebsite.controller")).
				build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo=new ApiInfo("Customer Bill Discount API", "Customer Bill Discount API for a Retail Website", "1.0", "Terms of Service", 
				new Contact("Retail Website", "",""),"Apache License Version 2.0","https://www.apache.org/licesen.html");
		return apiInfo;
	}

}
