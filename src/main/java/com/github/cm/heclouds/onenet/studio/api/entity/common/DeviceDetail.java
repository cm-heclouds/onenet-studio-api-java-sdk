package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.NodeType;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.Protocol;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;

import java.util.Date;

/**
 * 设备信息
 * @author ChengQi
 * @date 2020-07-06 9:09
 */
public class DeviceDetail {

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备类型
     */
    @JSONField(name = "node_type", deserializeUsing = ValueHolderDeserializer.class)
    private NodeType nodeType;

    /**
     * 设备描述
     */
    private String desc;

    /**
     * 设备密钥
     */
    @JSONField(name = "sec_key")
    private String secKey;

    /**
     * 协议类型
     */
    @JSONField(deserializeUsing = ValueHolderDeserializer.class)
    private Protocol protocol;

    /**
     * 创建时间
     */
    @JSONField(name = "created_time", format = Constant.DATE_TIME_FORMAT)
    private Date createdTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSecKey() {
        return secKey;
    }

    public void setSecKey(String secKey) {
        this.secKey = secKey;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
