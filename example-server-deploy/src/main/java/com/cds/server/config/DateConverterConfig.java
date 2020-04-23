/**
 * @Project account-center-deploy
 * @Package com.youwe.deploy.application.config
 * @Class DateConverterConfig.java
 * @Date Oct 21, 2019 11:38:19 AM
 * @Copyright (c) 2019 YOUWE All Right Reserved.
 */
package com.cds.server.config;

import java.text.ParseException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.cds.base.common.exception.YouWeBizException;

/**
 * @Description 日期转换配置
 * @Notes 未填写备注
 * @author liming
 * @Date Oct 21, 2019 11:38:19 AM
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class DateConverterConfig {

    @Resource
    private RequestMappingHandlerAdapter handlerAdapter;

    private static final String[] DATE_FORMAT =
        new String[] {"yyyy-MM-dd HH:mm:ss SSS", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"};

    /**
     * Fegin服务器端日期类型处理
     */
    @PostConstruct
    public void initEditableValidation() {
        ConfigurableWebBindingInitializer initializer =
            (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
        if (initializer.getConversionService() != null) {
            GenericConversionService genericConversionService =
                (GenericConversionService)initializer.getConversionService();
            genericConversionService.addConverter(String.class, Date.class, new String2DateConverter());
        }
    }

    private class String2DateConverter implements Converter<String, Date> {
        @Override
        public Date convert(String source) {
            if (source == null || source == "") {
                return null;
            }
            if (StringUtils.isNumeric(source)) {
                Long aLongDate = Long.valueOf(source);
                return new Date(aLongDate);
            } else {
                try {
                    return DateUtils.parseDate(source, DATE_FORMAT);
                } catch (ParseException e) {
                    throw new YouWeBizException("date parse exception");
                }
            }
        }
    }

}
