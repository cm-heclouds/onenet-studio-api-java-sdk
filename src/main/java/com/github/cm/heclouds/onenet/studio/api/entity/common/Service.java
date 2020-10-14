package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.CallType;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderSerializer;

import java.util.List;

/**
 * 功能点类型 服务类型
 * @author ChengQi
 * @date 2020/10/14
 */
public class Service extends AbstractFunction {

    /**
     * 调用方式
     */
    @JSONField(serializeUsing = ValueHolderSerializer.class, deserializeUsing = ValueHolderDeserializer.class)
    private CallType callType;

    /**
     * 输入参数
     */
    private List<Parameter> input;

    /**
     * 输出参数
     */
    private List<Parameter> output;

    public CallType getCallType() {
        return callType;
    }

    public void setCallType(CallType callType) {
        this.callType = callType;
    }

    public List<Parameter> getInput() {
        return input;
    }

    public void setInput(List<Parameter> input) {
        this.input = input;
    }

    public List<Parameter> getOutput() {
        return output;
    }

    public void setOutput(List<Parameter> output) {
        this.output = output;
    }
}
