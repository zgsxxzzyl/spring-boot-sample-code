package com;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(urlPatterns = "/filter/")
public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.sendRedirect("/index.html");

        servletRequest.getRequestDispatcher("/static.html").forward(servletRequest, servletResponse);
        return;
//        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
