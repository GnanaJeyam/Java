package com.example.springbackend.swagger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig{

	  public static final  Contact DEFAULT_CONTACT = new Contact(
		      "Gnana Jeyam", "http://www.gnanajeyam.com", "gnanajeyam95@gmail.com");
	  
	  private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
		      new HashSet<String>(Arrays.asList("application/json","application/xml"));	   
	  
		ApiInfo apiInfo() {
			return new ApiInfoBuilder()
				.title("Spring Boot with CURD Operation and Config server")
				.description(
					"This REST Service contains basic CURD Operations. I secured some end points "+
					"using Spring security basic authentication. This service also configured"+
					"with actuator, centralized Exception handling using @ControllerAdvice and Externalized Configuration using spring config-server."		
					)
				.termsOfServiceUrl("http://www.gnanajeyam.com")
				.version("0.0.1-SNAPSHOT")
				.contact(DEFAULT_CONTACT)
				.build();
		}

		@Bean
		public Docket api() {
			
			List<SecurityScheme> schemeList = new ArrayList<>();
			    schemeList.add(new BasicAuth("basicAuth"));
			    
		    return new Docket(DocumentationType.SWAGGER_2)
		    	.select()
		    	.apis(RequestHandlerSelectors.basePackage("com.example.springbackend.controller"))
		    	.paths(PathSelectors.regex(".*"))
		    	.build()
		        .apiInfo(apiInfo())
	        	 /*Enabling Authorize Button for Basic Authentication.*/
		        .securitySchemes(schemeList)
		        .produces(DEFAULT_PRODUCES_AND_CONSUMES)
		        .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
		 }
		  
}
