package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 节点类型 枚举类型
 * @author ChengQi
 * @date 2020-07-10 13:45
 */
public enum NodeType implements ValueHolder<Integer> {

    /**
     * 直连设备
     */
    DIRECTLY_CONNECT_DEVICE(1),
    /**
     * 网关设备
     */
    GATEWAY_CONNECT_DEVICE(2);

    private final Integer value;

    NodeType(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
