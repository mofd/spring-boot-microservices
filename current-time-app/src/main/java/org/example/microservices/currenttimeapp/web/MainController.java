package org.example.microservices.currenttimeapp.web;

import org.example.microservices.currenttimeapp.service.CurrentTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@Controller
public class MainController {

	@Autowired
	private CurrentTimeService currentTimeService;

	@ExceptionHandler
	public String currentTimeFails(Exception e) {
		return "currentTimeFails";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String currentTime(Model model) {
		String currentTime = currentTimeService.currentTime();
		model.addAttribute("timestamp", currentTime);
		return "currentTime";
	}
}
