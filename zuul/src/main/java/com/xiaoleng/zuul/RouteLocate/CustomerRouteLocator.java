package com.xiaoleng.zuul.RouteLocate;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen jia
 * @date 2020/1/13 11:27
 */

@Component
public class CustomerRouteLocator extends SimpleRouteLocator {

    public CustomerRouteLocator(DispatcherServletPath dispatcherServletPath, ZuulProperties properties) {
        super(dispatcherServletPath.getPrefix(), properties);
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        Map<String, ZuulProperties.ZuulRoute> routesRule = new HashMap<>();

        ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
        zuulRoute.setId("TABLE_" + 1);
        zuulRoute.setPath("/feign-consumer-hello");
        zuulRoute.setServiceId("feign-consumer");
        routesRule.put(zuulRoute.getPath(), zuulRoute);
        return routesRule;
    }


}
