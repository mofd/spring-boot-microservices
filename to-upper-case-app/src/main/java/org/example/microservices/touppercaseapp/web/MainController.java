package org.example.microservices.touppercaseapp.web;

import org.example.microservices.touppercaseapp.service.CurrentTimeService;
import org.example.microservices.touppercaseapp.service.ToUpperCaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 *         copyright (C) 2015, SWM Services GmbH
 */
@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    public static final String ERROR = "-- ERROR --";
    @Autowired
    private CurrentTimeService currentTimeService;

    @Autowired
    private ToUpperCaseService toUpperCaseService;

    @ExceptionHandler
    public String toUpperCaseFails(Exception e) {
        LOGGER.error("toUpperCaseFails", e);
        return "toUpperCaseFails";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toUpperCase(@RequestParam("toUpperCase") String toUpperCase, Model model) throws Exception {
        try {
            model.addAttribute("timestamp", currentTimeService.currentTime());
        } catch (Exception e) {
            model.addAttribute("timestamp", ERROR);
        }
        try {
            model.addAttribute("upperCase", toUpperCaseService.toUpperCase(toUpperCase));
        } catch (Exception e) {
            model.addAttribute("upperCase", ERROR);
        }

        return "toUpperCase";
    }


	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		return "error";
	}
}
