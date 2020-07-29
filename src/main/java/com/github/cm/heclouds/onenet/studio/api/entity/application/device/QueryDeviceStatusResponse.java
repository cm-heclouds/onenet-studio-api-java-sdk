package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.AbstractResponse;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.Status;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;

/**
 * 设备状态查询响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryDeviceStatus.html">设备状态查询</a>
 * @author ChengQi
 * @date 2020-07-06 16:36
 */
public class QueryDeviceStatusResponse extends AbstractResponse {

    @JSONField(deserializeUsing = ValueHolderDeserializer.class)
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
