package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 设备属性最新数据查询请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryDeviceProperty.html">
 *     设备属性最新数据查询</a>
 * @author ChengQi
 * @date 2020/7/7
 */
public class QueryDevicePropertyRequest extends BaseApplicationRequest<QueryDevicePropertyResponse> {

    public QueryDevicePropertyRequest() {
        super(Method.GET, "QueryDeviceProperty");
    }

    /**
     * 设置项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(String projectId) {
        queryParam("project_id", projectId);
    }

    /**
     * 设置产品ID
     * @param productId 产品ID
     */
    public void setProductId(String productId) {
        queryParam("product_id", productId);
    }

    /**
     * 设置设备名称
     * @param deviceName 设备名称
     */
    public void setDeviceName(String deviceName) {
        queryParam("device_name", deviceName);
    }

    @Override
    protected Class<QueryDevicePropertyResponse> getResponseType() {
        return QueryDevicePropertyResponse.class;
    }

    @Override
    protected QueryDevicePropertyResponse newResponse(String responseBody) {
        QueryDevicePropertyResponse response = new QueryDevicePropertyResponse();
        if (StringUtils.isEmpty(responseBody)) {
            return response;
        }
        JSONObject jsonObject = JSON.parseObject(responseBody);
        if (!jsonObject.containsKey("list")) {
            return response;
        }
        List<DeviceProperty> deviceProperties = JSON.parseArray(jsonObject.getString("list"), DeviceProperty.class);
        response.addAll(deviceProperties);
        return response;
    }
}
