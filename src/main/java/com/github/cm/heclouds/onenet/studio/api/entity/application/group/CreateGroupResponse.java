package com.github.cm.heclouds.onenet.studio.api.entity.application.group;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.AbstractResponse;

/**
 * 分组创建响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/createGroup.html">分组创建</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class CreateGroupResponse extends AbstractResponse {

    /**
     * 分组ID
     */
    @JSONField(name = "group_id")
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
