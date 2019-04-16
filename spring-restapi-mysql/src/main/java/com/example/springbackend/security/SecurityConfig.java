package com.example.springbackend.security;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/greetmessage").permitAll()
			.antMatchers("/v2/api-docs").permitAll()
	        .antMatchers(HttpMethod.POST, "/refresh").permitAll()
			.antMatchers("/health").permitAll()
			.antMatchers("/students/{id}").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			// Enabling CROSS request for all origins and overriding default request TYPES
			.cors().configurationSource(request -> 
				{
					CorsConfiguration cors = new CorsConfiguration();
						cors.setAllowedMethods(
							Arrays.asList(
								HttpMethod.DELETE.name(),
								HttpMethod.GET.name(), 
								HttpMethod.HEAD.name(), 
								HttpMethod.POST.name(),
								HttpMethod.PUT.name()
							));
						cors.applyPermitDefaultValues();
					
					return cors;
					
				})
			.and()
			.csrf().disable()
			.httpBasic();
		
	}

}
