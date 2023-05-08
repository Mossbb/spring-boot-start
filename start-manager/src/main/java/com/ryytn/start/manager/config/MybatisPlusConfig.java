package com.ryytn.start.manager.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuxukang
 * @create 2021/11/16 下午4:25
 */
@Configuration
public class MybatisPlusConfig {
	
	/**
	 * 转义拦截器
	 *
	 * @return LikeEscapeInterceptor
	 */
	@Bean
	public LikeEscapeInterceptor likeEscapeInterceptor() {
		return new LikeEscapeInterceptor();
	}
	
	/**
	 * 分页拦截器
	 *
	 * @return MybatisPlusInterceptor
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
		return interceptor;
	}
	
}
