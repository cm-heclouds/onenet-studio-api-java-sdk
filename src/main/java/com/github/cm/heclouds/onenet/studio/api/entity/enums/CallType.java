package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 调用方式 枚举类型
 * @author ChengQi
 * @date 2020/10/14
 */
public enum CallType implements ValueHolder<String> {

    /**
     * 同步
     */
    SYNC("s"),
    /**
     * 异步
     */
    ASYNC("a");

    private final String value;

    CallType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
