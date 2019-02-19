package com;

import com.alibaba.fastjson.JSONObject;
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

    @RequestMapping(value = "/helloWorld")
    public String helloWorld(@ModelAttribute("user") User user) {
        user.setUsername("jizhou");
        return "helloWorld";
    }

    @RequestMapping("/upload")
    //MultipartFile该对象就是封装了图片文件
    public void upload(MultipartFile picture) throws Exception {
        System.out.println(picture.getOriginalFilename());
    }
}
