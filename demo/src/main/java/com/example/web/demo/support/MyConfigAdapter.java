package com.example.web.demo.support;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyConfigAdapter implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/login/**");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean
            () {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        List<String> urlPatterns = new ArrayList<String>();
        MyFilter myFilter = new MyFilter();   //new过滤器
        urlPatterns.add("/*");      //指定需要过滤的url  pattern这个东西需要注意了，不好写
        filterRegistrationBean.setFilter(myFilter);       //set
        filterRegistrationBean.setUrlPatterns(urlPatterns);     //set
        return filterRegistrationBean;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

}
