package com.config;

import io.undertow.UndertowOptions;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;

//@Configuration
public class HttpConfig {

    /**
     * Springboot 2.0将UndertowEmbeddedServletContainerFactory 替换成 UndertowServletWebServerFactory
     *
     * @return
     */
    @Bean
    public UndertowServletWebServerFactory undertowServletWebServerFactory() {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        //chrome://net-internals/#http2 验证是否开启 HTTP/2
        factory.addBuilderCustomizers(builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true));
        return factory;
    }

}
