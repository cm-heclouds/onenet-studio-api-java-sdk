package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

import com.github.cm.heclouds.onenet.studio.api.AbstractResponse;

/**
 * 场景联动规则创建响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/createSceneRule.html">场景联动规则创建</a>
 * @author ChengQi
 * @date 2020/7/8
 */
public class CreateSceneRuleResponse extends AbstractResponse {

    /**
     * 规则ID
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
