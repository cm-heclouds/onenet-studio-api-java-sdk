package com.github.cm.heclouds.onenet.studio.api.entity.application.project;

import com.alibaba.fastjson.JSONObject;
import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目设备添加请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/addDevice.html">项目设备添加</a>
 * @author ChengQi
 * @date 2020-07-06 15:37
 */
public class AddDeviceRequest extends BaseApplicationRequest<AddDeviceResponse> {

    private List<String> devices = new ArrayList<>();

    public AddDeviceRequest() {
        super(Method.POST, "AddDevice");
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
     * 设置添加的设备名称集合
     * @param devices 添加的设备名称集合
     */
    public void setDevices(List<String> devices) {
        this.devices = devices;
        bodyParam("devices", this.devices);
    }

    /**
     * 添加设备名称
     * @param device 设备名称
     */
    public void addDevice(String device) {
        devices.add(device);
        bodyParam("devices", devices);
    }

    @Override
    protected Class<AddDeviceResponse> getResponseType() {
        return AddDeviceResponse.class;
    }

    @Override
    protected AddDeviceResponse newResponse(String responseBody) {
        AddDeviceResponse response = new AddDeviceResponse();
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
