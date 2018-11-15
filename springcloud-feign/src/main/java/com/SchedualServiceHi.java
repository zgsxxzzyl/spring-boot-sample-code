package com;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-client")      //提供的application名称
public interface SchedualServiceHi {
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    String sayHiFromClientOne(@PathVariable(value = "id") String id);
}
