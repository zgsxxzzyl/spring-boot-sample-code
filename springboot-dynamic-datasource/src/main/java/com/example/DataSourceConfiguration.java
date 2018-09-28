package com.example;

import com.example.dao.support.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "com.example.dao")
public class DataSourceConfiguration {
    /**
     * @return
     * @Primary 需要配置一个默认的数据源
     */
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSourceProperties masterDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource masterDataSource() {
        return masterDataSourceProperties().initializeDataSourceBuilder().build();
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave1")
    public DataSourceProperties slave1DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource slave1DataSource() {
        return slave1DataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 将 master 数据源作为默认指定的数据源
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());
        Map<Object, Object> targetDataSources = new HashMap<>();
        // 将 master 和 slave 数据源作为指定的数据源
        targetDataSources.put(masterDataSourceProperties().getName(), masterDataSource());
        targetDataSources.put(slave1DataSourceProperties().getName(), slave1DataSource());
        dynamicDataSource.setTargetDataSources(targetDataSources);
//        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactory slave1SqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置事务管理
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}
