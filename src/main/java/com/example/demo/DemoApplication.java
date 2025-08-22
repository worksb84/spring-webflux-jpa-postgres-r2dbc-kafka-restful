package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:/db.properties"),
		@PropertySource("classpath:/kafka.properties"),
		@PropertySource("classpath:/log4j2.properties")
})
@EnableR2dbcRepositories(basePackages = "com.example.com.repository")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
