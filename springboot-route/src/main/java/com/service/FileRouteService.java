package com.service;

import com.vo.ResponseVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface FileRouteService {

    ResponseVO upload(MultipartFile[] files, HttpServletRequest request, HttpServletResponse response);

    void download(Map<String, Object> params, HttpServletRequest request, HttpServletResponse response);


}
