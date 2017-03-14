package com.github.cockpit.conf;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * DataSourceConf
 * Create on 2017/3/13
 *
 * @author Asin Liu
 * @version 1.0
 */

@Deprecated
//@Configuration
//@EnableTransactionManagement
public class DataSourceConf implements TransactionManagementConfigurer{

    @Resource
    private DataSource ds;

    // 创建事务管理器1
    @Bean(name = "txManager")
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * Return the default transaction manager bean to use for annotation-driven database
     * transaction management, i.e. when processing {@code @Transactional} methods.
     * <p>There are two basic approaches to implementing this method:
     * <h3>1. Implement the method and annotate it with {@code @Bean}</h3>
     * In this case, the implementing {@code @Configuration} class implements this method,
     * marks it with {@code @Bean} and configures and returns the transaction manager
     * directly within the method body:
     * <pre class="code">
     * &#064;Bean
     * &#064;Override
     * public PlatformTransactionManager annotationDrivenTransactionManager() {
     * return new DataSourceTransactionManager(dataSource());
     * }</pre>
     * <h3>2. Implement the method without {@code @Bean} and delegate to another existing
     * {@code @Bean} method</h3>
     * <pre class="code">
     * &#064;Bean
     * public PlatformTransactionManager txManager() {
     * return new DataSourceTransactionManager(dataSource());
     * }
     * <p>
     * &#064;Override
     * public PlatformTransactionManager annotationDrivenTransactionManager() {
     * return txManager(); // reference the existing {@code @Bean} method above
     * }</pre>
     * If taking approach #2, be sure that <em>only one</em> of the methods is marked
     * with {@code @Bean}!
     * <p>In either scenario #1 or #2, it is important that the
     * {@code PlatformTransactionManager} instance is managed as a Spring bean within the
     * container as all {@code PlatformTransactionManager} implementations take advantage
     * of Spring lifecycle callbacks such as {@code InitializingBean} and
     * {@code BeanFactoryAware}.
     */

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(ds);
    }
}
