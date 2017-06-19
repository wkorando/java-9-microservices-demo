package com.keyholesoftware.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Jaime Niswonger
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProjectsApp {

	public static void main(String[] args) {
		SpringApplication.run(ProjectsApp.class, args);
	}
}
