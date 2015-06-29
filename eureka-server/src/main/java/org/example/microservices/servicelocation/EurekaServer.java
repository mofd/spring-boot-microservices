package org.example.microservices.servicelocation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@SpringBootApplication
@EnableEurekaServer
@EnableHystrix
public class EurekaServer {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaServer.class).web(true).run(args);
	}

}
