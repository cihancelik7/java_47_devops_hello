package com.cihancelik.java_47_devops_hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping
public class DevOpsController {

    // http://localhost:8080
    @GetMapping()
    public String devOpsHello(){
        return "DevOps Hello: "+ LocalDateTime.now();
    }

    // http://localhost:8080/info
    @GetMapping("/info")
    public String devOpsInfo(){
        return "INFO: DevOps "+ LocalDateTime.now();
    }


}
