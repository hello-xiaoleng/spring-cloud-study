package com.xiaoleng.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String name) {
        return "redirect/hello";
    }

    @GetMapping("redirect/hello")
    public @ResponseBody
    String redirectHello(@RequestParam("name") String name) {
        return "redirect hello:" + name + "\n" + "i am from port:" + port;
    }

    @PostMapping("/hello-world")
    public @ResponseBody
    String sayHelloWorld(@RequestBody String name) {
        return "hello world:" + name + "\n" + "i am from port:" + port;
    }


}
