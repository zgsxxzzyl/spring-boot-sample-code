package com;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 采用restTemplate远程调用rest api
     *
     * @param arg
     * @return
     */
    @HystrixCommand(fallbackMethod = "error")
    public String remoteService(String arg) {
        return restTemplate.getForObject("http://SERVICE-CLIENT/user/{1}", String.class, arg);
    }

    public String error(String arg) {
        return "===>>> error === >>> " + arg;
    }


}