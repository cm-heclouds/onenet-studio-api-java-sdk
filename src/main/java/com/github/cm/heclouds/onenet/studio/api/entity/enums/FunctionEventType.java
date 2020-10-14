package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 功能点事件类型 枚举类型
 * @author ChengQi
 * @date 2020/10/14
 */
public enum FunctionEventType implements ValueHolder<String> {

    /**
     * 信息
     */
    INFO("info"),
    /**
     * 告警
     */
    ALERT("alert"),
    /**
     * 错误
     */
    ERROR("error");

    private final String value;

    FunctionEventType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
