package com.github.cm.heclouds.onenet.studio.api.entity.common;

/**
 * 设备创建请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/createDevice.html">设备创建</>
 * @author ChengQi
 * @date 2020-07-02 14:17
 */
public class CreateDeviceRequest extends BaseCommonRequest<CreateDeviceResponse> {

    public CreateDeviceRequest() {
        super(Method.POST, "CreateDevice");
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
    protected Class<CreateDeviceResponse> getResponseType() {
        return CreateDeviceResponse.class;
    }
}
