package com.websit.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	/**
	 * 1.这个为解决中文乱码
	 *
	 * @Title: responseBodyConverter
	 * @description 
	 * @return HttpMessageConverter<String>    
	 * @author lujinpeng
	 * @createDate 2019年4月23日-下午4:05:38
	 */
	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		return converter;
	}

	/**
	 * 2.1：解决中文乱码后，返回json时可能会出现No converter found for return value of type: xxxx
	 *     或这个：Could not find acceptable representation
	 *     解决此问题如下
	 *
	 * @Title: getObjectMapper
	 * @description 
	 * @return ObjectMapper    
	 * @author lujinpeng
	 * @createDate 2019年4月23日-下午4:05:50
	 */
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}

	/**
	 * 2.2：解决No converter found for return value of type: xxxx
	 *
	 * @Title: messageConverter
	 * @description 
	 * @return MappingJackson2HttpMessageConverter    
	 * @author lujinpeng
	 * @createDate 2019年4月23日-下午4:07:51
	 */
	public MappingJackson2HttpMessageConverter messageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(getObjectMapper());
		return converter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		// 解决中文乱码
		converters.add(responseBodyConverter());
		/**
		 * 解决： 添加解决中文乱码后的配置之后，返回json数据直接报错 500：no convertter for return value of type
		 * 或这个：Could not find acceptable representation
		 */
		converters.add(messageConverter());
	}

	/** 允许跨域 */
	
/*	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
				.allowCredentials(false).maxAge(3600);
	}*/
	 

	/** 处理静态资源 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}

}
