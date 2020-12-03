package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ContactWithJavaUtilDate {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    public ContactWithJavaUtilDate() {
    }

    public ContactWithJavaUtilDate(Date birthday, Date lastUpdate) {
        this.birthday = birthday;
        this.lastUpdate = lastUpdate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
