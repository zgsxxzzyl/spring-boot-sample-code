package com.core;

import javax.servlet.ServletContext;

public interface MyContainerInitalizer {
    void onStartup(ServletContext context);
}