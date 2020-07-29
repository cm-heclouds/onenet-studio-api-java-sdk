package com.github.cm.heclouds.onenet.studio.api.entity.application.project;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.AbstractResponse;

import java.util.List;

/**
 * 项目概况响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryStatistics.html">项目概况</a>
 * @author ChengQi
 * @date 2020-07-06 13:54
 */
public class QueryStatisticsResponse extends AbstractResponse {

    /**
     * 项目基础信息
     */
    private ProjectInfo project;

    /**
     * 集成产品总数
     */
    @JSONField(name = "product_count")
    private Integer productCount;

    /**
     * 集成设备总数
     */
    @JSONField(name = "device_count")
    private Integer deviceCount;

    /**
     * 在线设备总数
     */
    @JSONField(name = "online_count")
    private Integer onlineCount;

    /**
     * 激活设备总数
     */
    @JSONField(name = "activate_count")
    private Integer activateCount;

    /**
     * 活跃设备总数
     */
    @JSONField(name = "active_count")
    private Integer activeCount;

    /**
     * 设备分布集合
     */
    @JSONField(name = "product_aggregate")
    private List<ProductAggregate> productAggregate;

    public ProjectInfo getProject() {
        return project;
    }

    public void setProject(ProjectInfo project) {
        this.project = project;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    public Integer getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(Integer onlineCount) {
        this.onlineCount = onlineCount;
    }

    public Integer getActivateCount() {
        return activateCount;
    }

    public void setActivateCount(Integer activateCount) {
        this.activateCount = activateCount;
    }

    public Integer getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(Integer activeCount) {
        this.activeCount = activeCount;
    }

    public List<ProductAggregate> getProductAggregate() {
        return productAggregate;
    }

    public void setProductAggregate(List<ProductAggregate> productAggregate) {
        this.productAggregate = productAggregate;
    }
}
