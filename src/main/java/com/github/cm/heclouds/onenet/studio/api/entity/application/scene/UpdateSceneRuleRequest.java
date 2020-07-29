package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

/**
 * 场景联动规则编辑请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/updateSceneRule.html">场景联动规则编辑</a>
 * @author ChengQi
 * @date 2020/7/8
 */
public class UpdateSceneRuleRequest extends BaseSceneRuleRequest<UpdateSceneRuleResponse> {

    public UpdateSceneRuleRequest() {
        super("UpdateSceneRule");
    }

    /**
     * 设置场景联动规则ID
     * @param sceneId 场景联动规则ID
     */
    public void setSceneId(String sceneId) {
        bodyParam("scene_id", sceneId);
    }

    @Override
    protected Class<UpdateSceneRuleResponse> getResponseType() {
        return UpdateSceneRuleResponse.class;
    }
}
