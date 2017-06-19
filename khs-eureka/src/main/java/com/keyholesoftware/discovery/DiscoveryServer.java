package com.keyholesoftware.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DiscoveryServer.class, args);
	}
}
