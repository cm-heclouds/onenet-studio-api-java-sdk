package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.EventType;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;

import java.util.Date;

/**
 * 设备历史事件
 * @author ChengQi
 * @date 2020/7/7
 */
public class DeviceHistoryEvent {

    /**
     * 事件类型
     */
    @JSONField(name = "event_type", deserializeUsing = ValueHolderDeserializer.class)
    private EventType eventType;

    /**
     * 事件功能点标识
     */
    private String identifier;

    /**
     * 事件功能点名称
     */
    private String name;

    /**
     * 事件功能点上报时间
     */
    private Date time;

    /**
     * 事件功能点上报值
     */
    private String value;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
