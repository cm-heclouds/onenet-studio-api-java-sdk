package com.github.cm.heclouds.onenet.studio.api.entity.common;

/**
 * 物模型查询请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/queryThingModel.html">物模型查询</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class QueryThingModelRequest extends BaseCommonRequest<QueryThingModelResponse> {

    public QueryThingModelRequest() {
        super(Method.GET, "QueryThingModel");
    }

    @Override
    public void setProductId(String productId) {
        queryParam("product_id", productId);
    }

    @Override
    protected Class<QueryThingModelResponse> getResponseType() {
        return QueryThingModelResponse.class;
    }
}
