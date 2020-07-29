package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

import com.github.cm.heclouds.onenet.studio.api.entity.application.BasePageableApplicationRequest;

/**
 * 场景联动规则列表请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/querySceneRules.html">场景联动规则列表</a>
 * @author ChengQi
 * @date 2020/7/8
 */
public class QuerySceneRulesRequest extends BasePageableApplicationRequest<QuerySceneRulesResponse> {

    public QuerySceneRulesRequest() {
        super("QuerySceneRules");
    }

    /**
     * 设置项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(String projectId) {
        queryParam("project_id", projectId);
    }

    @Override
    protected Class<QuerySceneRulesResponse> getResponseType() {
        return QuerySceneRulesResponse.class;
    }
}
