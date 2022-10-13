package com.ryytn.start.dao.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yinxin
 * @Classname SqlSessionFactoryConfig
 * @since 2020-10-13
 */
 @Component
 @MapperScan(basePackages = {"com.ryytn.start.dao"}, sqlSessionFactoryRef = "mybatisSqlSessionFactory")
public class SqlSessionFactoryConfig {

    @Bean(name = "mybatisTransactionManager")
    public DataSourceTransactionManager mybatisTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mybatisSqlSessionFactory")
    public SqlSessionFactory mybatisSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
            throws Exception {

        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        Resource[] localMapperResources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:sqlmapper/*.xml");

        List<Resource> resourceList = new ArrayList<>(localMapperResources.length);
        resourceList.addAll(Arrays.asList(localMapperResources));

        Resource[] resources = new Resource[resourceList.size()];
        sessionFactory.setMapperLocations(resourceList.toArray(resources));
        return sessionFactory.getObject();
    }

    @Bean(name = "transactionTemplate")
    public TransactionTemplate transactionTemplate(@Qualifier("mybatisTransactionManager") DataSourceTransactionManager dataSourceTransactionManager) {

        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
        transactionTemplate.setTimeout(10000);
        transactionTemplate.setTransactionManager(dataSourceTransactionManager);
        return transactionTemplate;
    }
}
