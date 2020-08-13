package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.AbstractResponse;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.EmitCondition;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;

import java.util.Date;
import java.util.List;

/**
 * 场景联动规则详情响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/querySceneRuleDetail.html">
 *     场景联动规则详情</a>
 * @author ChengQi
 * @date 2020/7/8
 */
public class QuerySceneRuleDetailResponse extends AbstractResponse {

    /**
     * 规则名称
     */
    private String name;

    /**
     * 执行条件
     */
    @JSONField(name = "emit_condition", deserializeUsing = ValueHolderDeserializer.class)
    private EmitCondition emitCondition;

    /**
     * 触发方式集合
     */
    private List<ConditionExpand> conditions;

    /**
     * 执行动作集合
     */
    private List<ActionExpand> actions;

    /**
     * 创建时间
     */
    @JSONField(name = "created_at", format = Constant.DATE_TIME_FORMAT)
    private Date createdAt;

    /**
     * 更新时间
     */
    @JSONField(name = "updated_at", format = Constant.DATE_TIME_FORMAT)
    private Date updatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmitCondition getEmitCondition() {
        return emitCondition;
    }

    public void setEmitCondition(EmitCondition emitCondition) {
        this.emitCondition = emitCondition;
    }

    public List<ConditionExpand> getConditions() {
        return conditions;
    }

    public void setConditions(List<ConditionExpand> conditions) {
        this.conditions = conditions;
    }

    public List<ActionExpand> getActions() {
        return actions;
    }

    public void setActions(List<ActionExpand> actions) {
        this.actions = actions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
