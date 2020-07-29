package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.github.cm.heclouds.onenet.studio.api.IotResponse;

/**
 * 设备创建响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/createDevice.html">设备创建</>
 * @author ChengQi
 * @date 2020-07-02 14:17
 */
public class CreateDeviceResponse extends DeviceDetail implements IotResponse {

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
