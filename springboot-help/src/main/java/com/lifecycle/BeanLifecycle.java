package com.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

public class BeanLifecycle implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, EnvironmentAware,
        EmbeddedValueResolverAware, ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware,
        ApplicationContextAware, ServletContextAware, BeanPostProcessor, InitializingBean, DestructionAwareBeanPostProcessor,
        DisposableBean {

    @Override
    public void setBeanName(String name) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("1  -> org.springframework.beans.factory.BeanNameAware.setBeanName");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("2  -> org.springframework.beans.factory.BeanClassLoaderAware.setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3  -> org.springframework.beans.factory.BeanFactoryAware.setBeanFactory");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("4  -> org.springframework.context.EnvironmentAware.setEnvironment");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("5  -> org.springframework.context.EmbeddedValueResolverAware.setEmbeddedValueResolver");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("6  -> org.springframework.context.ResourceLoaderAware.setResourceLoader");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("7  -> org.springframework.context.ApplicationEventPublisherAware.setApplicationEventPublisher");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("8  -> org.springframework.context.MessageSourceAware.setMessageSource");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("9  -> org.springframework.context.ApplicationContextAware.setApplicationContext");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("10 -> org.springframework.beans.factory.InitializingBean.afterPropertiesSet");
    }

    public void initMethod() {
        System.out.println("11 -> com.lifecycle.BeanLifecycle.initMethod");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("12 -> org.springframework.beans.factory.config.BeanPostProcessor.postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("13 -> org.springframework.beans.factory.config.BeanPostProcessor.postProcessAfterInitialization");
        return bean;
    }

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        System.out.println("14 -> org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor.postProcessBeforeDestruction");
    }

    @Override
    public void destroy() {
        System.out.println("15 -> org.springframework.beans.factory.DisposableBean.destroy");
    }

    public void destroyMethod() {
        System.out.println("16 -> com.lifecycle.BeanLifecycle.destroyMethod");
        System.out.println("--------------------------------------------");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println(" -> org.springframework.web.context.ServletContextAware.setServletContext");
    }
}
