package com.service.impl;

import com.service.AbstractRouteService;
import com.service.FileRouteService;
import com.util.RouteUtil;
import com.vo.RequestVO;
import com.vo.ResponseVO;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

@Service
public class FileRouteServiceImpl extends AbstractRouteService implements FileRouteService {
    @Override
    public ResponseVO upload(MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) {
        String requestURL = RouteUtil.getRequestURL(request, gatewayUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        Map<String, Object> requestParam = RouteUtil.getRequestParam(null, request);
        RequestVO requestVO = new RequestVO(requestParam);
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("requestVO", requestVO);
        for (MultipartFile file : files) {
            multiValueMap.add("files", file.getResource());
        }
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(multiValueMap, headers);
        return restTemplate.postForEntity(requestURL, requestEntity, ResponseVO.class).getBody();
    }

    @Override
    public void download(Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
        String requestURL = RouteUtil.getRequestURL(request, gatewayUrl);
        HttpHeaders headers = RouteUtil.resolveHeaders(request);
        Map<String, Object> requestParam = RouteUtil.getRequestParam(params, request);
        HttpEntity<RequestVO<Map<String, Object>>> requestEntity = new HttpEntity<>(new RequestVO<>(requestParam), headers);
        ResponseEntity<Resource> responseEntity = restTemplate.postForEntity(requestURL, requestEntity, Resource.class);
        Map<String, String> stringStringMap = responseEntity.getHeaders().toSingleValueMap();
        for (Map.Entry<String, String> header : stringStringMap.entrySet()) {
            response.setHeader(header.getKey(), header.getValue());
        }
        Resource body = responseEntity.getBody();
        try (InputStream inputStream = body.getInputStream();
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
             OutputStream outputStream = response.getOutputStream()) {
            byte[] buffer = new byte[2048];
            int len;
            while ((len = bufferedInputStream.read(buffer, 0, buffer.length)) != -1) {
                outputStream.write(buffer, 0, len);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
