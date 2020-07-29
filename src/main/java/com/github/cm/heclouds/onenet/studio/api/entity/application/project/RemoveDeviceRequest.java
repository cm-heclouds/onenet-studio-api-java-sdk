package com.github.cm.heclouds.onenet.studio.api.entity.application.project;

import com.alibaba.fastjson.JSONObject;
import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目设备移除请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/removeDevice.html">项目设备移除</a>
 * @author ChengQi
 * @date 2020-07-06 16:08
 */
public class RemoveDeviceRequest extends BaseApplicationRequest<RemoveDeviceResponse> {

    private List<String> devices = new ArrayList<>();

    public RemoveDeviceRequest() {
        super(Method.POST, "RemoveDevice");
    }

    /**
     * 设置项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(String projectId) {
        bodyParam("project_id", projectId);
    }

    /**
     * 设置产品ID
     * @param productId 产品ID
     */
    public void setProductId(String productId) {
        bodyParam("product_id", productId);
    }

    /**
     * 设置需要移除的设备名称集合
     * @param devices 需要移除的设备名称集合
     */
    public void setDevices(List<String> devices) {
        this.devices = devices;
        bodyParam("devices", this.devices);
    }

    /**
     * 添加需要移除的设备名称
     * @param device 需要移除的设备名称
     */
    public void addDevice(String device) {
        devices.add(device);
        bodyParam("devices", devices);
    }

    @Override
    protected Class<RemoveDeviceResponse> getResponseType() {
        return RemoveDeviceResponse.class;
    }

    @Override
    protected RemoveDeviceResponse newResponse(String responseBody) {
        RemoveDeviceResponse response = new RemoveDeviceResponse();
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
