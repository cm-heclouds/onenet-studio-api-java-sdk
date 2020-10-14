package com.github.cm.heclouds.onenet.studio.api.entity.application.group;

import com.github.cm.heclouds.onenet.studio.api.entity.application.BasePageableApplicationRequest;

/**
 * 分组列表请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryGroupList.html">分组列表</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class QueryGroupListRequest extends BasePageableApplicationRequest<QueryGroupListResponse> {

    public QueryGroupListRequest() {
        super("QueryGroupList");
    }

    /**
     * 设置项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(String projectId) {
        queryParam("project_id", projectId);
    }

    /**
     * 设置分组名称
     * @param name 分组名称
     */
    public void setName(String name) {
        queryParam("name", name);
    }

    /**
     * 设置标签key
     * @param key 标签key（key、value需成对出现，否则没有效果）
     */
    public void setTagKey(String key) {
        queryParam("key", key);
    }

    /**
     * 设置标签value
     * @param value 标签value（key、value 需成对出现，否则没有效果）
     */
    public void setTagValue(String value) {
        queryParam("value", value);
    }

    @Override
    protected Class<QueryGroupListResponse> getResponseType() {
        return QueryGroupListResponse.class;
    }
}
