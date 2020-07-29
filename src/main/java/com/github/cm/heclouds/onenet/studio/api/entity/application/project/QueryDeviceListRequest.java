package com.github.cm.heclouds.onenet.studio.api.entity.application.project;

import com.github.cm.heclouds.onenet.studio.api.entity.application.BasePageableApplicationRequest;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.From;

/**
 * 项目集成设备列表请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryDeviceList.html">项目集成设备列表</a>
 * @author ChengQi
 * @date 2020-07-06 15:16
 */
public class QueryDeviceListRequest extends BasePageableApplicationRequest<QueryDeviceListResponse> {

    public QueryDeviceListRequest() {
        super("QueryDeviceList");
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
     * 设置设备来源
     * @param from 设备来源
     */
    public void setFrom(From from) {
        queryParam("from", from);
    }

    @Override
    protected Class<QueryDeviceListResponse> getResponseType() {
        return QueryDeviceListResponse.class;
    }
}
