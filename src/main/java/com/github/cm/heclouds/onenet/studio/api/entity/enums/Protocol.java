package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 协议 枚举类型
 * @author ChengQi
 * @date 2020-07-10 13:51
 */
public enum Protocol implements ValueHolder<Integer> {

    /**
     * 泛协议
     */
    GENERAL_PROTOCOL(1),
    /**
     * MQTT
     */
    MQTT(2),
    /**
     * CoAP
     */
    CoAP(3);

    private final Integer value;

    Protocol(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
