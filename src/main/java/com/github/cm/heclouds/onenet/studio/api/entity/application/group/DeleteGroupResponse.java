package com.github.cm.heclouds.onenet.studio.api.entity.application.group;

import com.github.cm.heclouds.onenet.studio.api.IotResponse;

import java.util.ArrayList;

/**
 * 分组删除响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/deleteGroup.html">分组删除</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class DeleteGroupResponse extends ArrayList<ErrorData> implements IotResponse {

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
