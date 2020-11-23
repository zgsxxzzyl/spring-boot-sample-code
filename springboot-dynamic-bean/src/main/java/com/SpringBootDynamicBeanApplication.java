package com;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDynamicBeanApplication {

    public static void main(String[] args) {
        //获取context
        ApplicationContext applicationContext = (ApplicationContext) SpringApplication.run(SpringBootDynamicBeanApplication.class, args);
        //获取BeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        //创建bean信息
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 123);
        beanDefinitionBuilder.addPropertyValue("name", "名字");
        beanDefinitionBuilder.addPropertyValue("age", 18);
        beanDefinitionBuilder.addPropertyValue("sex", User.Sex.MAN);
        //动态注册bean
        defaultListableBeanFactory.registerBeanDefinition("user", beanDefinitionBuilder.getBeanDefinition());
        //获取动态注册的bean
        User bean = applicationContext.getBean(User.class);
        System.out.println(bean.toString());

        //删除bean
        defaultListableBeanFactory.removeBeanDefinition("user");

    }
}

