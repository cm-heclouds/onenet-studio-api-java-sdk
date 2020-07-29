package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.OnOffLineStatus;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;

import java.util.Date;

/**
 * 设备历史状态
 * @author ChengQi
 * @date 2020-07-06 16:50
 */
public class DeviceStatus {

    /**
     * 设备状态
     */
    @JSONField(deserializeUsing = ValueHolderDeserializer.class)
    private OnOffLineStatus status;

    /**
     * 时间
     */
    private Date time;

    public OnOffLineStatus getStatus() {
        return status;
    }

    public void setStatus(OnOffLineStatus status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
