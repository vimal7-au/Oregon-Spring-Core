package com.nike.oregon.spring.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})

public class OregonSpringCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OregonSpringCoreApplication.class, args);
	}
}
