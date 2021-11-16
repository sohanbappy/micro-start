package com.micro.appointment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(path = "/")
    public String home(){
        //same as the HTML page name
        return "home";
    }
}
