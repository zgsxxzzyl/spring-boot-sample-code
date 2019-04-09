package com.core;

import javax.servlet.ServletContext;

public class ServletWebApplicationContextInitializer implements MyContainerInitalizer {
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("我是ContextWebApplicationContextInitializer");
    }
}
