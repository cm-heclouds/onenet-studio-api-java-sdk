package com.github.cm.heclouds.onenet.studio.api.enums;

import com.alibaba.fastjson.annotation.JSONType;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderSerializer;

/**
 * @author ChengQi
 * @date 2020/7/7
 */
@JSONType(
        serializer = ValueHolderSerializer.class,
        deserializer = ValueHolderDeserializer.class,
        serializeEnumAsJavaBean = true)
public enum Sort implements ValueHolder<Integer> {

    /**
     * positive sequence
     */
    ASC(1),
    /**
     * reverse order
     */
    DESC(2);

    private final int value;

    Sort(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
