package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 数据协议 枚举类型
 * @author ChengQi
 * @date 2020-07-10 16:05
 */
public enum DataProtocol implements ValueHolder<Integer> {

    /**
     * OneJson
     */
    ONE_JSON(1);

    private Integer value;

    DataProtocol(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
