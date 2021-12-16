package com.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(1)
//@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("----------------CommandLineRunner----------------");
    }
}
