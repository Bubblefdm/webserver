package com.stopec.gy.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.stopec.gy.mapper"})
public class MybatisConfig {

    private Logger logger = LoggerFactory.getLogger(MybatisConfig.class);

    @Autowired
    private MybatisConfigProperties mybatisConfigProperties;


    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(this.mybatisConfigProperties.getUrl());
        dataSource.setUsername(this.mybatisConfigProperties.getUsername());
        dataSource.setPassword(this.mybatisConfigProperties.getPassword());
        dataSource.setDriverClassName(this.mybatisConfigProperties.getDriverClassName());
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource myqlDataSource) {
        return new DataSourceTransactionManager(myqlDataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        DataSource d = dataSource();
        fb.setDataSource(d);
        PathMatchingResourcePatternResolver mappers = new PathMatchingResourcePatternResolver();
        Resource[] mapperResources = mappers.getResources("classpath*:/mapper/*.xml");
        fb.setMapperLocations(mapperResources);
        fb.setTypeHandlersPackage("com.stopec.gy.pojo," +
                "com.stopec.gy.mybatis.handler.pojo");
        fb.setPlugins(new Interceptor[]{pageHelper()});
        try {
            return fb.getObject();
        } catch (Exception e) {
            logger.error("SqlSessionFactory创建失败{}", e);
        }
        return null;
    }

    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
//        p.setProperty("offsetAsPageNum", "true");
//        p.setProperty("rowBoundsWithCount", "true");
//        p.setProperty("reasonable", "true");
        p.setProperty("dialect", "mysql");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
