package org.example.microservices.faulttolerance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableCircuitBreaker
@RestController
public class Application {

	@Bean
	public HystrixService myService() {
		return new HystrixService();
	}

	@Autowired
	private HystrixService hystrixService;

	@RequestMapping("/")
	public String ok() {
		return hystrixService.ok();
	}

	@RequestMapping("/fail")
	public String fail() {
		return hystrixService.fail();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
