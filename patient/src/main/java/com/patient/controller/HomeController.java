package com.patient.controller;

import com.patient.entity.Patient;
import com.patient.helper.AuthUserDetails;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
Permissions(in DB) -> Authority
Role(DB) -> Role
 */
@RestController
@RequestMapping("/patient")
@RefreshScope
@EnableAutoConfiguration
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "Hello from Patient!!";
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminTest() {
        return "Hello from Patient (Admin)!!";
    }

    @RequestMapping("/operator")
    @PreAuthorize("hasRole('ROLE_OPERATOR')")
    public String operatorTest() {
        return "Hello from Patient (Operator)!!";
    }

    @RequestMapping("/all")
    @PreAuthorize("hasAuthority('create')")
    public List<Patient> allPatients() {
        //getting LoggedIn user info
        //System.out.println("UserName: " + AuthUserDetails.getUserAuthPrincipal());
        if (AuthUserDetails.getUserAuthAuthorities().contains("ROLE_ADMIN")) {
            System.out.println("ADMIN Logged in!!");
        }
        return Stream.of(new Patient(1, "sohan", "01766"),
                new Patient(2, "rayhan", "01866")).collect(Collectors.toList());
    }

}
