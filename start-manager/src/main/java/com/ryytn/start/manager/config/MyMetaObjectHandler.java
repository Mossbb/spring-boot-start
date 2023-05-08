package com.ryytn.start.manager.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author xuxukang
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

	private static final String UPDATE_TIME = "updateTime";
	private static final String CREATE_TIME = "createTime";

	@Override
	public void insertFill(MetaObject metaObject) {
		if (metaObject.getValue(CREATE_TIME) == null) {
			this.strictInsertFill(metaObject, CREATE_TIME, Date::new, Date.class);
		}
		if (metaObject.getValue(UPDATE_TIME) == null) {
			this.strictInsertFill(metaObject, UPDATE_TIME, Date::new, Date.class);
		}
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		// 起始版本 3.3.3(推荐)
		this.strictUpdateFill(metaObject, UPDATE_TIME, Date::new, Date.class);
	}

}
