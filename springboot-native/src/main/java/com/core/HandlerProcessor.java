package com.core;

import com.util.ClassScaner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import javax.servlet.annotation.HandlesTypes;
import java.util.List;

public class HandlerProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //这个地方可以自定义扫描策略，譬如根据annotation、继承父类、实现接口等获得全部符合条件的包的集合
        List<HandlesTypes> scan = ClassScaner.scan("", HandlesTypes.class);
        //将对应类注入
        scan.forEach(e -> {
            beanFactory.registerSingleton(e.getClass().getName(), e);
        });
    }
}
