package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.AbstractResponse;

/**
 * 设备编辑响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/updateDevice.html">设备编辑</a>
 * @author ChengQi
 * @date 2020-07-06 10:16
 */
public class UpdateDeviceResponse extends AbstractResponse {

    /**
     * 设备名称
     */
    @JSONField(name = "device_name")
    private String deviceName;

    /**
     * 设备描述
     */
    private String desc;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
