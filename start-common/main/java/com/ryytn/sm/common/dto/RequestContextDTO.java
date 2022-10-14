package com.ryytn.sm.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

/**
 * <p>上下文基础请求<br/>
 * 封装基础信息,包含请求url，用户信息等
 * </p>
 *
 * @author yinxin
 * @since 2022/10/14
 */
@Data
public class RequestContextDTO implements Serializable {
    private String requestId = UUID.randomUUID().toString();
    /**
     * 请求的ip
     */
    private String ip;
    /**
     * 请求的url
     */
    private String requestUrl;
    /**
     * 业务参数
     */
    private Map<String, Object> bizData;
}
