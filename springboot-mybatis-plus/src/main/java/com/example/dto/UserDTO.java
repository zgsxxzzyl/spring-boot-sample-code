package com.example.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String status;
    private Date createTime;
}