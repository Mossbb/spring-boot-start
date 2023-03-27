package com.ryytn.start.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryytn.start.dao.domain.TblUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xuxukang
 * @description 针对表【tbl_user】的数据库操作Mapper
 * @createDate 2023-03-10 11:29:23
 * @Entity com.ryytn.start.dao.domain.TblUser
 */
@Mapper
public interface TblUserMapper extends BaseMapper<TblUser> {

}




