package com.ryytn.start.service.action.local.user;

import cn.hutool.core.bean.BeanUtil;
import com.ryytn.start.dao.domain.TblUser;
import com.ryytn.start.dao.service.TblUserService;
import com.ryytn.start.manager.dto.request.UserAddOrUpdateReq;
import com.ryytn.start.service.action.AbstractAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UpdateUser
 *
 * @author tony
 * @date 4/7/23
 */
@Component
public class AddOrUpdateUser extends AbstractAction<UserAddOrUpdateReq, Boolean> {

  @Autowired
  private TblUserService tblUserService;

  @Override
  protected Boolean doInvoke(UserAddOrUpdateReq request) {
    TblUser tblUser = new TblUser();
    BeanUtil.copyProperties(request, tblUser, true);
    boolean saveOrUpdate = tblUserService.saveOrUpdate(tblUser);
    return saveOrUpdate;
  }

  @Override
  protected String actionName() {
    return "更新用户信息";
  }
}
