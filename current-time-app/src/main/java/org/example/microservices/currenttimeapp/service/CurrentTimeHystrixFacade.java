package org.example.microservices.currenttimeapp.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@Service
public class CurrentTimeHystrixFacade {

	@Autowired
	private CurrentTimeService currentTimeService;

	@HystrixCommand(fallbackMethod = "defaultDate")
	public String getCurrentTime() {
		return currentTimeService.currentTime();
	}

	public String defaultDate() {
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.YEAR, 1970);
		instance.set(Calendar.MONTH, 0);
		instance.set(Calendar.DAY_OF_MONTH, 1);
		instance.set(Calendar.HOUR, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MILLISECOND, 0);
		return instance.getTime().toString();
	}


}
