package com.example.springsecurityclient.controller;

import com.example.springsecurityclient.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

//    private final ExternalService externalService;

//    @Autowired
//    public ExternalController(ExternalService externalService) {
//        return this.externalService = externalService;
//    }

    @Autowired
    private ExternalService externalService;

    @GetMapping("/fetch-data")
    public Map<String, Object> fetchData() {
        return externalService.fetchDataFromOtherServer();
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, Welcome to Cuong Dev!!";
    }
}
