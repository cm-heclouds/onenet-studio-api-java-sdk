package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 设备属性期望查询请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryDeviceDesiredProperty.html">设备属性期望查询</a>
 * @author ChengQi
 * @date 2020/7/7
 */
public class QueryDeviceDesiredPropertyRequest extends BaseApplicationRequest<QueryDeviceDesiredPropertyResponse> {

    private List<String> params = new ArrayList<>();

    public QueryDeviceDesiredPropertyRequest() {
        super(Method.POST, "QueryDeviceDesiredProperty");
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
     * 设置查询期望值的功能点标识集合，参数不传默认查询所有属性期望
     * @param params 查询期望值的功能点标识集合
     */
    public void setParams(List<String> params) {
        this.params = params;
        bodyParam("params", this.params);
    }

    /**
     * 添加要查询的期望值的功能点标识
     * @param param 属性功能点标识
     */
    public void addParam(String param) {
        params.add(param);
        bodyParam("params", params);
    }

    @Override
    protected Class<QueryDeviceDesiredPropertyResponse> getResponseType() {
        return QueryDeviceDesiredPropertyResponse.class;
    }

    @Override
    protected QueryDeviceDesiredPropertyResponse newResponse(String responseBody) {
        QueryDeviceDesiredPropertyResponse response = new QueryDeviceDesiredPropertyResponse();
        if (StringUtils.isEmpty(responseBody)) {
            return response;
        }
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        if (!jsonObject.containsKey("params")) {
            return response;
        }
        Map<String, DesiredProperty> paramsMap = jsonObject.getObject("params",
                new TypeReference<Map<String, DesiredProperty>>(){});
        response.putAll(paramsMap);
        return response;
    }
}
