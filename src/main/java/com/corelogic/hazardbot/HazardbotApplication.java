package com.corelogic.hazardbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HazardbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazardbotApplication.class, args);
	}
}
