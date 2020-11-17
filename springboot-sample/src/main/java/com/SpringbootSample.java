package com;

import com.entity.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

@ServletComponentScan //添加拦截、过滤、监听扫描
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@ComponentScan(basePackages = {"com.action.LoginController"})
//@ImportResource(locations = {"classpath:application-bean.xml","file:D:/test/application-bean.xml"})   加载自定义的xml
@SpringBootApplication
public class SpringbootSample {
    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(Step1Application.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
//        springApplication.addListeners();
//        springApplication.run(args);
        ApplicationContext run = SpringApplication.run(SpringbootSample.class, args);
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) run.getAutowireCapableBeanFactory();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("username", "张三");
        beanDefinitionBuilder.addPropertyValue("password", "张三的密码");

        defaultListableBeanFactory.registerBeanDefinition("userDemo", beanDefinitionBuilder.getBeanDefinition());
        User userDemo = (User) run.getBean("userDemo");
        System.out.println(userDemo.toString());

    }
}
