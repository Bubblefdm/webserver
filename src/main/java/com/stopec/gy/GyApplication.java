package com.stopec.gy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class GyApplication  extends SpringBootServletInitializer {
//    //    使用自带tomcat启动
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(GyApplication.class);
//    }
    public static void main(String[] args) {
        SpringApplication.run(GyApplication.class, args);
    }

}
