package com.example.RESTDATA.restapidata;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.RESTDATA.restapidata.Stdmodel",
		"com.example.RESTDATA.restapidata.studentController","com.example.RESTDATA.restapidata.RepositoryInterface"})
public class RestapiDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiDataApplication.class, args);
	}
}
