package com.github.cm.heclouds.onenet.studio.api.entity.application.project;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 操作设备失败的错误信息
 * @author ChengQi
 * @date 2020-07-06 15:33
 */
public class ErrorData {

    /**
     * 操作失败设备名称
     */
    @JSONField(name = "device_name")
    private String deviceName;

    /**
     * 操作失败原因
     */
    private String cause;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
