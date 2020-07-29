package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.github.cm.heclouds.onenet.studio.api.AbstractRequest;

/**
 * 设备详情请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/queryDeviceDetail.html">设备详情</a>
 * @author ChengQi
 * @date 2020-07-06 10:51
 */
public class QueryDeviceDetailRequest extends BaseCommonRequest<QueryDeviceDetailResponse> {

    public QueryDeviceDetailRequest() {
        super(AbstractRequest.Method.GET, "QueryDeviceDetail");
    }

    /**
     * 设置产品ID参数
     * @param productId 产品ID
     */
    @Override
    public void setProductId(String productId) {
        queryParam("product_id", productId);
    }

    /**
     * 设置设备名称参数
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
