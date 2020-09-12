package com.doctor.controller;

import com.doctor.model.Doctor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class HomeController {

    private List<Doctor> doctorList = Arrays.asList(
            new Doctor(1, "Sohan", "01755334885","Surgeon"),
            new Doctor(2, "Bappy", "01515205145","Orthopedics")
    );

    @RequestMapping("/home")
    public String home(){
        return "Hello form Doctor!!!";
    }
    @RequestMapping("/all")
    public List<Doctor> getDoctorList(){
        return doctorList;
    }
}
