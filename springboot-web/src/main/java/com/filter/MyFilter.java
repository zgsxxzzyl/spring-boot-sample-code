package com.filter;

import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Map;

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filterConfig.getFilterName() --> " + filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String characterEncoding = request.getCharacterEncoding();
        String contentType = request.getContentType();
        String localName = request.getLocalName();
        int localPort = request.getLocalPort();
        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        System.out.println("request.getCharacterEncoding() --> " + characterEncoding);
        System.out.println("request.getContentType() --> " + contentType);
        System.out.println("request.getLocalName() --> " + localName);
        System.out.println("request.getLocalPort() --> " + localPort);
        System.out.println("request.getRemoteAddr() --> " + remoteAddr);
        System.out.println("request.getRemoteHost() --> " + remoteHost);
        System.out.println("request.getRemotePort() --> " + remotePort);
        System.out.println("request.getScheme() --> " + scheme);
        System.out.println("request.getServerName() --> " + serverName);
        System.out.println("request.getServerPort() --> " + serverPort);
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("parameter --> " + JSON.toJSON(parameterMap));
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
