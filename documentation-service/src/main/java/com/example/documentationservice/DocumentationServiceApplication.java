package com.example.documentationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class DocumentationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentationServiceApplication.class, args);
	}
	
}
