package com.jfrogchina.soleng.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppSpringBootApplication {

	private static final Logger logger = LoggerFactory.getLogger(AppSpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppSpringBootApplication.class, args);
	}

	@GetMapping("/")
	public String helloAppBosch(){
		logger.info("This is the main index request.");
		return "Hello Spring boot!";
	}

}
