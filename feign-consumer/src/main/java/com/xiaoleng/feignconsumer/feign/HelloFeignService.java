package com.xiaoleng.feignconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "eureka-client")
public interface HelloFeignService {

    @RequestMapping(value = "/hello-world")
    String hello(String name);

}
