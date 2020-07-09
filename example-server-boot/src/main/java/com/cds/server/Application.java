/**
 * @Project example-server-boot
 * @Package com.cds.server
 * @Class Application.java
 * @Date [date]
 * @Copyright [copyright]
 */
package com.cds.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 启动项目
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@EnableEncryptableProperties
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.cds")
@ComponentScan(basePackages = {"com.cds"})
@MapperScan(basePackages = {"com.cds.example.dep.dal.dao"})
@Slf4j
@EnableApolloConfig
public class Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        // 关闭banner
        springApplication.setBannerMode(Banner.Mode.OFF);
        // 允许类名重复
        springApplication.setAllowBeanDefinitionOverriding(true);
        // 启动
        springApplication.run(args);
        // 启动成功
        System.out.println("------------------------------------------------");
        System.out.println("  ___   _   _    ___    ___    ___   ___   ___ ");
        System.out.println(" / __| | | | |  / __|  / __|  / _ \\ / __| / __|");
        System.out.println(" \\__ \\ | |_| | | (__  | (__  |  __/ \\__ \\ \\__ \\");
        System.out.println(" |___/  \\__,_|  \\___|  \\___|  \\___| |___/ |___/");
        System.out.println("------------------------------------------------");
    }
}
