package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //添加拦截、过滤、监听扫描
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@ComponentScan(basePackages = {"com.action.LoginController"})
//@ImportResource(locations = {"classpath:application-bean.xml","file:D:/test/application-bean.xml"})   加载自定义的xml
@SpringBootApplication
public class StepApplication {
    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(Step1Application.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
//        springApplication.run(args);
        SpringApplication.run(StepApplication.class, args);
    }
}