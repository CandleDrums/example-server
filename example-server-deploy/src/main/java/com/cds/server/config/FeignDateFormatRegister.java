/**
 * @Project example-server-deploy
 * @Package com.cds.server.config
 * @Class FeignDateFormatRegister.java
 * @Date [date]
 * @Copyright (c) 2019 CandleDrums.com All Right Reserved.
 */
package com.cds.server.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;

/**
 * @Description 日期格式化
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@Component
public class FeignDateFormatRegister implements FeignFormatterRegistrar {

    public FeignDateFormatRegister() {

    }

    @Override
    public void registerFormatters(FormatterRegistry registry) {
        registry.addConverter(Date.class, String.class, new Date2StringConverter());
    }

    private class Date2StringConverter implements Converter<Date, String> {
        @Override
        public String convert(Date source) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            return sdf.format(source);
        }

    }
}