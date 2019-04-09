package com.core;

import com.filter.StartFilter;
import com.servlet.StartServlet;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.EnumSet;
import java.util.Set;

@HandlesTypes(MyContainerInitalizer.class)  //自动加载实现WebApplicationInitializer接口的全部子类
public class StartServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        if (c != null && !c.isEmpty()) {
            c.forEach(e -> {
                if (!e.isInterface() && !Modifier.isAbstract(e.getModifiers()) &&
                        WebApplicationInitializer.class.isAssignableFrom(e)) {
                    try {
                        WebApplicationInitializer webApplication = (WebApplicationInitializer) e.newInstance();
                        webApplication.onStartup(ctx);
                    } catch (InstantiationException e1) {
                        e1.printStackTrace();
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    } catch (ServletException e1) {
                        e1.printStackTrace();
                    }

                }
            });
        }
        //添加Servlet
        ServletRegistration.Dynamic dynamicServlet = ctx.addServlet("startServlet", new StartServlet());
        //请求路径
        dynamicServlet.addMapping("/demo");
        //Servlet InitParam
        dynamicServlet.setInitParameter("demo", "demo");
        dynamicServlet.setLoadOnStartup(1);
        //添加过滤器
        FilterRegistration.Dynamic dynamicFilter = ctx.addFilter("filter", new StartFilter());
        dynamicFilter.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "demoServlet");
    }
}
