package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ServletComponentScan
//public class SpringbootWebThymeleafApplication implements WebMvcConfigurer {

@SpringBootApplication
public class SpringbootWebThymeleafApplication {

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/inter/**").excludePathPatterns("/ca/**");
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebThymeleafApplication.class, args);
    }
}
