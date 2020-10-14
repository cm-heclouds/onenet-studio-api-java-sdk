package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.AccessMode;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderSerializer;

/**
 * 功能点类型 属性类型
 * @author ChengQi
 * @date 2020/10/14
 */
public class Property extends AbstractFunction {

    /**
     * 属性读写类型
     */
    @JSONField(serializeUsing = ValueHolderSerializer.class, deserializeUsing = ValueHolderDeserializer.class)
    private AccessMode accessMode;

    /**
     * 属性功能点数据
     */
    private DataTypeMeta dataType;

    public AccessMode getAccessMode() {
        return accessMode;
    }

    public void setAccessMode(AccessMode accessMode) {
        this.accessMode = accessMode;
    }

    public DataTypeMeta getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeMeta dataType) {
        this.dataType = dataType;
    }
}
