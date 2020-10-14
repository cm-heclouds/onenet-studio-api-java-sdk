package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.github.cm.heclouds.onenet.studio.api.IotResponse;

import java.util.HashMap;

/**
 * 调用服务响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/callService.html">调用服务</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class CallServiceResponse extends HashMap<String, Object> implements IotResponse {

    private String requestId;

    @Override
    public String getRequestId() {
        return requestId;
    }

    @Override
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
