package com.zjh.j2eework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories("com.zjh.j2eework.dao.es")

@MapperScan("com.zjh.j2eework.dao.mapper")
public class J2EeWorkApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(J2EeWorkApplication.class, args);
    }
    
}
