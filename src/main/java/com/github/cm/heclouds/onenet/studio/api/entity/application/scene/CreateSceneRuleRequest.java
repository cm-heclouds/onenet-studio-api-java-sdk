package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

/**
 * 场景联动规则创建请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/createSceneRule.html">场景联动规则创建</a>
 * @author ChengQi
 * @date 2020/7/8
 */
public class CreateSceneRuleRequest extends BaseSceneRuleRequest<CreateSceneRuleResponse> {

    public CreateSceneRuleRequest() {
        super("CreateSceneRule");
    }

    @Override
    protected Class<CreateSceneRuleResponse> getResponseType() {
        return CreateSceneRuleResponse.class;
    }
}
