package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.github.cm.heclouds.onenet.studio.api.entity.application.BasePageableApplicationRequest;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.EventType;

import java.util.Date;
import java.util.Objects;

/**
 * 设备事件历史数据查询请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryDeviceEventHistory.html">设备事件历史数据查询</a>
 * @author ChengQi
 * @date 2020/7/7
 */
public class QueryDeviceEventHistoryRequest extends BasePageableApplicationRequest<QueryDeviceEventHistoryResponse> {

    public QueryDeviceEventHistoryRequest() {
        super("QueryDeviceEventHistory");
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


    /**
     * 设置事件功能点标识
     * @param identifier 事件功能点标识
     */
    public void setIdentifier(String identifier) {
        queryParam("identifier", identifier);
    }

    /**
     * 设置事件类型
     * @param eventType 事件类型
     */
    public void setEventType(EventType eventType) {
        queryParam("event_type", eventType);
    }

    /**
     * 设置查询起始时间
     * @param startTime 查询起始时间
     */
    public void setStartTime(Date startTime) {
        queryParam("start_time", Objects.isNull(startTime)? null: startTime.getTime());
    }

    /**
     * 设置查询结束时间
     * @param endTime 查询结束时间
     */
    public void setEndTime(Date endTime) {
        queryParam("end_time", Objects.isNull(endTime)? null: endTime.getTime());
    }

    @Override
    protected Class<QueryDeviceEventHistoryResponse> getResponseType() {
        return QueryDeviceEventHistoryResponse.class;
    }
}
