package com;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 实现ApplicationContextAware
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ThreadLocal<ApplicationContext> applicationContextThreadLocal = new ThreadLocal<>();
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContextThreadLocal.get();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContextThreadLocal = new ThreadLocal<ApplicationContext>() {
            @Override
            protected ApplicationContext initialValue() {
                return applicationContext;
            }
        };
//        this.applicationContext = applicationContext;
    }

    //通过class获取Bean.
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

}
