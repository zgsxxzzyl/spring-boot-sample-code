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
    public boolean requiresDestruction(Object bean) {
        System.out.println("org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor.requiresDestruction");
        return false;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("org.springframework.beans.factory.config.BeanPostProcessor.postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("org.springframework.beans.factory.config.BeanPostProcessor.postProcessAfterInitialization");
        return bean;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("org.springframework.beans.factory.BeanClassLoaderAware.setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("org.springframework.beans.factory.BeanFactoryAware.setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("org.springframework.beans.factory.BeanNameAware.setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("org.springframework.beans.factory.DisposableBean.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("org.springframework.beans.factory.InitializingBean.afterPropertiesSet");
    }

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        System.out.println("org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor.postProcessBeforeDestruction");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("org.springframework.context.ApplicationContextAware.setApplicationContext");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("org.springframework.context.ApplicationEventPublisherAware.setApplicationEventPublisher");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("org.springframework.context.EmbeddedValueResolverAware.setEmbeddedValueResolver");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("org.springframework.context.EnvironmentAware.setEnvironment");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("org.springframework.context.MessageSourceAware.setMessageSource");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("org.springframework.context.ResourceLoaderAware.setResourceLoader");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("org.springframework.web.context.ServletContextAware.setServletContext");
    }

    public void initMethod() {
        System.out.println("com.lifecycle.BeanLifecycle.initMethod");
    }

    public void destroyMethod() {
        System.out.println("com.lifecycle.BeanLifecycle.destroyMethod");
    }
}
