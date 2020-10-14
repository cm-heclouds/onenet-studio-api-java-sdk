package com.github.cm.heclouds.onenet.studio.api.entity.application.group;

import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;

/**
 * 分组创建请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/createGroup.html">分组创建</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class CreateGroupRequest extends BaseApplicationRequest<CreateGroupResponse> {

    public CreateGroupRequest() {
        super(Method.POST, "CreateGroup");
    }

    /**
     * 设置项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(String projectId) {
        bodyParam("project_id", projectId);
    }

    /**
     * 设置分组名称
     * @param name 分组名称
     */
    public void setName(String name) {
        bodyParam("name", name);
    }

    /**
     * 设置分组描述
     * @param desc 分组描述
     */
    public void setDesc(String desc) {
        bodyParam("desc", desc);
    }

    @Override
    protected Class<CreateGroupResponse> getResponseType() {
        return CreateGroupResponse.class;
    }
}
