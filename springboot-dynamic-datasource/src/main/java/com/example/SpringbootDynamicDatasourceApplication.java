package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringbootDynamicDatasourceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootDynamicDatasourceApplication.class, args);
        // 获取加载的全部bean
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        // 获取加载指定注解的全部bean
        String[] beanNamesForAnnotation = run.getBeanNamesForAnnotation(RestController.class);
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
