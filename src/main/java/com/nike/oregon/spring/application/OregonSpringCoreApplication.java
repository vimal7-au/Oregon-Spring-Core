package com.nike.oregon.spring.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
@EnableAsync
public class OregonSpringCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OregonSpringCoreApplication.class, args);
	}
}
