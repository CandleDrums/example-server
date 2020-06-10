/**
 * @Project example-server-boot
 * @Package com.cds.server
 * @Class Application.java
 * @Date [date]
 * @Copyright (c) 2019 CandleDrumS.com All Right Reserved
 */
package com.cds.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 启动
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@EnableEncryptableProperties
@EnableDiscoveryClient
@SpringBootApplication
@EnableAsync
@EnableFeignClients("com.cds")
@ComponentScan(basePackages = {"com.cds"})
@MapperScan(basePackages = {"com.cds.example.dep.dal.dao"})
@Slf4j
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("启动成功");
    }
}
