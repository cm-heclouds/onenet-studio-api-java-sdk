package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.DataType;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderSerializer;

/**
 * 功能点数据
 * @author ChengQi
 * @date 2020/10/14
 */
public class DataTypeMeta {

    /**
     * 数据类型
     */
    @JSONField(serializeUsing = ValueHolderSerializer.class, deserializeUsing = ValueHolderDeserializer.class)
    private DataType type;

    /**
     * 数据类型描述信息
     */
    private Object specs;

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public Object getSpecs() {
        return specs;
    }

    public void setSpecs(Object specs) {
        this.specs = specs;
    }
}
