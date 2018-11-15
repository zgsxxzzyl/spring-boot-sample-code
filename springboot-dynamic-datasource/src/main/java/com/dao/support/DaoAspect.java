package com.dao.support;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DaoAspect {

    public DaoAspect() {
        System.out.println("初始化DaoAspect。。。");
    }

    @Pointcut("@annotation(com.dao.support.TargetDataSource)")
    public void daoMethod() {
    }

    @Before("daoMethod()")
    public void beforeMethod(JoinPoint joinPoint) {
        Class<?> className = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();

        try {
            Method method = className.getMethod(methodName, argClass);
            if (method.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource targetDataSource = method.getAnnotation(TargetDataSource.class);
                //切换数据
                DynamicDataSourceHolder.setDataSource(targetDataSource.value());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @After("@annotation(targetDataSource)")
    public void afterMethod(TargetDataSource targetDataSource) {
        System.out.println("已切换数据源 --> " + targetDataSource.value());
    }
}
