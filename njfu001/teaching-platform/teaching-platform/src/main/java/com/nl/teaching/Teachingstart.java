package com.nl.teaching;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nl.teaching.mapper")
public class Teachingstart {
    public static void main(String[] args) {
        SpringApplication.run(Teachingstart.class, args);
    }
}
