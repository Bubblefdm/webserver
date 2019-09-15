package com.stopec.gy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
public class GyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GyApplication.class, args);
    }

}
