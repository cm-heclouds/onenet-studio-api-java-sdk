package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 触发方式 枚举类型
 * @author ChengQi
 * @date 2020-07-10 17:34
 */
public enum CType implements ValueHolder<String> {

    /**
     * 设备生命周期
     */
    LIFECYCLE("lifecycle"),
    /**
     * 设备数据上报
     */
    NOTIFY("notify");

    private String value;

    CType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
