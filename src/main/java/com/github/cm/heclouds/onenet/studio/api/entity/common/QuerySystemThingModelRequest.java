package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.github.cm.heclouds.onenet.studio.api.AbstractRequest;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;

/**
 * 物模型系统功能点列表请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/querySystemThingModel.html">物模型系统功能点列表</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class QuerySystemThingModelRequest extends AbstractRequest<QuerySystemThingModelResponse> {

    public QuerySystemThingModelRequest() {
        super(Constant.OPEN_API_NAMESPACE_COMMON, Method.GET, "QuerySystemThingModel");
    }

    @Override
    protected Class<QuerySystemThingModelResponse> getResponseType() {
        return QuerySystemThingModelResponse.class;
    }
}
