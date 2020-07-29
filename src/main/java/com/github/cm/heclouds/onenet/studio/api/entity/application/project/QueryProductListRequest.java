package com.github.cm.heclouds.onenet.studio.api.entity.application.project;

import com.github.cm.heclouds.onenet.studio.api.entity.application.BasePageableApplicationRequest;

/**
 * 项目集成产品列表请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryProductList.html">项目集成产品列表</a>
 * @author ChengQi
 * @date 2020-07-06 14:41
 */
public class QueryProductListRequest extends BasePageableApplicationRequest<QueryProductListResponse> {

    public QueryProductListRequest() {
        super("QueryProductList");
    }

    /**
     * 设置项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(String projectId) {
        queryParam("project_id", projectId);
    }

    @Override
    protected Class<QueryProductListResponse> getResponseType() {
        return QueryProductListResponse.class;
    }
}
