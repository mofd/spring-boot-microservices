package org.example.microservices.servicelocation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulServer {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulServer.class)
				.web(true).run(args);
	}

}
