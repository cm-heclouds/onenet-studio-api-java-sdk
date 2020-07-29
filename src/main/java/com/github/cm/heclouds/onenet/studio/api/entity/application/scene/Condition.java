package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.CType;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.DataType;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.Operator;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderSerializer;

/**
 * 触发条件，当ctype为lifeCycle时，只需填product_id、device_name、value和operator字段
 * @author ChengQi
 * @date 2020/7/8
 */
public class Condition {

    /**
     * 触发方式
     */
    @JSONField(serializeUsing = ValueHolderSerializer.class, deserializeUsing = ValueHolderDeserializer.class)
    private CType ctype;

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
     * 属性功能点标识
     */
    private String identifier;

    /**
     * 功能点数据类型 支持int32、int64、float、double、string、bool
     */
    @JSONField(serializeUsing = ValueHolderSerializer.class, deserializeUsing = ValueHolderDeserializer.class)
    private DataType type;

    /**
     * 功能点预设值
     */
    private String value;

    /**
     * 比较运算符
     */
    @JSONField(serializeUsing = ValueHolderSerializer.class, deserializeUsing = ValueHolderDeserializer.class)
    private Operator operator;

    public CType getCtype() {
        return ctype;
    }

    public void setCtype(CType ctype) {
        this.ctype = ctype;
    }

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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
