package org.example.microservices.touppercaseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ToUpperCaseApp {

	public static void main(String[] args) {
		SpringApplication.run(ToUpperCaseApp.class, args);
	}
}
