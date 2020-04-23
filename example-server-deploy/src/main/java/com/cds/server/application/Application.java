/**
 * @Project example-server-deploy
 * @Package com.cds.server.application
 * @Class Application.java
 * @Date Apr 23, 2020 4:47:02 PM
 * @Copyright (c) 2020 CandleDrums.com All Right Reserved.
 */
package com.cds.server.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

/**
 * @Description 启动
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@EnableEncryptableProperties
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.cds")
@ComponentScan(basePackages = {"com.cds"})
@MapperScan(basePackages = {"com.cds.dep.example.dal.dao"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("启动成功");
    }
}
