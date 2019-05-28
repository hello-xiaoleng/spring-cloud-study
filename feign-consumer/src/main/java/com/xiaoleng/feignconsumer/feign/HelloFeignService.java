package com.xiaoleng.feignconsumer.feign;

import com.xiaoleng.feignconsumer.hystrix.HelloFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "eureka-client", fallback = HelloFeignFallbackFactory.class)
public interface HelloFeignService {

    @RequestMapping(value = "/hello-world")
    String hello(String name);

}
