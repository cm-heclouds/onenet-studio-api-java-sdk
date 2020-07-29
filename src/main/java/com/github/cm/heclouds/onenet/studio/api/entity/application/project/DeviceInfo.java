package com.github.cm.heclouds.onenet.studio.api.entity.application.project;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.From;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.NodeType;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.Status;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;

import java.util.Date;

/**
 * 设备详细信息
 * @author ChengQi
 * @date 2020-07-06 14:59
 */
public class DeviceInfo {

    /**
     * 产品ID
     */
    @JSONField(name = "product_id")
    private String productId;

    /**
     * 产品名称
     */
    @JSONField(name = "product_name")
    private String productName;

    /**
     * 设备名称
     */
    @JSONField(name = "device_name")
    private String deviceName;

    /**
     * 设备状态
     */
    @JSONField(deserializeUsing = ValueHolderDeserializer.class)
    private Status status;

    /**
     * 设备来源
     */
    @JSONField(deserializeUsing = ValueHolderDeserializer.class)
    private From from;

    /**
     * 节点类型
     */
    @JSONField(name = "node_type", deserializeUsing = ValueHolderDeserializer.class)
    private NodeType nodeType;

    /**
     * 创建时间
     */
    @JSONField(name = "created_time", format = Constant.DATE_TIME_FORMAT)
    private Date createdTime;

    /**
     * 最后一次在线时间
     */
    @JSONField(name = "last_time", format = Constant.DATE_TIME_FORMAT)
    private Date lastTime;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}
