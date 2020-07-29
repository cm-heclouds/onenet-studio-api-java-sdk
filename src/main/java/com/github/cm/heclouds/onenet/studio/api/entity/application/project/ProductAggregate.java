package com.github.cm.heclouds.onenet.studio.api.entity.application.project;

/**
 * 设备分布
 * @author ChengQi
 * @date 2020-07-06 13:56
 */
public class ProductAggregate {

    /**
     * 产品名称
     */
    private String name;

    /**
     * 项目下产品设备总数
     */
    private Integer count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
