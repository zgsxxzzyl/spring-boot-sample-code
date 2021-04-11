package com.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class BaseController {
    @PostMapping("array")
    public Integer[] array(Integer[] ids) {
        return ids;
    }

    @PostMapping("list")
    public List array(@RequestParam List ids) {
        return ids;
    }

    @RequestMapping("idx")
    public String index(String name) {
        User user = new User();
        user.setUsername(name);
        user.setPassword("123");
        return JSONObject.toJSONString(user);
    }

    /**
     * @return
     * @ModelAttribute注释的方法会在此controller每个方法执行前被执行，因此对于一个controller映射多个URL的用法来说，要谨慎使用
     */
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
