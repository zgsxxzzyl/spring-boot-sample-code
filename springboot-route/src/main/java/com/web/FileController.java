package com.web;

import com.service.FileRouteService;
import com.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class FileController {
    @Resource
    private FileRouteService fileService;

    @RequestMapping("/**/download/**")
    public void download(@RequestBody(required = false) Map<String, Object> params,
                         HttpServletRequest request, HttpServletResponse response) {
        fileService.download(params, request, response);
    }

    @RequestMapping("/**/upload/**")
    public ResponseVO upload(MultipartFile[] files,
                             HttpServletRequest request, HttpServletResponse response) {
        return fileService.upload(files, request, response);
    }
}
