package com.util;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

public class RouteUtil {

    public static Map<String, Object> getRequestParam(Map<String, Object> params, HttpServletRequest request) {
        if (params == null) params = new LinkedHashMap<>();
        Map<String, String[]> parameterMap = request.getParameterMap();
        String key;
        String[] value;
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            if (value.length > 1) {
                params.put(key, Arrays.asList(value));
                continue;
            }
            params.put(key, value[0]);
        }
        return params;
    }

    public static HttpHeaders resolveHeaders(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        String name;
        while (headerNames.hasMoreElements()) {
            name = headerNames.nextElement();
            headers.set(name, request.getHeader(name));
        }
        headers.setCacheControl(CacheControl.noCache());
        headers.setAccept(Arrays.asList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public static String getRequestURL(HttpServletRequest request, String gatewayUrl) {
        StringBuilder url = new StringBuilder();
        String requestURI = request.getRequestURI();
        int idx = requestURI.indexOf("/", 1);
        if (idx <= -1) {
            throw new RuntimeException("地址错误");
        }
        String moduleName = requestURI.substring(1, idx);
        String serviceURI = requestURI.substring(idx);
        url.append(gatewayUrl);
        url.append(moduleName);
        url.append(serviceURI);
        return url.toString();
    }
}
