package org.example.microservices.touppercaseapp.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@Service
public class ToUpperCaseHystrixService {

	@Autowired
	private ToUpperCaseService toUpperCaseService;

	@HystrixCommand(fallbackMethod = "toDefaultUpperCase")
	public String toUpperCase(String toUpperCase) {
		return toUpperCaseService.toUpperCase(toUpperCase);
	}

	public String toDefaultUpperCase(String toUpperCase) {
		return "DEFAULT: " + toUpperCase.toUpperCase();
	}
}
