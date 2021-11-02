package com.admission.service;

import com.admission.hystrix.CommonHystrixCommand;
import com.admission.model.Doctor;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AdmissionService {

    @Autowired
    HystrixCommand.Setter setter;

    @Autowired
    RestTemplate restTemplate;

    private Doctor getDoctor(int id) throws ExecutionException, InterruptedException {
        CommonHystrixCommand<Doctor> customerCommonHysctrixCommand = new CommonHystrixCommand<>(setter, () ->
                restTemplate.getForObject("http://doctor/doctor/" + id, Doctor.class), () -> new Doctor());

        Future<Doctor> doctorFuture=customerCommonHysctrixCommand.queue();
        return doctorFuture.get();

    }
}
