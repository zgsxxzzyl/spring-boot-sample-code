package com.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@DependsOn("transactionManager")
@EnableJpaRepositories(basePackages = "com.repository.order", entityManagerFactoryRef = "orderEntityManager", transactionManagerRef = "transactionManager")
public class OrderConfig {
    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;
//    @Value("${spring.datasource.order.jdbc-url}")
//    private String url;
//    @Value("${spring.datasource.order.username}")
//    private String username;
//    @Value("${spring.datasource.order.password}")
//    private String password;

    @Bean(name = "orderDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.order")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.two-data")
    public DataSource orderDataSource() {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
//        atomikosDataSourceBean.setUniqueResourceName("orderDataSource");
//        Properties properties = new Properties();
//        properties.setProperty("url", url);
//        properties.setProperty("user", username);
//        properties.setProperty("password", password);
//        atomikosDataSourceBean.setXaProperties(properties);
//        atomikosDataSourceBean.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        return atomikosDataSourceBean;
    }

    @Bean(name = "orderEntityManager")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean orderEntityManager() throws Throwable {
        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(orderDataSource());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setPackagesToScan("com.domain.order");
        entityManager.setPersistenceUnitName("orderPersistenceUnit");
        entityManager.setJpaPropertyMap(properties);
        return entityManager;
    }
}
