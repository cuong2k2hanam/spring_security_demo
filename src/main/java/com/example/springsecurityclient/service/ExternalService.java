package com.example.springsecurityclient.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ExternalService {

    private final RestTemplate restTemplate;

    @Autowired
    public ExternalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> fetchDataFromOtherServer() {
        String url = "http://other-server/api/data";
        return restTemplate.getForObject(url, Map.class);
    }
}
