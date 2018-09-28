package com.example.action;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleAction {

    @RequestMapping(method = RequestMethod.POST)
    public void save() {

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {

    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update() {

    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public void query(@PathVariable String id) {

    }

    @RequestMapping
    public void queryAll() {

    }

}
