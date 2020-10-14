package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.FunctionEventType;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderSerializer;

import java.util.List;

/**
 * 功能点类型 事件类型
 * @author ChengQi
 * @date 2020/10/14
 */
public class Event extends AbstractFunction {

    /**
     * 事件类型
     */
    @JSONField(serializeUsing = ValueHolderSerializer.class, deserializeUsing = ValueHolderDeserializer.class)
    private FunctionEventType eventType;

    /**
     * 参数
     */
    private List<Parameter> outputData;

    public FunctionEventType getEventType() {
        return eventType;
    }

    public void setEventType(FunctionEventType eventType) {
        this.eventType = eventType;
    }

    public List<Parameter> getOutputData() {
        return outputData;
    }

    public void setOutputData(List<Parameter> outputData) {
        this.outputData = outputData;
    }
}
