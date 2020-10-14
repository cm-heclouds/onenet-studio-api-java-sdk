package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 调用服务响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/callService.html">调用服务</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class CallServiceRequest extends BaseApplicationRequest<CallServiceResponse> {

    private Map<String, Object> params = new HashMap<>();

    public CallServiceRequest() {
        super(Method.POST, "CallService");
    }

    /**
     * 设置产品id
     * @param productId 产品id
     */
    public void setProductId(String productId) {
        bodyParam("product_id", productId);
    }

    /**
     * 设置设备唯一标识
     * @param deviceName 设备唯一标识
     */
    public void setDeviceName(String deviceName) {
        bodyParam("device_name", deviceName);
    }

    /**
     * 设置服务型功能点标识
     * @param identifier 服务型功能点标识
     */
    public void setIdentifier(String identifier) {
        bodyParam("identifier", identifier);
    }

    /**
     * 设置输入参数
     * @param params 输入参数的键值对
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
        bodyParam("params", this.params);
    }

    /**
     * 添加输入参数的键值对
     * @param key 输入参数的唯一标识
     * @param value 输入参数的值
     */
    public void addParam(String key, String value) {
        params.put(key, value);
        bodyParam("params", this.params);
    }

    @Override
    protected Class<CallServiceResponse> getResponseType() {
        return CallServiceResponse.class;
    }

    @Override
    protected CallServiceResponse newResponse(String responseBody) {
        CallServiceResponse response = new CallServiceResponse();
        if (StringUtils.isEmpty(responseBody)) {
            return response;
        }
        JSONObject jsonObject = JSON.parseObject(responseBody);
        response.putAll(jsonObject);
        return response;
    }
}
