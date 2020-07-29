package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.DataType;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;

import java.util.Date;

/**
 * 设备属性
 * @author ChengQi
 * @date 2020/7/7
 */
public class DeviceProperty {

    /**
     * 功能点标识
     */
    private String identifier;

    /**
     * 上报时间
     */
    private Date time;

    /**
     * 功能点上报值
     */
    private String value;

    /**
     * 数据类型
     */
    @JSONField(name = "data_type", deserializeUsing = ValueHolderDeserializer.class)
    private DataType dataType;

    /**
     * 读写类型
     */
    @JSONField(name = "access_mode")
    private String accessMode;

    /**
     * 期望值
     */
    @JSONField(name = "expect_value")
    private Object expectValue;

    /**
     * 功能点名称
     */
    private String name;

    /**
     * 功能描述
     */
    private String description;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public String getAccessMode() {
        return accessMode;
    }

    public void setAccessMode(String accessMode) {
        this.accessMode = accessMode;
    }

    public Object getExpectValue() {
        return expectValue;
    }

    public void setExpectValue(Object expectValue) {
        this.expectValue = expectValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
