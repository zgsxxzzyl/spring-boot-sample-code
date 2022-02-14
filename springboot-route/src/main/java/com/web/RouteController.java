package com.web;

import com.service.RouteService;
import com.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class RouteController {
    @Resource
    private RouteService routeService;

    @RequestMapping("/**")
    public ResponseVO route(@RequestBody(required = false) Map<String, Object> params,
                            HttpServletRequest request, HttpServletResponse response) {
        return routeService.route(params, request, response, ResponseVO.class);
    }
}
