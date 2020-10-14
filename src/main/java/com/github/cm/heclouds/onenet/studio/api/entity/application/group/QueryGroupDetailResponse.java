package com.github.cm.heclouds.onenet.studio.api.entity.application.group;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.AbstractResponse;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;

import java.util.Date;
import java.util.Map;

/**
 * 分组详情响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/queryGroupDetail.html">分组详情</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class QueryGroupDetailResponse extends AbstractResponse {

    /**
     * 分组ID
     */
    private String id;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 分组所属的项目ID
     */
    @JSONField(name = "project_id")
    private String projectId;

    /**
     * 分组key
     */
    private String key;

    /**
     * 分组标签
     */
    private Map<String, String> tag;

    /**
     * 分组描述
     */
    private String desc;

    /**
     * 激活数量
     */
    @JSONField(name = "activate_count")
    private Integer activateCount;

    /**
     * 上线次数
     */
    @JSONField(name = "online_count")
    private Integer onlineCount;

    /**
     * 设备数量
     */
    @JSONField(name = "device_count")
    private Integer deviceCount;

    /**
     * 创建时间
     */
    @JSONField(name = "created_time", format = Constant.DATE_TIME_FORMAT)
    private Date createdTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, String> getTag() {
        return tag;
    }

    public void setTag(Map<String, String> tag) {
        this.tag = tag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getActivateCount() {
        return activateCount;
    }

    public void setActivateCount(Integer activateCount) {
        this.activateCount = activateCount;
    }

    public Integer getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(Integer onlineCount) {
        this.onlineCount = onlineCount;
    }

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
