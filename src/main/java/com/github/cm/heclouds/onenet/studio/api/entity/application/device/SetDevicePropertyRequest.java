package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

/**
 * 设备属性设置请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/setDeviceProperty.html">设备属性设置</a>
 * @author ChengQi
 * @date 2020-07-06 17:20
 */
public class SetDevicePropertyRequest extends BaseDevicePropertyRequest<SetDevicePropertyResponse> {

    public SetDevicePropertyRequest() {
        super(Method.POST, "SetDeviceProperty");
    }

    @Override
    protected Class<SetDevicePropertyResponse> getResponseType() {
        return SetDevicePropertyResponse.class;
    }
}
