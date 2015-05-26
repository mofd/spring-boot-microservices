package org.example.microservices.touppercaseapp.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@FeignClient("ToUpperCaseMs")
public interface ToUpperCaseService {

	@RequestMapping(value = "/{toUpperCase}", method = RequestMethod.GET)
	String toUpperCase(@PathVariable("toUpperCase") String toUpperCase);

}
