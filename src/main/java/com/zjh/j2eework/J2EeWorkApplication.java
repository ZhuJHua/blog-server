package com.zjh.j2eework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories("com.zjh.j2eework.dao.es")
@EnableJpaRepositories("com.zjh.j2eework.dao.jpa")
public class J2EeWorkApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(J2EeWorkApplication.class, args);
    }
    
}
