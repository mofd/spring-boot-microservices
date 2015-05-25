package org.example.microservices.currenttimems;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
public class CurrentTimeMs {

	private static final Log LOGGER = LogFactory.getLog(CurrentTimeMs.class);

	@Value("${application.name}")
	private String currentInstance;

    @Autowired
    private CurrentDateFormat currentDateFormat;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String currentTime() {
		LOGGER.info("currentTime on instance: " + currentInstance);
        SimpleDateFormat format = new SimpleDateFormat(currentDateFormat.getDateFormat());
		return format.format(new Date());
	}


	public static void main(String[] args) {
		SpringApplication.run(CurrentTimeMs.class, args);
	}
}
