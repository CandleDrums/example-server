/**
 * @Project account-center-deploy
 * @Package com.youwe.deploy.application.config
 * @Class   FeignDateFormatRegister.java
 * @Date    Oct 21, 2019 11:39:02 AM
 * @Copyright (c) 2019 YOUWE All Right Reserved. 
 */
package com.cds.server.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.cloud.netflix.feign.FeignFormatterRegistrar;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;

/**
 * @Description feign 日期格式化
 * @Notes 未填写备注
 * @author liming
 * @Date Oct 21, 2019 11:39:02 AM
 * @version 1.0
 * @since JDK 1.8
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