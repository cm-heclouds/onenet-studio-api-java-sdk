package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 事件类型 枚举类型
 * @author ChengQi
 * @date 2020-07-10 17:22
 */
public enum EventType implements ValueHolder<Integer> {

    /**
     * 信息
     */
    MESSAGE(1),
    /**
     * 告警
     */
    ALARM(2),
    /**
     * 故障
     */
    FAULT(3);

    private Integer value;

    EventType(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
