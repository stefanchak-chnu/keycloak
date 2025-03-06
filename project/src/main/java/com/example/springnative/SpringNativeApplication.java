package com.example.springnative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringNativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNativeApplication.class, args);
	}

}
