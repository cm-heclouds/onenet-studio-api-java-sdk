package com.github.cm.heclouds.onenet.studio.api.entity.application.project;

import com.github.cm.heclouds.onenet.studio.api.IotResponse;

import java.util.ArrayList;

/**
 * 项目设备移除响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/removeDevice.html">项目设备移除</a>
 * @author ChengQi
 * @date 2020-07-06 16:07
 */
public class RemoveDeviceResponse extends ArrayList<ErrorData> implements IotResponse {

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
