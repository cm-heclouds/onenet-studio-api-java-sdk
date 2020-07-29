package com.github.cm.heclouds.onenet.studio.api.entity.application.project;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;

import java.util.Date;
import java.util.List;

/**
 * 项目基础信息
 * @author ChengQi
 * @date 2020-07-06 13:57
 */
public class ProjectInfo {

    /**
     * 项目ID
     */
    @JSONField(name = "project_id")
    private String projectId;

    /**
     * 项目创建时间
     */
    @JSONField(name = "create_time", format = Constant.DATE_TIME_FORMAT)
    private Date createTime;

    /**
     * 自定义标签名称集合
     */
    private List<String> tag;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目描述
     */
    private String desc;

    /**
     * 行业类别名称
     */
    @JSONField(name = "category_name")
    private String categoryName;

    /**
     * 行业类别ID
     */
    private String category;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
