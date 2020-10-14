package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 属性读写类型
 * @author ChengQi
 * @date 2020/10/14
 */
public enum AccessMode implements ValueHolder<String> {

    /**
     * 只读
     */
    READ_ONLY("r"),
    /**
     * 读写
     */
    READ_WRITE("rw");

    private final String value;

    AccessMode(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
