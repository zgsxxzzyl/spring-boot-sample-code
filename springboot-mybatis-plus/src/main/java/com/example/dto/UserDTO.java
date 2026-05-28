package com.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema
public class UserDTO {
    @Schema(description = "用户ID")
    private Long id;
    @Schema(description = "用户名称")
    private String name;
    @Schema(description = "用户年龄")
    private Integer age;
    @Schema(description = "用户邮箱")
    private String email;
    @Schema(description = "用户状态")
    private String status;
    @Schema(description = "创建时间")
    private Date createTime;
}