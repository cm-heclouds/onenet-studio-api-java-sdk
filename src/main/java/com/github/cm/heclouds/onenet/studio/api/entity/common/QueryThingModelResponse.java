package com.github.cm.heclouds.onenet.studio.api.entity.common;

import com.github.cm.heclouds.onenet.studio.api.AbstractResponse;

import java.util.List;

/**
 * 物模型查询响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/queryThingModel.html">物模型查询</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class QueryThingModelResponse extends AbstractResponse {

    /**
     * 数组对象 属性功能点
     */
    private List<Property> properties;

    /**
     * 数组对象 事件功能点
     */
    private List<Event> events;

    /**
     * 数组对象 服务功能点
     */
    private List<Service> services;

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
