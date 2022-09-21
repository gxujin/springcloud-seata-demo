package com.cc.app.gws;


import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients()
@MapperScan({"com.cc.app.*.dao"})
@EnableAutoDataSourceProxy
public class ApiGwsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGwsApplication.class, args);
    }
}
