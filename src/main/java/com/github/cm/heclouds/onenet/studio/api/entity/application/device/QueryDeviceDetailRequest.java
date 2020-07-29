package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.github.cm.heclouds.onenet.studio.api.entity.application.BaseApplicationRequest;
import com.github.cm.heclouds.onenet.studio.api.entity.common.QueryDeviceDetailResponse;

/**
 * 设备详情请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryDeviceDetail.html">设备详情</a>
 * @author ChengQi
 * @date 2020-07-06 16:23
 */
public class QueryDeviceDetailRequest extends BaseApplicationRequest<QueryDeviceDetailResponse> {

    public QueryDeviceDetailRequest() {
        super(Method.GET, "QueryDeviceDetail");
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
    protected Class<QueryDeviceDetailResponse> getResponseType() {
        return QueryDeviceDetailResponse.class;
    }
}
