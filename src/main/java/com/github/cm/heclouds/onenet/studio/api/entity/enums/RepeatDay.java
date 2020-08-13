package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.alibaba.fastjson.annotation.JSONType;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;
import com.github.cm.heclouds.onenet.studio.api.json.ValueHolderDeserializer;

/**
 * 重复周期
 * @author ChengQi
 * @date 2020/8/13
 */
@JSONType(deserializer = ValueHolderDeserializer.class)
public enum RepeatDay implements ValueHolder<String> {

    /**
     * 星期一
     */
    MONDAY("mon"),
    /**
     * 星期二
     */
    TUESDAY("tue"),
    /**
     * 星期三
     */
    WEDNESDAY("wed"),
    /**
     * 星期四
     */
    THURSDAY("thu"),
    /**
     * 星期五
     */
    FRIDAY("fri"),
    /**
     * 星期六
     */
    SATURDAY("sat"),
    /**
     * 星期天
     */
    SUNDAY("sun");

    private String value;

    RepeatDay(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
