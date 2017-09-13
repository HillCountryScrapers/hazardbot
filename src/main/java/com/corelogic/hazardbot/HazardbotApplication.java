package com.corelogic.hazardbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "com.corelogic.hazardbot"})
public class HazardbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazardbotApplication.class, args);
	}
}
