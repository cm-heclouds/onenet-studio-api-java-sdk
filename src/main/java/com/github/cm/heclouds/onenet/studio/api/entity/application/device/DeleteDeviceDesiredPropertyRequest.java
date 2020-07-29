package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 设备属性期望删除请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/deleteDeviceDesiredProperty.html">设备属性期望删除</a>
 * @author ChengQi
 * @date 2020/7/7
 */
public class DeleteDeviceDesiredPropertyRequest extends BaseApplicationRequest<DeleteDeviceDesiredPropertyResponse> {

    private Map<String, Map<String, Integer>> params = new HashMap<>();

    public DeleteDeviceDesiredPropertyRequest() {
        super(Method.POST, "DeleteDeviceDesiredProperty");
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
     * 设置设备名称
     * @param deviceName 设备名称
     */
    public void setDeviceName(String deviceName) {
        bodyParam("device_name", deviceName);
    }

    /**
     * 添加删除的属性期望
     * @param param 属性功能点标识
     */
    public void addParam(String param) {
        params.put(param, new HashMap<>());
        bodyParam("params", params);
    }

    /**
     * 添加删除的属性期望
     * @param param 属性功能点标识
     * @param version 版本号信息 只有版本号信息等于当前属性期望值版本
     */
    public void addParam(String param, Integer version) {
        params.put(param, new HashMap<String, Integer>(){{put("version", version);}});
        bodyParam("params", params);
    }

    @Override
    protected Class<DeleteDeviceDesiredPropertyResponse> getResponseType() {
        return DeleteDeviceDesiredPropertyResponse.class;
    }

    @Override
    protected DeleteDeviceDesiredPropertyResponse newResponse(String responseBody) {
        return new DeleteDeviceDesiredPropertyResponse();
    }
}
