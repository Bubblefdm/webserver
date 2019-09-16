package com.stopec.gy.mybatis;

import com.stopec.gy.mybatis.handler.AutoTableTKMapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;


@Configuration
@AutoConfigureAfter({MybatisConfig.class})
public class MybatisScanner {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        AutoTableTKMapperScannerConfigurer mapperScannerConfigurer = new AutoTableTKMapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.stopec.gy.mapper");
        Properties properties = new Properties();
        properties.setProperty("mappers", "com.stopec.gy.mybatis.IMapper");
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        mapperScannerConfigurer.setPacks("com.stopec.gy.pojo");
        mapperScannerConfigurer.setTableAuto("update");
        return mapperScannerConfigurer;
    }
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        mapperScannerConfigurer.setBasePackage("com.stopec.deploy.config.core.dao.mapper");
//        Properties properties = new Properties();
//        properties.setProperty("mappers", "com.stopec.deploy.mybatis.IMapper");
//        properties.setProperty("notEmpty", "false");
//        properties.setProperty("IDENTITY", "MYSQL");
//        mapperScannerConfigurer.setProperties(properties);
//        return mapperScannerConfigurer;
//    }
}
