package com.github.cm.heclouds.onenet.studio.api.entity.application.group;

import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;

/**
 * 分组详情请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryGroupDetail.html">分组详情</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class QueryGroupDetailRequest extends BaseApplicationRequest<QueryGroupDetailResponse> {

    public QueryGroupDetailRequest() {
        super(Method.GET, "QueryGroupDetail");
    }

    /**
     * 设置项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(String projectId) {
        queryParam("project_id", projectId);
    }

    /**
     * 设置分组ID
     * @param id 分组ID
     */
    public void setId(String id) {
        queryParam("id", id);
    }

    @Override
    protected Class<QueryGroupDetailResponse> getResponseType() {
        return QueryGroupDetailResponse.class;
    }
}
