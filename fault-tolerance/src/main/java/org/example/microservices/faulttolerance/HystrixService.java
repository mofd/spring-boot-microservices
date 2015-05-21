package org.example.microservices.faulttolerance;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@Component
public class HystrixService {

	@HystrixCommand(fallbackMethod = "fallback")
	public String ok() {
		return "OK";
	}

	@HystrixCommand(fallbackMethod = "fallback")
	public String fail() {
		throw new RuntimeException("fail now");
	}

	public String fallback() {
		return "from the fallback";
	}
}
