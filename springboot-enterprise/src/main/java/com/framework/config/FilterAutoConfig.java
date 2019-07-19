package com.framework.config;


import com.framework.common.xss.XssFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;
import java.util.HashMap;
import java.util.Map;

/**
 * Filter配置
 */
@EnableConfigurationProperties({FilterConfig.class})
public class FilterAutoConfig {

    @Autowired
    private FilterConfig filterConfig;


    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns(StringUtils.split(filterConfig.getUrlPatterns(), ","));
        registration.setName("xssFilter");
        registration.setOrder(Integer.MAX_VALUE);
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("excludes", filterConfig.getExcludes());
        initParameters.put("enabled", filterConfig.getEnabled());
        registration.setInitParameters(initParameters);
        return registration;
    }
}
