package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ContactWithJavaUtilDate {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;
}
