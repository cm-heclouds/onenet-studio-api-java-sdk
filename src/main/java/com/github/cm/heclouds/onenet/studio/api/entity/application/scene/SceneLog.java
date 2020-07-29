package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;

import java.util.Date;
import java.util.List;

/**
 * 场景联动触发日志
 * @author ChengQi
 * @date 2020/7/8
 */
public class SceneLog {

    /**
     * 联动规则ID
     */
    @JSONField(name = "scene_id")
    private String sceneId;

    /**
     * 执行结果
     */
    private String status;

    /**
     * 触发时间
     */
    @JSONField(name = "created_at", format = Constant.DATE_TIME_FORMAT)
    private Date createdAt;

    /**
     * 触发条件
     */
    private List<Condition> conditions;

    /**
     * 执行动作结果
     */
    private List<ActionResult> actions;

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public List<ActionResult> getActions() {
        return actions;
    }

    public void setActions(List<ActionResult> actions) {
        this.actions = actions;
    }
}
