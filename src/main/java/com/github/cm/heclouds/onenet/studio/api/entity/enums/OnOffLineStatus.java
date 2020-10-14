package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 设备在线状态 枚举类型
 * @author ChengQi
 * @date 2020-07-10 16:46
 */
public enum OnOffLineStatus implements ValueHolder<Integer> {

    /**
     * 在线
     */
    ONLINE(1),
    /**
     * 离线
     */
    OFFLINE(0);

    private final Integer value;

    OnOffLineStatus(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
