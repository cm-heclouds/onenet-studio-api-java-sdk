package com.github.cm.heclouds.onenet.studio.api.entity.application.project;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.DataProtocol;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.Network;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.NodeType;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.Protocol;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;

/**
 * 产品信息
 * @author ChengQi
 * @date 2020-07-06 14:39
 */
public class ProductInfo {

    /**
     * 产品ID
     */
    @JSONField(name = "product_id")
    private String projectId;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 描述
     */
    private String desc;

    /**
     * 协议
     */
    @JSONField(deserializeUsing = ValueHolderDeserializer.class)
    private Protocol protocol;

    /**
     * 节点类型
     */
    @JSONField(name = "node_type", deserializeUsing = ValueHolderDeserializer.class)
    private NodeType nodeType;

    /**
     * 数据类型
     */
    @JSONField(name = "data_type", deserializeUsing = ValueHolderDeserializer.class)
    private DataProtocol dataType;

    /**
     * 联网模式
     */
    @JSONField(deserializeUsing = ValueHolderDeserializer.class)
    private Network network;

    /**
     * 设备总数
     */
    @JSONField(name = "device_number")
    private Integer deviceNumber;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public DataProtocol getDataType() {
        return dataType;
    }

    public void setDataType(DataProtocol dataType) {
        this.dataType = dataType;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Integer getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(Integer deviceNumber) {
        this.deviceNumber = deviceNumber;
    }
}
