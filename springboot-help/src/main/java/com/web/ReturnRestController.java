package com.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/return/rest")
public class ReturnRestController {

    /**
     * GET /return/rest/test
     *
     * @return
     */
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    /**
     * /return/rest/regex/1
     *
     * @param id
     * @return
     */
    @GetMapping("/regex/{id:\\d+}")
    public Long regex(@PathVariable Long id) {
        return id;
    }

    /**
     * GET /return/rest/redirect
     *
     * @return
     */
    @GetMapping("/redirect")
    public ModelAndView redirect() {
        return new ModelAndView("redirect:/index.html");
    }

    /**
     * GET /return/rest/redirect1
     *
     * @return
     */
    @GetMapping("/redirect1")
    public ModelAndView redirect1() {
        return new ModelAndView("redirect:/index");
    }

    /**
     * GET /return/rest/forward
     *
     * @return
     */
    @GetMapping("/forward")
    public ModelAndView forward() {
        return new ModelAndView("forward:/index.html");
    }
}
