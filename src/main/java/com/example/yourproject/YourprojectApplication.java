package com.example.yourproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.yourproject.mapper")
public class YourprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(YourprojectApplication.class, args);
    }

}
