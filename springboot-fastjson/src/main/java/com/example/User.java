package com.example;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class User {
    private int id;
    @JSONField(serialize = false)
    private String name;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date curTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCurTime() {
        return curTime;
    }

    public void setCurTime(Date curTime) {
        this.curTime = curTime;
    }
}
