package com.micro.appointment.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class HomeController {

    @RequestMapping(path = "/")
    public String home(){
        //same as the HTML page name
        return "home";
    }
}
