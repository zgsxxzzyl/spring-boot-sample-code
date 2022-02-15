package com.vo;

public class ResponseVO<T> {
    private String code;
    private String message;
    private T data;

    public static ResponseVO success() {
        return new ResponseVO("200", "success", null);
    }

    public static <T> ResponseVO success(T data) {
        return new ResponseVO("200", "success", data);
    }

    public ResponseVO() {
    }

    public ResponseVO(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
