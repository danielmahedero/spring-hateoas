package com.concretepage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootDemoApplication.class);

	public static void main(String[] args) {
		LOGGER.info("MAIN METHOD EXECUTED");
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
