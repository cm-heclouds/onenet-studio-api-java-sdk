package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.github.cm.heclouds.onenet.studio.api.AbstractRequest;
import com.github.cm.heclouds.onenet.studio.api.IotResponse;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;

/**
 * Device manager request of OneNET Studio API
 * @author ChengQi
 * @date 2020-07-02 14:15
 */
abstract class BaseCommonRequest<T extends IotResponse> extends AbstractRequest<T> {

    BaseCommonRequest(Method method, String action) {
        super(Constant.OPEN_API_NAMESPACE_COMMON, method, action);
    }

    /**
     * 设置产品ID参数
     * @param productId 产品ID
     */
    public void setProductId(String productId) {
        bodyParam("product_id", productId);
    }
}
