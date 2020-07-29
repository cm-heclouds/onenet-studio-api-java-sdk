package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

import com.github.cm.heclouds.onenet.studio.api.constant.Constant;
import com.github.cm.heclouds.onenet.studio.api.entity.application.BasePageableApplicationRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/**
 * 场景联动触发日志请求
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/querySceneLog.html">场景联动触发日志</a>
 * @author ChengQi
 * @date 2020/7/8
 */
public class QuerySceneLogRequest extends BasePageableApplicationRequest<QuerySceneLogResponse> {

    public QuerySceneLogRequest() {
        super("QuerySceneLog");
    }

    /**
     * 设置项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(String projectId) {
        queryParam("project_id", projectId);
    }

    /**
     * 设置场景联动规则ID
     * @param sceneId 场景联动规则ID
     */
    public void setSceneId(String sceneId) {
        queryParam("scene_id", sceneId);
    }

    /**
     * 设置查询开始时间
     * @param startTime 查询开始时间
     */
    public void setStartTime(Date startTime) {
        String date = null;
        if (!Objects.isNull(startTime)) {
            SimpleDateFormat format = new SimpleDateFormat(Constant.DATE_TIME_FORMAT_WITH_ZONE);
            format.setTimeZone(TimeZone.getTimeZone("GMT"));
            date = format.format(startTime);
        }
        queryParam("start_time", date);
    }

    /**
     * 设置查询结束时间
     * @param endTime 查询结束时间
     */
    public void setEndTime(Date endTime) {
        String date = null;
        if (!Objects.isNull(endTime)) {
            SimpleDateFormat format = new SimpleDateFormat(Constant.DATE_TIME_FORMAT_WITH_ZONE);
            format.setTimeZone(TimeZone.getTimeZone("GMT"));
            date = format.format(endTime);
        }
        queryParam("end_time", date);
    }

    @Override
    protected Class<QuerySceneLogResponse> getResponseType() {
        return QuerySceneLogResponse.class;
    }
}
