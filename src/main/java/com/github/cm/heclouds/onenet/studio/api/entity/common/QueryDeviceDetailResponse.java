package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.AbstractResponse;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.NodeType;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.Protocol;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.Status;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;

import java.util.Date;

/**
 * 设备详情响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/queryDeviceDetail.html">设备详情</a>
 * @author ChengQi
 * @date 2020-07-06 10:51
 */
public class QueryDeviceDetailResponse extends AbstractResponse {

    /**
     * 设备名称
     */
    @JSONField(name = "device_name")
    private String deviceName;

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
     * 设备描述
     */
    private String desc;

    /**
     * 设备状态
     */
    @JSONField(deserializeUsing = ValueHolderDeserializer.class)
    private Status status;

    /**
     * 节点类型
     */
    @JSONField(name = "node_type", deserializeUsing = ValueHolderDeserializer.class)
    private NodeType nodeType;

    /**
     * 协议类型
     */
    @JSONField(deserializeUsing = ValueHolderDeserializer.class)
    private Protocol protocol;

    /**
     * 设备连接ip
     */
    private String ip;

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

    /**
     * 激活时间
     */
    @JSONField(name = "active_time", format = Constant.DATE_TIME_FORMAT)
    private Date activeTime;

    /**
     * 设备密钥
     */
    @JSONField(name = "sec_key")
    private String secKey;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public String getSecKey() {
        return secKey;
    }

    public void setSecKey(String secKey) {
        this.secKey = secKey;
    }
}
