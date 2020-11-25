package com.core;

import javax.servlet.ServletContext;

public class WebApplicationContextInitializer implements MyContainerInitalizer {
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("我是ContextWebApplicationContextInitializer");
    }
}
