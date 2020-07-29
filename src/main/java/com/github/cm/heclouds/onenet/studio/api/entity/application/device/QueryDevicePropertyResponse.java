package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.github.cm.heclouds.onenet.studio.api.IotResponse;

import java.util.ArrayList;

/**
 * 设备属性最新数据查询响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryDeviceProperty.html">
 *     设备属性最新数据查询</a>
 * @author ChengQi
 * @date 2020/7/7
 */
public class QueryDevicePropertyResponse extends ArrayList<DeviceProperty> implements IotResponse {

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
