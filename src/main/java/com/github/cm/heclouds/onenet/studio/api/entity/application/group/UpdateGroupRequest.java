package com.github.cm.heclouds.onenet.studio.api.entity.application.group;

import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 分组编辑请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/updateGroup.html">分组编辑</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class UpdateGroupRequest extends BaseApplicationRequest<UpdateGroupResponse> {

    private Map<String, String> tags = new HashMap<>();

    public UpdateGroupRequest() {
        super(Method.POST, "UpdateGroup");
    }

    /**
     * 设置项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(String projectId) {
        bodyParam("project_id", projectId);
    }

    /**
     * 设置分组ID
     * @param id 分组ID
     */
    public void setId(String id) {
        bodyParam("id", id);
    }

    /**
     * 设置标签信息
     * @param tags 标签信息
     */
    public void setTags(Map<String, String> tags) {
        this.tags = tags;
        bodyParam("tag", this.tags);
    }

    /**
     * 添加标签信息
     * @param key 键
     * @param value 值
     */
    public void addTag(String key, String value) {
        tags.put(key, value);
        bodyParam("tag", this.tags);
    }

    /**
     * 设置分组描述
     * @param desc 分组描述
     */
    public void setDesc(String desc) {
        bodyParam("desc", desc);
    }

    @Override
    protected Class<UpdateGroupResponse> getResponseType() {
        return UpdateGroupResponse.class;
    }
}
