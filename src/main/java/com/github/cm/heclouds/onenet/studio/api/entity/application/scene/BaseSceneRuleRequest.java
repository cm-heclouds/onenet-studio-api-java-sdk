package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

import com.github.cm.heclouds.onenet.studio.api.IotResponse;
import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.EmitCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChengQi
 * @date 2020/7/8
 */
public abstract class BaseSceneRuleRequest<T extends IotResponse> extends BaseApplicationRequest<T> {

    private List<Condition> conditions = new ArrayList<>();

    private List<Action> actions = new ArrayList<>();

    public BaseSceneRuleRequest(String action) {
        super(Method.POST, action);
    }

    /**
     * 设置项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(String projectId) {
        bodyParam("project_id", projectId);
    }

    /**
     * 设置场景联动名称
     * @param name 场景联动名称
     */
    public void setName(String name) {
        bodyParam("name", name);
    }

    /**
     * 设置触发方式
     * @param emitCondition 触发方式
     */
    public void setEmitCondition(EmitCondition emitCondition) {
        bodyParam("emit_condition", emitCondition);
    }

    /**
     * 设置触发条件集合
     * @param conditions 触发条件集合
     */
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
        bodyParam("conditions", this.conditions);
    }

    /**
     * 添加触发条件
     * @param condition 触发条件
     */
    public void addCondition(Condition condition) {
        conditions.add(condition);
        bodyParam("conditions", this.conditions);
    }

    /**
     * 设置执行动作集合
     * @param actions 执行动作集合
     */
    public void setActions(List<Action> actions) {
        this.actions = actions;
        bodyParam("actions", this.actions);
    }

    /**
     * 添加执行动作
     * @param action 执行动作
     */
    public void addAction(Action action) {
        actions.add(action);
        bodyParam("actions", this.actions);
    }
}
