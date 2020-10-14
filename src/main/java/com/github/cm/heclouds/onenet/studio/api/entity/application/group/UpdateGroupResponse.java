package com.github.cm.heclouds.onenet.studio.api.entity.application.group;

import com.github.cm.heclouds.onenet.studio.api.AbstractResponse;

/**
 * 分组编辑响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/updateGroup.html">分组编辑</a>
 * @author ChengQi
 * @date 2020/10/14
 */
public class UpdateGroupResponse extends AbstractResponse {

    /**
     * 分组ID
     */
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
