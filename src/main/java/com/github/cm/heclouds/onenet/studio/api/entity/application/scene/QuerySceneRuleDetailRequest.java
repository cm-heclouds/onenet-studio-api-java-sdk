package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;

/**
 * 场景联动规则详情请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/querySceneRuleDetail.html">
 *     场景联动规则详情</a>
 * @author ChengQi
 * @date 2020/7/8
 */
public class QuerySceneRuleDetailRequest extends BaseApplicationRequest<QuerySceneRuleDetailResponse> {

    public QuerySceneRuleDetailRequest() {
        super(Method.GET, "QuerySceneRuleDetail");
    }

    /**
     * 设置项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(String projectId) {
        queryParam("project_id", projectId);
    }

    /**
     * 设置场景联动规则ID
     * @param sceneId 场景联动规则ID
     */
    public void setSceneId(String sceneId) {
        queryParam("scene_id", sceneId);
    }

    @Override
    protected Class<QuerySceneRuleDetailResponse> getResponseType() {
        return QuerySceneRuleDetailResponse.class;
    }
}
