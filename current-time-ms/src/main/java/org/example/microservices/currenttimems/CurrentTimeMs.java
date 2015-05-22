package org.example.microservices.currenttimems;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
@EnableEurekaClient
public class CurrentTimeMs {

	private static final Log LOGGER = LogFactory.getLog(CurrentTimeMs.class);

	@Value("${application.name}")
	private String currentInstance;

	@RequestMapping("/")
	public String currentTime() {
		LOGGER.info("currentTime on instance: " + currentInstance);
		return String.valueOf(new Date());
	}

	public static void main(String[] args) {
		SpringApplication.run(CurrentTimeMs.class, args);
	}
}
