package com.ryytn.start.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName tbl_user
 */
@TableName(value = "tbl_user")
@Data
public class TblUser implements Serializable {

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /**
   * 姓名
   */
  @TableField(value = "name")
  private String name;

  /**
   * 年龄
   */
  @TableField(value = "age")
  private Integer age;

  /**
   * 创建时间
   */
  @TableField(value = "create_time")
  private Date createTime;

  /**
   * 更新时间
   */
  @TableField(value = "update_time")
  private Date updateTime;

  @TableField(exist = false)
  private static final long serialVersionUID = 1L;

}