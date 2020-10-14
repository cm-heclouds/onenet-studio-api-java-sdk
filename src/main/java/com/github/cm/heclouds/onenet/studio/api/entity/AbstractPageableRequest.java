package com.github.cm.heclouds.onenet.studio.api.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.cm.heclouds.onenet.studio.api.AbstractRequest;

/**
 * Pageable request of OneNET Studio API,
 * it providers {@code #setOffset} and {@code #setLimit} methods
 * @author ChengQi
 * @date 2020-07-06 14:27
 */
public abstract class AbstractPageableRequest<T extends AbstractPagedResponse<?>> extends AbstractRequest<T> {

    public AbstractPageableRequest(String nameSpace, String action) {
        super(nameSpace, Method.GET, action);
    }

    /**
     * 设置请求起始位置
     * @param offset 请求起始位置，默认0
     */
    public void setOffset(Integer offset) {
        queryParam("offset", offset);
    }

    /**
     * 设置每次请求记录数
     * @param limit 每次请求记录数
     */
    public void setLimit(Integer limit) {
        queryParam("limit", limit);
    }

    @Override
    protected T newResponse(String responseBody) {
        T response = JSON.parseObject(responseBody, getResponseType());
        JSONObject responseObject = JSON.parseObject(responseBody);
        JSONObject metaObject = responseObject.getJSONObject("meta");
        if (metaObject.containsKey("count")) {
            response.getMeta().setTotal(metaObject.getInteger("count"));
        }
        return response;
    }
}
