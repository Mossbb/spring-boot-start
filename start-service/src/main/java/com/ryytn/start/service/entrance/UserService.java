package com.ryytn.start.service.entrance;

import cn.hutool.extra.spring.SpringUtil;
import com.ryytn.start.api.service.DubboUserService;
import com.ryytn.start.common.dto.request.UserAddOrUpdateReq;
import com.ryytn.start.service.action.local.user.AddOrUpdateUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author tony
 * @date 4/7/23
 */
@DubboService(version = "1.0.0", interfaceClass = DubboUserService.class)
@Service
@Slf4j
public class UserService implements DubboUserService {

  public boolean addOrUpdateUser(UserAddOrUpdateReq req) {
    return SpringUtil.getBean(AddOrUpdateUser.class).invoke(req);
  }

}
