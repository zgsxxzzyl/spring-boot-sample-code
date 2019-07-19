package com.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Filter配置
 */
@ConfigurationProperties("xss")
public class FilterConfig {

    private String enabled;

    private String excludes;

    private String urlPatterns;

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getExcludes() {
        return excludes;
    }

    public void setExcludes(String excludes) {
        this.excludes = excludes;
    }

    public String getUrlPatterns() {
        return urlPatterns;
    }

    public void setUrlPatterns(String urlPatterns) {
        this.urlPatterns = urlPatterns;
    }

}
