package com.ryytn.start.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * web相关配置
 *
 * @author xuxukang
 * @create 2021/10/8 上午10:13
 */
@Configuration
public class WebConfig {
	
	@Bean
	public WebMvcConfigurer configurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//设置允许跨域的路径
				registry.addMapping("/**")
					//设置允许跨域请求的域名
					.allowedOriginPatterns("*")
					//是否允许证书 不再默认开启
					.allowCredentials(true)
					//设置允许的方法
					.allowedMethods("*")
					//跨域允许时间
					.maxAge(3600)
					.allowedHeaders("*");
			}

			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/**")
					.addResourceLocations("classpath:/static/");
				registry.addResourceHandler("swagger-ui.html")
					.addResourceLocations("classpath:/META-INF/resources/");
				registry.addResourceHandler("/webjars/**")
					.addResourceLocations("classpath:/META-INF/resources/webjars/");
			}

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
				localeInterceptor.setParamName("lang");
				registry.addInterceptor(localeInterceptor);
			}
		};
	}
}
