package com.ryytn.start.common.utils;

import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public final class MessageUtil implements DisposableBean, ApplicationContextAware {

	private static ApplicationContext context;


	public static ApplicationContext getApplicationContext() {
		return context;
	}

	/**
	 * 实现ApplicationContextAware的类，Spring会自动把ApplicationContext注入进来
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		context = applicationContext;
	}

	/**
	 * ApplicationContext有国际化的功能是因为ApplicationContext继承了MessageSource
	 */
	public static String getMessage(String code, Object... args) {
		if (context != null && StringUtils.isNotBlank(code)) {
			return context.getMessage(code, args, LocaleContextHolder.getLocale());
		} else {
			throw new NoSuchMessageException(code);
		}
	}

	public static String getMessage(String code, Locale locale, Object... args) {
		if (context != null && StringUtils.isNotBlank(code)) {
			return context.getMessage(code, args, locale);
		} else {
			throw new NoSuchMessageException(code);
		}
	}

	public static String getMessage(String code) {
		return getMessage(code, (Object) null);
	}

	@Override
	public void destroy() {
		context = null;
	}

}
