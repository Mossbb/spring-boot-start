package com.ryytn.start.common.enums;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * redis key enum and util
 *
 * @author xuxukang
 * @create 2022/1/2 8:12 PM
 */
@AllArgsConstructor
@Getter
public enum RedisKeyEnum {
	
	TEST_STRING("test_string", "测试string"),
	;
	
	private final String key;
	private final String desc;
	
	/**
	 * 构建最终redis key
	 *
	 * @param suffixs key里的后缀，比如id
	 * @return start:dev:{RedisKeyEnum.getKey()}:suffix1:suffix1
	 */
	public String getFinalKey(String... suffixs) {
		String[] strings = new String[suffixs.length + 3];
		strings[0] = SpringUtil.getApplicationName();
		strings[1] = SpringUtil.getActiveProfile();
		strings[2] = this.getKey();
		ArrayUtil.copy(suffixs, 0, strings, 3, suffixs.length);
		return StringUtils.join(strings, StrUtil.COLON);
	}

}
