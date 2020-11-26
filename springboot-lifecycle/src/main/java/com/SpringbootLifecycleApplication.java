package com;

import com.scenes.a.AService;
import com.scenes.a.AutoFit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringbootLifecycleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootLifecycleApplication.class, args);
//        run.addBeanFactoryPostProcessor();
//        run.close();
    }
}
