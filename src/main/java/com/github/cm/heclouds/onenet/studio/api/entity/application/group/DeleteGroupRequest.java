package com.github.cm.heclouds.onenet.studio.api.entity.application.group;

import com.alibaba.fastjson.JSONObject;
import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 分组删除请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/deleteGroup.html">分组删除</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class DeleteGroupRequest extends BaseApplicationRequest<DeleteGroupResponse> {

    public DeleteGroupRequest() {
        super(Method.POST, "DeleteGroup");
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

    @Override
    protected Class<DeleteGroupResponse> getResponseType() {
        return DeleteGroupResponse.class;
    }

    @Override
    protected DeleteGroupResponse newResponse(String responseBody) {
        DeleteGroupResponse response = new DeleteGroupResponse();
        if (StringUtils.isEmpty(responseBody)) {
            return response;
        }
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        if (!jsonObject.containsKey("error_data")) {
            return response;
        }
        List<ErrorData> errorData = jsonObject.getJSONArray("error_data").toJavaList(ErrorData.class);
        response.addAll(errorData);
        return response;
    }
}
