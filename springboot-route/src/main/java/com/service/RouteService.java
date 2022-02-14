package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface RouteService {

    <T> T route(Map<String, Object> params,
                HttpServletRequest request, HttpServletResponse response, Class<T> bodyType);
}
