package com.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class BaseController {

    public String index() {
        User user = new User();
        user.setUsername("123");
        user.setPassword("123");
        return JSONObject.toJSONString(user);
    }

    @ModelAttribute("user")
    public User addAccount() {
        return new User("jz", "123");
    }

    @ModelAttribute("un")
    public void addAccount(Model model) {
        model.addAttribute("un", "qwe");
    }

    @RequestMapping(value = "/helloWorld")
    public String helloWorld(@ModelAttribute("user") User user) {
        user.setUsername("jizhou");
        return "helloWorld" + JSON.toJSONString(user);
    }

    @RequestMapping("/q")
    public String test(String un, Model model) {
        return un;
    }

    @RequestMapping("/upload")
    //MultipartFile该对象就是封装了图片文件
    public void upload(MultipartFile picture) throws Exception {
        System.out.println(picture.getOriginalFilename());
    }
}
