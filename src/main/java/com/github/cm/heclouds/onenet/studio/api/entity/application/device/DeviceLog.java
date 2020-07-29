package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.ReadWriteType;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;

import java.util.Date;
import java.util.Map;

/**
 * 设备操作日志
 * @author ChengQi
 * @date 2020/7/7
 */
public class DeviceLog {

    /**
     * 请求类型
     */
    @JSONField(deserializeUsing = ValueHolderDeserializer.class)
    private ReadWriteType type;

    /**
     * 请求时间
     */
    @JSONField(name = "request_time")
    private Date requestTime;

    /**
     * 请求内容 k=>v形式， k为属性功能点标识，v为功能点设置值
     */
    @JSONField(name = "request_body")
    private Map<String, Object> requestBody;

    /**
     * 响应时间
     */
    @JSONField(name = "response_time")
    private Date responseTime;

    /**
     * 响应结果, 设备回复响应中的msg字段
     */
    @JSONField(name = "response_body")
    private String responseBody;

    public ReadWriteType getType() {
        return type;
    }

    public void setType(ReadWriteType type) {
        this.type = type;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Map<String, Object> getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(Map<String, Object> requestBody) {
        this.requestBody = requestBody;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }
}
