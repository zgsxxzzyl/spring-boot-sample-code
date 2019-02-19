package com;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class User {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "")
    @Length(min = 6, message = "")
    private String password;

    public User(@NotBlank(message = "用户名不能为空") String username, @NotBlank(message = "") @Length(min = 6, message = "") String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
