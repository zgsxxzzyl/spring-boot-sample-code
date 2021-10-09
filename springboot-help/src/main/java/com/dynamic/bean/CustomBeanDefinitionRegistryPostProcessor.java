package com.dynamic.bean;

import com.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // register your custom bean definition here
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //创建bean信息
        beanDefinitionBuilder.addPropertyValue("id", 123);
        beanDefinitionBuilder.addPropertyValue("name", "名字");
        beanDefinitionBuilder.addPropertyValue("age", 18);
        beanDefinitionBuilder.addPropertyValue("sex", User.Sex.MAN);

        registry.registerBeanDefinition("dynamic#user", beanDefinitionBuilder.getBeanDefinition());
        // here are some useful utils:
        // org.springframework.boot.autoconfigure.AutoConfigurationPackages
        // org.springframework.context.annotation.ClassPathBeanDefinitionScanner
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // do nothing
    }
}
