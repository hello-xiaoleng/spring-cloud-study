package com.xiaoleng.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "redirectHello " + name + " sya hello world!\n" + "i am from port:" + port;
    }


}
