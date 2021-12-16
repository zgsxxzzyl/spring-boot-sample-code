package com.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

//@Configuration
@ServletComponentScan
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new FilterImpl());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/filter1/"));
        return filterRegistrationBean;
    }
}
