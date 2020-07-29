package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

/**
 * 属性功能点期望值
 * @author ChengQi
 * @date 2020/7/7
 */
public class DesiredProperty {

    /**
     * 期望值版本号
     */
    private Integer version;

    /**
     * 期望值值
     */
    private Object value;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
