package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.github.cm.heclouds.onenet.studio.api.AbstractRequest;

/**
 * 设备删除请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/deleteDevice.html">设备删除</a>
 * @author ChengQi
 * @date 2020-07-06 10:36
 */
public class DeleteDeviceRequest extends BaseCommonRequest<DeleteDeviceResponse> {

    public DeleteDeviceRequest() {
        super(AbstractRequest.Method.POST, "DeleteDevice");
    }

    /**
     * 设置设备名称参数
     * @param deviceName 设备名称
     */
    public void setDeviceName(String deviceName) {
        bodyParam("device_name", deviceName);
    }

    @Override
    protected Class<DeleteDeviceResponse> getResponseType() {
        return DeleteDeviceResponse.class;
    }

    @Override
    protected DeleteDeviceResponse newResponse(String responseBody) {
        return new DeleteDeviceResponse();
    }
}
