package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

/**
 * 设备属性期望设置请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/setDeviceDesiredProperty.html">
 *     设备属性期望设置</a>
 * @author ChengQi
 * @date 2020-07-06 17:45
 */
public class SetDeviceDesiredPropertyRequest extends BaseDevicePropertyRequest<SetDeviceDesiredPropertyResponse> {

    public SetDeviceDesiredPropertyRequest() {
        super(Method.POST, "SetDeviceDesiredProperty");
    }

    @Override
    protected Class<SetDeviceDesiredPropertyResponse> getResponseType() {
        return SetDeviceDesiredPropertyResponse.class;
    }

    @Override
    protected SetDeviceDesiredPropertyResponse newResponse(String responseBody) {
        return new SetDeviceDesiredPropertyResponse();
    }
}
