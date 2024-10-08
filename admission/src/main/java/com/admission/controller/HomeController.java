package com.admission.controller;

import com.admission.hystrix.CommonHystrixCommand;
import com.admission.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/admission")
@RefreshScope
@EnableAutoConfiguration
public class HomeController {

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @RequestMapping("/home")
    public String home() {
        return "Hello from Admission!!";
    }

    @RequestMapping("/allDoctors")
    public List<Doctor> getAllDoctors() throws ExecutionException, InterruptedException {
        CommonHystrixCommand<List<Doctor>> command = new CommonHystrixCommand<List<Doctor>>("appointment-group",
                () -> restTemplate.getForObject("http://doctor-service/doctor/all", List.class)
                , () -> new ArrayList<>());
        Future<List<Doctor>> docFuture = command.queue();
        return docFuture.get();
    }

    @RequestMapping("/getDoctor/{Id}")
    public Doctor getDoctorById(@PathVariable("Id") int Id) throws ExecutionException, InterruptedException {
        CommonHystrixCommand<Doctor> command = new CommonHystrixCommand<Doctor>("appointment-group",
                () -> restTemplate.getForObject("http://doctor-service/doctor/" + Id, Doctor.class)
                , () -> new Doctor());
        Future<Doctor> docFuture = command.queue();
        return docFuture.get();
    }

}
