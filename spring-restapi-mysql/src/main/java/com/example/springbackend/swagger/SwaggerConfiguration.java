package com.example.springbackend.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	  public static final  Contact DEFAULT_CONTACT = new Contact(
	      "Gnana Jeyam", "http://www.gnanajeyam.com", "gnanajeyam95@gmail.com");

	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
	      "Spring Boot with CURD Operation and Config server",
	      "This REST Service contains basic CURD Operations. I secured some end points "
	      + "using Spring security basic authentication. This service also configured"
	      + "with actuator, centralized Exception handling using @ControllerAdvice and "
	      + "Externalized Configuration using spring config-server.", "1.0",
	      "urn:tos", DEFAULT_CONTACT, 
	      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

	  private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
	      new HashSet<String>(Arrays.asList("application/json"));

	  @Bean
	  public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	    	.select()
	    	.apis(RequestHandlerSelectors.basePackage("com.example.springbackend.controller"))
	    	.paths(PathSelectors.regex(".*"))
	    	.build()
	        .apiInfo(DEFAULT_API_INFO)
	        .produces(DEFAULT_PRODUCES_AND_CONSUMES)
	        .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	  }}
