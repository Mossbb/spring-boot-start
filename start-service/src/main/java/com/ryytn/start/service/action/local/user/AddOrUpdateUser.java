package com.ryytn.start.service.action.local.user;

import cn.hutool.core.bean.BeanUtil;
import com.ryytn.start.common.dto.request.UserAddOrUpdateReq;
import com.ryytn.start.dao.domain.TblUser;
import com.ryytn.start.dao.service.TblUserService;
import com.ryytn.start.service.action.AbstractAction;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * UpdateUser
 *
 * @author tony
 * @date 4/7/23
 */
@Component
public class AddOrUpdateUser extends AbstractAction<UserAddOrUpdateReq, Boolean> {

  @Resource
  private TblUserService tblUserService;

  @Override
  protected Boolean doInvoke(UserAddOrUpdateReq request) {
    TblUser tblUser = new TblUser();
    BeanUtil.copyProperties(request, tblUser, true);

//    if (Objects.isNull(tblUser.getId())) {
//      tblUserMapper.insert(tblUser);
//    } else {
//      tblUserMapper.updateById(tblUser);
//    }

    return tblUserService.saveOrUpdate(tblUser);
  }

  @Override
  protected String actionName() {
    return "更新用户信息";
  }
}
