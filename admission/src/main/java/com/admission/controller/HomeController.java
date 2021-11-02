package com.admission.controller;

import com.admission.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/admission")
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/home")
    public String home(){
        return "Hello from Admission!!";
    }

    @RequestMapping("/allDoctors")
    public List<Doctor> getAllDoctors(){
        return restTemplate.getForObject("http://doctor-service/doctor/all",List.class);
    }
    @RequestMapping("/getDoctor/{Id}")
    public Doctor getDoctorById(@PathVariable("Id") int Id){
        return restTemplate.getForObject("http://doctor-service/doctor/"+Id,Doctor.class);
    }

}
