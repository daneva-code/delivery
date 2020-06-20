package com.deliver.config;

import com.deliver.response.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@Component
public class RestaurantOrderServicePairing {

    @Autowired
    Environment environment;

    @Value("${restaurant.service.url}")
    private String restaurantServiceUrl;



    @PostConstruct
    public void communicateServiceConnectionSettings() throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> body = new HashMap();
        body.put("hostAddress", InetAddress.getLocalHost().getHostAddress());
        body.put("hostName", InetAddress.getLocalHost().getHostName());
        body.put("port", environment.getProperty("server.port"));
        HttpEntity<String> request = new HttpEntity<>(body.toString());
        String respone = restTemplate.postForObject(restaurantServiceUrl, request, String.class);
    }
}
