package com.restalone.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping
    public String healthCheck() {
        return "Site is up. Health is good";
    }

    @GetMapping("portinfo")
    public String portDetails() {
        return "Server: Tomcat | Port: 9090";
    }
}
