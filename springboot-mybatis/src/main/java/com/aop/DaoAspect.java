package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoAspect {

    @Pointcut("execution(public * com.dao.UserMapper.*(..))")
    public void daoMethod() {
    }

    @Before("daoMethod()")
    public void BeforeMethod(JoinPoint point) {
        System.out.println(point.getSignature().getName());
    }
}
