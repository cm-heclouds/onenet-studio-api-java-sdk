package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.github.cm.heclouds.onenet.studio.api.IotResponse;
import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChengQi
 * @date 2020-07-06 17:42
 */
public abstract class BaseDevicePropertyRequest<T extends IotResponse> extends BaseApplicationRequest<T> {

    private Map<String, Object> params = new HashMap<>();

    public BaseDevicePropertyRequest(Method method, String action) {
        super(method, action);
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
     * 添加要设置的属性值
     * @param param 属性功能点标识
     * @param value 属性值
     */
    public void addParam(String param, Object value) {
        params.put(param, value);
        bodyParam("params", params);
    }
}
