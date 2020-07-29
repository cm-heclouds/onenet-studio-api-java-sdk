package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.github.cm.heclouds.onenet.studio.api.IotResponse;

import java.util.ArrayList;

/**
 * 设备批量创建响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/batchCreateDevice.html">设备批量创建</>
 * @author ChengQi
 * @date 2020-07-03 15:06
 */
public class BatchCreateDevicesResponse extends ArrayList<DeviceDetail> implements IotResponse {

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
