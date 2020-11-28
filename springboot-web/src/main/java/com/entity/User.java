package com.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class User {
    private String username;
    private String password;

    public User(@NotBlank(message = "用户名不能为空") String username, @NotBlank(message = "") @Length(min = 6, message = "") String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
