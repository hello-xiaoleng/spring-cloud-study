package com.xiaoleng.feignconsumer.controller;

import com.xiaoleng.feignconsumer.feign.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHelloController {

    @Autowired
    private HelloFeignService feignService;

    @GetMapping("/feign-consumer-hello")
    public String sayHello(@RequestParam("name") String name) {
        System.out.println("1234465677");
        return feignService.hello(name);
    }

}
