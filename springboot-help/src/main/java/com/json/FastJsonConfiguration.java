package com.json;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Configuration
public class FastJsonConfiguration {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        Collection<HttpMessageConverter<?>> additionalConverters = new ArrayList<>();
        additionalConverters.add(fastJsonHttpMessageConverter());
        additionalConverters.add(stringHttpMessageConverter());
        HttpMessageConverters httpMessageConverters = new HttpMessageConverters(additionalConverters);
        return httpMessageConverters;
    }

    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.DisableCircularReferenceDetect
        );
        fastJsonConfig.setCharset(Charset.forName("utf-8"));
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        fastConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        fastConverter.setFastJsonConfig(fastJsonConfig);
        fastConverter.setDefaultCharset(Charset.forName("utf-8"));
        return fastConverter;
    }

    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("utf-8"));
        converter.setWriteAcceptCharset(false);
        return converter;
    }
}
