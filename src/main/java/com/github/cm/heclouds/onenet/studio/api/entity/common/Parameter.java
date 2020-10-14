package com.github.cm.heclouds.onenet.studio.api.entity.common;

/**
 * 参数
 * @author ChengQi
 * @date 2020/10/14
 */
public class Parameter {

    /**
     * 参数唯一标识符
     */
    private String identifier;

    /**
     * 参数名称
     */
    private String name;

    /**
     * 参数数据
     */
    private DataTypeMeta dataType;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataTypeMeta getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeMeta dataType) {
        this.dataType = dataType;
    }
}
