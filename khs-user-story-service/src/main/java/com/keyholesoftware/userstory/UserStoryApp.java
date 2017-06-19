package com.keyholesoftware.userstory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserStoryApp {

	public static void main(String[] args) {
		SpringApplication.run(UserStoryApp.class, args);
	}
}