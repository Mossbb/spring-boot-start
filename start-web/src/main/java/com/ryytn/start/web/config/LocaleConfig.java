package com.ryytn.start.web.config;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * @author xuxukang
 * @since 2020-10-14
 */
@Configuration
public class LocaleConfig {

	@Bean
	public LocaleResolver localeResolver() {
		// 设置默认语言
		Locale.setDefault(Locale.forLanguageTag("zh-CN"));
		// 指定从请求头中获取语言地区信息
		return new AcceptHeaderLocaleResolver();
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		final ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setDefaultEncoding("UTF-8");
		/*
		自定义资源文件目录，不同的报错放在不同的资源文件中
		validation：参数&业务校验异常
		message：需要返回给前端的非报错信息
		*/
		source.setBasenames("i18n/validation","i18n/message");
		source.setFallbackToSystemLocale(true);
		return source;
	}
}
