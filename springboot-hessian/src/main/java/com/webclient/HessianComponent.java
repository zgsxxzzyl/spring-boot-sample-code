package com.webclient;

import com.RemoteService;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class HessianComponent {
    @Bean
    public HessianProxyFactoryBean hessianClient() {
        HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
        factory.setServiceUrl("http://localhost:8080/remoteService");
        factory.setServiceInterface(RemoteService.class);
        return factory;
    }
}
