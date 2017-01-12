package com.webapp.rr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Pratyoush on 1/10/2017.
 */
@Controller
public class Login {
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String displayLoginPage(){
        return "login";
    }

}
