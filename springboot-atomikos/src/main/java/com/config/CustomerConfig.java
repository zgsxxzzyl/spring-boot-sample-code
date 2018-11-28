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
@EnableJpaRepositories(basePackages = "com.repository.customer", entityManagerFactoryRef = "customerEntityManager", transactionManagerRef = "transactionManager")
public class CustomerConfig {

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

//    @Value("${spring.datasource.customer.jdbc-url}")
//    private String url;
//    @Value("${spring.datasource.customer.username}")
//    private String username;
//    @Value("${spring.datasource.customer.password}")
//    private String password;

    @Bean(name = "customerDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.one-data")
//    @ConfigurationProperties(prefix = "spring.datasource.customer")
    public DataSource customerDataSource() {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
//        atomikosDataSourceBean.setUniqueResourceName("customerDataSource");
//        Properties properties = new Properties();
//        properties.setProperty("url", url);
//        properties.setProperty("user", username);
//        properties.setProperty("password", password);
//        atomikosDataSourceBean.setXaProperties(properties);
//        atomikosDataSourceBean.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        return atomikosDataSourceBean;
    }

    @Bean(name = "customerEntityManager")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean customerEntityManager() throws Throwable {
        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(customerDataSource());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setPackagesToScan("com.domain.customer");
        entityManager.setPersistenceUnitName("customerPersistenceUnit");
        entityManager.setJpaPropertyMap(properties);
        return entityManager;
    }

}
