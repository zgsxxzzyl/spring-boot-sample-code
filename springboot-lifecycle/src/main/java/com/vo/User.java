package com.vo;

public class User {

    private int i;

    public User(int i) {
        this.i = i;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "i=" + i +
                '}';
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
