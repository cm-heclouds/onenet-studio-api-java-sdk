package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 设备状态 枚举类型
 * @author ChengQi
 * @date 2020-07-10 15:47
 */
public enum Status implements ValueHolder<Integer> {

    /**
     * 未激活
     */
    INACTIVE(1),
    /**
     * 在线
     */
    ONLINE(2),
    /**
     * 离线
     */
    OFFLINE(3);

    private Integer value;

    Status(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
