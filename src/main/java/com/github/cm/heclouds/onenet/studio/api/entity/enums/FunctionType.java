package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 是否是标准功能点
 * @author ChengQi
 * @date 2020/10/14
 */
public enum FunctionType implements ValueHolder<String> {

    /**
     * 自定义
     */
    CUSTOM("u"),
    /**
     * 系统
     */
    SYSTEM("s");

    private final String value;

    FunctionType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
