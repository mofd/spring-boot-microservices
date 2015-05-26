package org.example.microservices.touppercaseapp.web;

import org.example.microservices.touppercaseapp.service.CurrentTimeService;
import org.example.microservices.touppercaseapp.service.ToUpperCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    public static final String CURRENT_TIME_SERVICE = "currentTimeService";
    public static final String TO_UPPER_CASE_SERVICE = "toUpperCaseService";
    public static final String ERROR = "-- ERROR --";
    @Autowired
    private CurrentTimeService currentTimeService;

    @Autowired
    private ToUpperCaseService toUpperCaseService;

    @ExceptionHandler
    public String currentTimeFails() {
        return "toUpperCaseFails";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String currentTime(@RequestParam("toUpperCase") String toUpperCase, Model model) throws Exception {
        String currentTime = null;
        try {
            currentTime = currentTimeService.currentTime();
            model.addAttribute("timestamp", currentTime);
        } catch (Exception e) {
            model.addAttribute("timestamp", ERROR);
        }
        String upperCase = null;
        try {
            upperCase = toUpperCaseService.toUpperCase(toUpperCase);
            model.addAttribute("upperCase", upperCase);
        } catch (Exception e) {
            model.addAttribute("upperCase", ERROR);
        }

        return "toUpperCase";
    }
}
