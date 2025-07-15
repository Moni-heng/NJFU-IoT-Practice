package com.nl.teaching.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(value = "com.nl.teaching.mapper") //mapper接口扫描
@EnableTransactionManagement  //事务管理开启
public class MybatisPlusConfig {

}