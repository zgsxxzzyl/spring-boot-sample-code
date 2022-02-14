package com.service.impl;

import com.alibaba.fastjson.JSON;
import com.service.AbstractRouteService;
import com.service.RouteService;
import com.util.RouteUtil;
import com.vo.RequestVO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Service
public class RouteServiceImpl extends AbstractRouteService implements RouteService {
    @Override
    public <T> T route(Map<String, Object> params, HttpServletRequest request, HttpServletResponse response, Class<T> responseType) {
        Map<String, Object> requestParam = RouteUtil.getRequestParam(params, request);
        HttpHeaders headers = RouteUtil.resolveHeaders(request);
        String requestJson = JSON.toJSONString(new RequestVO(requestParam));
        HttpEntity<String> requestEntity = new HttpEntity<>(requestJson, headers);
        String requestURL = RouteUtil.getRequestURL(request, gatewayUrl);
        ResponseEntity<T> responseEntity = restTemplate.postForEntity(requestURL, requestEntity, responseType);
        return responseEntity.getBody();
    }
}
