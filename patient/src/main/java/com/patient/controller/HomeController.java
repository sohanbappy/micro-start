package com.patient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "Hello from Patient!!";
    }
}
