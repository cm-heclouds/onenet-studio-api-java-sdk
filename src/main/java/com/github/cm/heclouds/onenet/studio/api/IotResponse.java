package com.github.cm.heclouds.onenet.studio.api;

/**
 * The top layer abstract interface of response for OneNET Studio API calling,
 * which contains requestId methods
 * @author ChengQi
 * @date 2020-07-06 8:58
 */
public interface IotResponse {

    /**
     * get the request id of pass returns
     * @return request id
     */
    String getRequestId();

    /**
     * set the request id of pass returns
     * @param requestId request id
     */
    void setRequestId(String requestId);
}
