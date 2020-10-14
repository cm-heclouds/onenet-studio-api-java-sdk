package com.github.cm.heclouds.onenet.studio.api.entity.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 物模型更新请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/common/updateThingModel.html">物模型更新</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class UpdateThingModelRequest extends BaseCommonRequest<UpdateThingModelResponse> {

    private List<Property> properties = new ArrayList<>();

    private List<Event> events = new ArrayList<>();

    private List<Service> services = new ArrayList<>();

    public UpdateThingModelRequest() {
        super(Method.POST, "UpdateThingModel");
        bodyParam("properties", this.properties);
        bodyParam("events", this.events);
        bodyParam("services", this.services);
    }

    /**
     * 设置属性功能点集合
     * @param properties 属性功能点集合
     */
    public void setProperties(List<Property> properties) {
        this.properties = properties;
        bodyParam("properties", this.properties);
    }

    /**
     * 添加属性功能点
     * @param property 属性功能点
     */
    public void addProperties(Property property) {
        properties.add(property);
        bodyParam("properties", this.properties);
    }

    /**
     * 设置事件功能点集合
     * @param events 事件功能点集合
     */
    public void setEvents(List<Event> events) {
        this.events = events;
        bodyParam("events", this.events);
    }

    /**
     * 添加事件功能点
     * @param event 事件功能点
     */
    public void addEvent(Event event) {
        events.add(event);
        bodyParam("events", this.events);
    }

    /**
     * 设置服务功能点集合
     * @param services 服务功能点集合
     */
    public void setServices(List<Service> services) {
        this.services = services;
        bodyParam("services", this.services);
    }

    /**
     * 添加服务功能点
     * @param service 服务功能点集合
     */
    public void addService(Service service) {
        services.add(service);
        bodyParam("services", this.services);
    }

    @Override
    protected Class<UpdateThingModelResponse> getResponseType() {
        return UpdateThingModelResponse.class;
    }

    @Override
    protected UpdateThingModelResponse newResponse(String responseBody) {
        return new UpdateThingModelResponse();
    }
}
