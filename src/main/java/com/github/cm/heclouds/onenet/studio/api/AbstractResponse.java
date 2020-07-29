package com.github.cm.heclouds.onenet.studio.api;

/**
 * Sub class of {@link IotResponse}, it implements specific methods about requestId
 * @author ChengQi
 * @date 2020-07-02 11:18
 */
public abstract class AbstractResponse implements IotResponse {

    private String requestId;

    @Override
    public String getRequestId() {
        return requestId;
    }

    @Override
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
