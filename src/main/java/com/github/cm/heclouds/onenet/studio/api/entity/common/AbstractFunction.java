package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.FunctionMode;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.FunctionType;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderSerializer;

/**
 * 功能点信息抽象类
 * @see Property
 * @see Event
 * @see Service
 * @author ChengQi
 * @date 2020/10/14
 */
public abstract class AbstractFunction {

    /**
     * 功能点类型
     */
    @JSONField(serializeUsing = ValueHolderSerializer.class, deserializeUsing = ValueHolderDeserializer.class)
    private FunctionMode functionMode;

    /**
     * 唯一标识符（产品下唯一）
     */
    private String identifier;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String desc;

    /**
     * 是否是标准功能点
     */
    @JSONField(serializeUsing = ValueHolderSerializer.class, deserializeUsing = ValueHolderDeserializer.class)
    private FunctionType functionType;

    public FunctionMode getFunctionMode() {
        return functionMode;
    }

    public void setFunctionMode(FunctionMode functionMode) {
        this.functionMode = functionMode;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public FunctionType getFunctionType() {
        return functionType;
    }

    public void setFunctionType(FunctionType functionType) {
        this.functionType = functionType;
    }
}
