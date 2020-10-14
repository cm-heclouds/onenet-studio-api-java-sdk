package com.github.cm.heclouds.onenet.studio.api.entity.application.group;

import com.github.cm.heclouds.onenet.studio.api.IotResponse;
import com.github.cm.heclouds.onenet.studio.api.entity.application.project.ErrorData;

import java.util.ArrayList;

/**
 * 分组设备移除响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/removeGroupDevice.html">分组设备移除</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class RemoveGroupDeviceResponse extends ArrayList<ErrorData> implements IotResponse {

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
