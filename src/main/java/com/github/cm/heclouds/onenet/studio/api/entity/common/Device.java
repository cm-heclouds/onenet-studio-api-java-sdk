package com.github.cm.heclouds.onenet.studio.api.entity.common;

/**
 * 设备信息
 * @author ChengQi
 * @date 2020-07-06 9:15
 */
public class Device {

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备描述
     */
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
