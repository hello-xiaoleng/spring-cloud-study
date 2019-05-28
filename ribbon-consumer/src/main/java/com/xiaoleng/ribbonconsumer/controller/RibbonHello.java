package com.xiaoleng.ribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RibbonHello {

    @Autowired
    private RestTemplate restTemplate;

    private final static String clientName = "eureka-client";

    @GetMapping("/ribbon-consumer-hello")
    public @ResponseBody
    ResponseEntity sayHello(@RequestParam("name") String name) {
        String format = String.format("http://eureka-client/hello?name=%s", name);
        ResponseEntity<String> entity = restTemplate.getForEntity(format, String.class);
        return entity;
    }
}
