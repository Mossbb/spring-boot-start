package com.ryytn.start.dao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * mybatis数据源配置
 *
 * @author yinxin
 * @Classname DataSourceConfig
 * @since 2020-10-13
 */
@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class DataSourceConfig {

    @Value("${datasource.jdbc.url}")
    private String url;
    @Value("${datasource.username}")
    private String user;
    @Value("${datasource.password}")
    private String password;
    @Value("${datasource.driver.class.name}")
    private String driverClassName;
    @Value("${datasource.druid.max.active}")
    private Integer maxActive;
    @Value("${datasource.druid.max.wait}")
    private Long maxWait;
    @Value("${datasource.druid.initial.size}")
    private int initialSize;
    @Value("${datasource.druid.min.idle}")
    private int minIdleSize;
    @Value("${datasource.druid.validation.query}")
    private String validationQuery;
    @Value("${datasource.druid.time.between.eviction.runs.millis}")
    private int timeBetweenEvictionRuns;
    @Value("${datasource.druid.min.evictable.idle.time.millis}")
    private int timeMinEvictableIdle;
    @Value("${datasource.druid.test.on.borrow}")
    private boolean testOnBorrow;
    @Value("${datasource.druid.test.on.return}")
    private boolean testOnReturn;
    @Value("${datasource.druid.test.while.idle}")
    private boolean testWhileIdle;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(true);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdleSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRuns);
        dataSource.setMinEvictableIdleTimeMillis(timeMinEvictableIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setTestWhileIdle(testWhileIdle);
        return dataSource;
    }
}
