package com.xiaoleng.eurekaclient.controller;

import com.xiaoleng.eurekaclient.domain.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    @PostMapping("/test")
    public @ResponseBody
    User sayHelloWorld() {

        User user = new User();
        user.setDate(new Date());
        user.setName("chenjia");
        return user;
    }


}
