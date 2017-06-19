package com.keyholesoftware.project.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.keyholesoftware.troublemaker.client.EnableTroubleMaker;

/**
 * @author Jaime Niswonger
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTroubleMaker
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}