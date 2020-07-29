package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import java.util.Date;

/**
 * 设备历史属性
 * @author ChengQi
 * @date 2020/7/7
 */
public class DeviceHistoryProperty {

    /**
     * 属性功能点上报值
     */
    private Object value;

    /**
     * 属性功能点上报时间
     */
    private Date time;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
