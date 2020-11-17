package com.framework.aspectj;

import com.framework.aspectj.lang.annotation.TargetDataSource;
import com.framework.datasource.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
public class DataSourceAspect {

    /**
     * 改变数据源
     *
     * @param joinPoint
     * @param targetDataSource
     */
    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        String dsType = targetDataSource.value().name();

        if (!DynamicDataSourceContextHolder.isContainsDataSource(dsType)) {
        } else {
            DynamicDataSourceContextHolder.setDateSoureType(dsType);
        }
    }

    @After("@annotation(targetDataSource)")
    public void clearDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        DynamicDataSourceContextHolder.clearDateSoureType();
    }
}
