package org.example.microservices.servicelocation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 *         copyright (C) 2015, SWM Services GmbH
 */
@Controller
public class HomeController {

    @ExceptionHandler
    public String homeFails(Exception e) {
        return "homeFails";
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String indexPage() {
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePath() {
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultHomePath() {
        return "home";
    }

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		return "error";
	}
}
