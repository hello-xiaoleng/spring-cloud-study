package com.xiaoleng.zuul.config;

import com.xiaoleng.zuul.filter.PreFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chen jia
 * @date 2020/1/10 17:46
 */

@Configuration
public class FilterConfig {


    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

}
