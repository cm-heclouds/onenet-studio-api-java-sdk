package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.github.cm.heclouds.onenet.studio.api.IotResponse;

import java.util.HashMap;

/**
 * 设备属性期望查询响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryDeviceDesiredProperty.html">设备属性期望查询</a>
 * @author ChengQi
 * @date 2020/7/7
 */
public class QueryDeviceDesiredPropertyResponse extends HashMap<String, DesiredProperty> implements IotResponse {

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
