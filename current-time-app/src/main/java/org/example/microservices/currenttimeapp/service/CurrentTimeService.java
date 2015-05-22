package org.example.microservices.currenttimeapp.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@FeignClient("CurrentTime")
public interface CurrentTimeService {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String currentTime();

}
