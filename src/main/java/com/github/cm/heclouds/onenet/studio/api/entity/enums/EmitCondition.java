package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.alibaba.fastjson.annotation.JSONType;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderSerializer;

/**
 * 触发方式 枚举类型
 * @author ChengQi
 * @date 2020-07-10 17:32
 */
@JSONType(
        serializer = ValueHolderSerializer.class,
        deserializer = ValueHolderDeserializer.class,
        serializeEnumAsJavaBean = true)
public enum EmitCondition implements ValueHolder<String> {

    /**
     * 满足全部条件触发
     */
    ALL("all"),
    /**
     * 任意条件触发
     */
    ANY("any");

    private String value;

    EmitCondition(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
