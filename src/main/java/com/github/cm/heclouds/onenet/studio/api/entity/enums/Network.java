package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 联网模式 枚举类型
 * @author ChengQi
 * @date 2020-07-10 16:08
 */
public enum Network implements ValueHolder<Integer> {

    /**
     * 其他
     */
    OTHER(1),
    /**
     * 蜂窝
     */
    HONEYCOMB(2),
    /**
     * wifi
     */
    WIFI(3),
    /**
     * 以太网
     */
    ETHERNET(4);

    private final Integer value;

    Network(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
