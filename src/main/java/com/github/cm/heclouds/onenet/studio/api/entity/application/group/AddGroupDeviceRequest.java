package com.github.cm.heclouds.onenet.studio.api.entity.application.group;

import com.alibaba.fastjson.JSONObject;
import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;
import com.github.cm.heclouds.onenet.studio.api.entity.application.project.ErrorData;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 分组设备添加请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/addGroupDevice.html">分组设备添加</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class AddGroupDeviceRequest extends BaseApplicationRequest<AddGroupDeviceResponse> {

    public AddGroupDeviceRequest() {
        super(Method.POST, "AddGroupDevice");
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
     * 设置产品ID
     * @param productId 产品ID
     */
    public void setProductId(String productId) {
        bodyParam("product_id", productId);
    }

    /**
     * 设置需要添加的设备集合
     * @param devices 需要添加的设备集合
     */
    public void setDevices(List<String> devices) {
        bodyParam("devices", devices);
    }

    @Override
    protected Class<AddGroupDeviceResponse> getResponseType() {
        return AddGroupDeviceResponse.class;
    }

    @Override
    protected AddGroupDeviceResponse newResponse(String responseBody) {
        AddGroupDeviceResponse response = new AddGroupDeviceResponse();
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
