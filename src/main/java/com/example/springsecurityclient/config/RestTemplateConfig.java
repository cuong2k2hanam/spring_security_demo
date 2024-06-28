package com.example.springsecurityclient.config;
import com.example.springsecurityclient.entity.CustomTextHtmlHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(CustomTextHtmlHttpMessageConverter customTextHtmlHttpMessageConverter) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Collections.singletonList(customTextHtmlHttpMessageConverter));
        return restTemplate;
    }
}
