package com.github.cm.heclouds.onenet.studio.api.entity.application.project;

import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;

/**
 * 项目概况请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryStatistics.html">项目概况</a>
 * @author ChengQi
 * @date 2020-07-06 13:46
 */
public class QueryStatisticsRequest extends BaseApplicationRequest<QueryStatisticsResponse> {

    public QueryStatisticsRequest() {
        super(Method.GET, "QueryStatistics");
    }

    /**
     * 设置项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(String projectId) {
        queryParam("project_id", projectId);
    }

    @Override
    protected Class<QueryStatisticsResponse> getResponseType() {
        return QueryStatisticsResponse.class;
    }
}
