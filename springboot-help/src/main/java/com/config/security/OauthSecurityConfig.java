package com.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * 重写，配置文件配置的参数不生效
 */
@Configuration
public class OauthSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and()
                .csrf().disable()
                .headers().cacheControl().disable()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //只排除指定扩展名的
//                .authorizeRequests().regexMatchers("/[\\S]*\\.(html|js|css|jpg|jpeg|gif|png|bmp|pdf|txt|ppt|pptx|xls|xlsx|doc|docx|zip|rar|7z)").permitAll()
                //带扩展名的都排除，这个配置最简单、粗暴，因为springBoot项目的后端资源uri一般都是不带扩展名的
//                .authorizeRequests().regexMatchers("/[\\S]*\\.[\\d\\w]{1,8}").permitAll()
                .and().authorizeRequests().antMatchers("/**").permitAll()
//                .antMatchers("/annotation/**").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
    }
}