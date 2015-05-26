package org.example.microservices.touppercasems;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ToUpperCaseMs {

	private static final Log LOGGER = LogFactory.getLog(ToUpperCaseMs.class);

	@Value("${info.name}")
	private String currentInstance;


	@RequestMapping(value = "/{toUpperCase}", method = RequestMethod.GET)
	public String toUpperCase(@PathVariable("toUpperCase") String toUpperCase) {
		LOGGER.info("toUpperCase on instance: " + currentInstance);
		return toUpperCase.toUpperCase().replace("_", " ").replace("+", " ");
	}


	public static void main(String[] args) {
		SpringApplication.run(ToUpperCaseMs.class, args);
	}
}
