package com.ryytn.start.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryytn.start.dao.domain.TblUser;
import com.ryytn.start.dao.mapper.TblUserMapper;
import com.ryytn.start.dao.service.TblUserService;
import org.springframework.stereotype.Service;

/**
 * @author xuxukang
 * @description 针对表【tbl_user】的数据库操作Service实现
 * @createDate 2023-03-10 11:29:23
 */
@Service
public class TblUserServiceImpl extends ServiceImpl<TblUserMapper, TblUser>
    implements TblUserService {

}




