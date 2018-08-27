package com.example.web.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.Annotation;

public class Tests {
    public static void main(String[] args) {
        Annotation[] annotations = AnnotationsTests.class.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i].annotationType());
            if (annotations[i] instanceof SpringBootApplication) {
                SpringBootApplication springBootApplication = ((SpringBootApplication) annotations[i]);
                Annotation[] annotations2 = springBootApplication.annotationType().getAnnotations();
                for (int j = 0; j < annotations2.length; j++) {
                    if (annotations2[j] instanceof ComponentScan) {
                        ComponentScan.Filter[] filters = ((ComponentScan) annotations2[j]).excludeFilters();
                        System.out.println(filters.length);
                    }
                    System.out.println(annotations2[j].annotationType().getName());
                }
            }
        }
    }
}
