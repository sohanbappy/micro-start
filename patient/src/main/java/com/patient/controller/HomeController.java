package com.patient.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@RefreshScope
@EnableAutoConfiguration
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "Hello from Patient!!";
    }
}
