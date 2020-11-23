package com.webclient;

import com.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HessianController {
    @Autowired
    private RemoteService remoteService;

    @RequestMapping("/call/{name}")
    public String callHessianService(@PathVariable(name = "name") String name) {
        return remoteService.offerName(name);
    }
}
