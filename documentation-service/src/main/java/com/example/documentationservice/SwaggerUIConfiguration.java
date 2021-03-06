package com.example.documentationservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
/**
 * 
 * <pre>
 *   Swagger UI configurations. Configure bean of the {@link SwaggerResourcesProvider} to
 *   read data from in-memory context [Concurrent HashMap]
 * </pre>
 */
@Configuration
public class SwaggerUIConfiguration {
	@Autowired
	private ServiceDefinitionsContext definitionContext;
	
	@Bean
	public RestTemplate configureTempalte(){
		return new RestTemplate();
	}
	
    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider, RestTemplate temp) {
        return () -> {          
            List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
            resources.clear();
            resources.addAll(definitionContext.getSwaggerDefinitions());
            return resources;
        };
    }
}
