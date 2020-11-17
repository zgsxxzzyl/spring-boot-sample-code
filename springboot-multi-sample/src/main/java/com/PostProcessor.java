package com;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 监听bean注入的过程
 */
public class PostProcessor implements BeanPostProcessor {

    @Override
    //实例化、依赖注入完毕，在调用显示的初始化之前完成一些定制的初始化任务
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization -> " + beanName);
        return bean;
    }

    @Override
    //实例化、依赖注入、初始化完毕时执行
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization -> " + beanName);
        return bean;
    }
}
