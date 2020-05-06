/**
 * @Project example-server-deploy
 * @Package com.cds.server.config
 * @Class Swagger2Config.java
 * @Date [date]
 * @Copyright (c) 2019 CandleDrums.com All Right Reserved.
 */
package com.cds.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description swagger配置
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Example Server Api Doc").description("Example服务Api文档").version("1.0")
            .build();
    }

}
