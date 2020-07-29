package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 设备来源 枚举类型
 * @author ChengQi
 * @date 2020-07-10 16:29
 */
public enum From implements ValueHolder<Integer> {

    /**
     * 自主创建
     */
    CREATED_AUTONOMY(1),
    /**
     * 他人转移
     */
    TRANSFERRED_BY_OTHERS(2);

    private Integer value;

    From(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
