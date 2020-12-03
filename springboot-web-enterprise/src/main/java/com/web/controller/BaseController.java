package com.web.controller;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

    /**
     * 封装返回数据
     *
     * @param data
     * @return
     */
    public String successData(Object data) {
        Map<String, Object> returnMessage = new HashMap<String, Object>();
        returnMessage.put("data", data);
        returnMessage.put("code", 0);
        returnMessage.put("msg", null);
        return JSON.toJSONString(returnMessage);
    }

    /**
     * 封装异常数据
     *
     * @param e
     * @return
     */
    public String failData(Exception e) {
        Map<String, Object> returnMessage = new HashMap<String, Object>();
        returnMessage.put("code", 1);
        returnMessage.put("msg", e.getMessage());
        return JSON.toJSONString(returnMessage);
    }

    /**
     * 封装异常数据
     *
     * @param message
     * @return
     */
    public String failData(String message) {
        Map<String, Object> returnMessage = new HashMap<String, Object>();
        returnMessage.put("code", 1);
        returnMessage.put("msg", message);
        return JSON.toJSONString(returnMessage);
    }

    /**
     * 页面跳转
     */
    public String redirect(String url) {
        return String.format("redirect:%1$s", url);
    }
}
