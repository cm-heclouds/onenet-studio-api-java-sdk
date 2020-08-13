package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.cm.heclouds.onenet.studio.api.entity.enums.RepeatDay;

import java.util.List;

/**
 * @author ChengQi
 * @date 2020/8/13
 */
public class Timer {

    @JSONField(name = "repeat_day")
    private List<RepeatDay> repeatDay;

    @JSONField(name = "_id")
    private String id;

    private String time;

    private String cron;

    public List<RepeatDay> getRepeatDay() {
        return repeatDay;
    }

    public void setRepeatDay(List<RepeatDay> repeatDay) {
        this.repeatDay = repeatDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
