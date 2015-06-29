package org.example.microservices.currenttimeapp.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.microservices.currenttimeapp.service.CurrentTimeHystrixFacade;
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

	private static final Log LOGGER = LogFactory.getLog(MainController.class);

	private static final String ERROR_PAGE = "currentTimeFails";

	@Autowired
	private CurrentTimeHystrixFacade currentTimeService;

	@ExceptionHandler
	public String currentTimeFails(Exception e) {
		return ERROR_PAGE;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String currentTime(Model model) {
		String currentTime = null;
		try {
			currentTime = currentTimeService.getCurrentTime();
		} catch (Exception e) {
			LOGGER.error(e);
			return ERROR_PAGE;
		}
		model.addAttribute("timestamp", currentTime);
		return "currentTime";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		return "error";
	}
}
