package com.xiaoleng.feignconsumer.hystrix;

import com.xiaoleng.feignconsumer.feign.HelloFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloFeignFallbackFactory implements FallbackFactory<HelloFeignService> {

    @Override
    public HelloFeignService create(Throwable throwable) {
        return new HelloFeignService() {
            @Override
            public String hello(String name) {
                return "fail";
            }
        };
    }
}
