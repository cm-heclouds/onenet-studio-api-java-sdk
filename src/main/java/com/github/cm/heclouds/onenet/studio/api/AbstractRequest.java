package com.github.cm.heclouds.onenet.studio.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;
import okhttp3.CacheControl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The top layer abstract class of request for OneNET Studio API calling
 * @author ChengQi
 * @date 2020-07-02 11:17
 */
public abstract class AbstractRequest<T extends IotResponse> {

    private final Map<String, String> headers = new HashMap<>();
    private final Map<String, Object> queryParams = new HashMap<>();
    private final Map<String, Object> bodyParams = new HashMap<>();

    private final String nameSpace;
    private final Method method;

    public AbstractRequest(String nameSpace, Method method, String action) {
        this.nameSpace = nameSpace;
        this.method = method;
        queryParam("action", action);
        queryParam("version", Constant.OPEN_API_VERSION);
    }

    protected void header(String name, String value) {
        headers.put(name, value);
    }

    protected Optional<String> header(String name) {
        return Optional.ofNullable(headers.get(name));
    }

    protected void queryParam(String name, Object value) {
        queryParams.put(name, value);
    }

    protected Optional<Object> queryParam(String name) {
        return Optional.ofNullable(queryParams.get(name));
    }

    protected void bodyParam(String name, Object value) {
        bodyParams.put(name, value);
    }

    protected Optional<Object> bodyParam(String name) {
        return Optional.ofNullable(bodyParams.get(name));
    }

    String getNameSpace() {
        return nameSpace;
    }

    Map<String, Object> getQueryParams() {
        return queryParams;
    }

    Request.Builder requestBuilder() {
        return method.builder(bodyParams)
                .tag(AbstractRequest.class, this)
                .cacheControl(new CacheControl.Builder().noCache().build());
    }

    protected abstract Class<T> getResponseType();

    protected T newResponse(String responseBody) {
        return JSON.parseObject(responseBody, getResponseType());
    }

    public enum Method {

        /**
         * post method
         */
        POST {
            @Override
            public Request.Builder builder(Map<String, Object> bodyParams) {
                String params = JSONObject.toJSONString(bodyParams);
                return new Request.Builder().post(RequestBody.create(JSON, params));
            }
        },
        /**
         * get method
         */
        GET {
            @Override
            public Request.Builder builder(Map<String, Object> bodyParams) {
                return new Request.Builder().get();
            }
        },
        /**
         * put method
         */
        PUT {
            @Override
            public Request.Builder builder(Map<String, Object> bodyParams) {
                String params = JSONObject.toJSONString(bodyParams);
                return new Request.Builder().put(RequestBody.create(JSON, params));
            }
        },
        /**
         * delete method
         */
        DELETE {
            @Override
            public Request.Builder builder(Map<String, Object> bodyParams) {
                String params = JSONObject.toJSONString(bodyParams);
                return new Request.Builder().delete(RequestBody.create(JSON, params));
            }
        };

        public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        public abstract Request.Builder builder(Map<String, Object> bodyParams);
    }
}
