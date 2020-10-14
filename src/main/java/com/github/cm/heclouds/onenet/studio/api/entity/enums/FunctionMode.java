package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 功能点类型 枚举类型
 * @author ChengQi
 * @date 2020/10/14
 */
public enum FunctionMode implements ValueHolder<String> {

    /**
     * 属性类型
     */
    PROPERTY("property"),
    /**
     * 事件类型
     */
    EVENT("event"),
    /**
     * 服务类型
     */
    SERVICE("service");

    private final String value;

    FunctionMode(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
