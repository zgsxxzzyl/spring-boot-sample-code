package com.core;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes({BaseInitializer.class})
public class ServletWebApplicationContextInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("我是ContextWebApplicationContextInitializer");
    }
}
