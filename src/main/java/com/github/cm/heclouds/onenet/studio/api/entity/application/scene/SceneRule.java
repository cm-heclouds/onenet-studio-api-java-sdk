package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;

import java.util.Date;

/**
 * 场景联动规则
 * @author ChengQi
 * @date 2020/7/8
 */
public class SceneRule {

    /**
     * 规则名称
     */
    private String name;

    /**
     * 规则ID
     */
    @JSONField(name = "scene_id")
    private String sceneId;

    /**
     * 规则是否启用
     */
    private Boolean start;

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

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public Boolean getStart() {
        return start;
    }

    public void setStart(Boolean start) {
        this.start = start;
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
