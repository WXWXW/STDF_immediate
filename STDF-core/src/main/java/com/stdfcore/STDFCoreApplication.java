package com.stdfcore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.stdfcore.dao")
public class STDFCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(STDFCoreApplication.class, args);
    }

}
