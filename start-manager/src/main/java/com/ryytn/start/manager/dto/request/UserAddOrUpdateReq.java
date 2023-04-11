package com.ryytn.start.manager.dto.request;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * UserAddOrUpdateReq
 *
 * @author tony
 * @date 4/7/23
 */
@Data
public class UserAddOrUpdateReq implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  @NotBlank(message = "USER_NAME_NOT_BLANK")
  private String name;
  private Integer age;

}
