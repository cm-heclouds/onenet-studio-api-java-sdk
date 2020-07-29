package com.github.cm.heclouds.onenet.studio.api.entity.common;

/**
 * 设备编辑请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/updateDevice.html">设备编辑</a>
 * @author ChengQi
 * @date 2020-07-06 10:15
 */
public class UpdateDeviceRequest extends BaseCommonRequest<UpdateDeviceResponse> {

    public UpdateDeviceRequest() {
        super(Method.POST, "UpdateDevice");
    }

    /**
     * 设置设备名称参数
     * @param deviceName 设备名称
     */
    public void setDeviceName(String deviceName) {
        bodyParam("device_name", deviceName);
    }

    /**
     * 设置设备描述参数
     * @param desc 设备描述
     */
    public void setDesc(String desc) {
        bodyParam("desc", desc);
    }

    @Override
    protected Class<UpdateDeviceResponse> getResponseType() {
        return UpdateDeviceResponse.class;
    }
}
