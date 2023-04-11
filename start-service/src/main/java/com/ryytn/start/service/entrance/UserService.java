package com.ryytn.start.service.entrance;

import cn.hutool.extra.spring.SpringUtil;
import com.ryytn.start.manager.dto.request.UserAddOrUpdateReq;
import com.ryytn.start.service.action.local.user.AddOrUpdateUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author tony
 * @date 4/7/23
 */
@Service
@Slf4j
public class UserService {

  public boolean addOrUpdateUser(UserAddOrUpdateReq req) {
    return SpringUtil.getBean(AddOrUpdateUser.class).invoke(req);
  }

}
