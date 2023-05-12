package com.ryytn.start.api.service;

import com.ryytn.start.common.dto.request.UserAddOrUpdateReq;

/**
 * DubboUserService
 *
 * @author tony
 * @date 5/11/23
 */
public interface DubboUserService {

  boolean addOrUpdateUser(UserAddOrUpdateReq req);

}
