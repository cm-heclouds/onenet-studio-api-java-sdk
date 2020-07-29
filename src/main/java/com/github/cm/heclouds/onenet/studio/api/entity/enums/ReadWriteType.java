package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 请求类型 枚举类型
 * @author ChengQi
 * @date 2020-07-10 16:54
 */
public enum ReadWriteType implements ValueHolder<Integer> {

    /**
     * 写
     */
    WRITE(0),
    /**
     * 读
     */
    READ(1);

    private Integer value;

    ReadWriteType(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
