package com.vo;

public class RequestVO<T> {
    private T body;

    public RequestVO(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
