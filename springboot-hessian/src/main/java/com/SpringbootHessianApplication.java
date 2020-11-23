package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringbootHessianApplication {

    @Resource
    private RemoteService remoteService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHessianApplication.class, args);
    }

    @Bean("/remoteService")
    public HessianServiceExporter hessianServiceExporter() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(remoteService);
        exporter.setServiceInterface(RemoteService.class);
        return exporter;
    }
}
