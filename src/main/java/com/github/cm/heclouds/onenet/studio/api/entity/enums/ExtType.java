package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 第三方数据类型
 * @author ChengQi
 * @date 2020/8/13
 */
public enum ExtType implements ValueHolder<String> {

    /**
     * 第三方数据类型
     */
    WEATHER("weather"),
    TEMPERATURE("temperature"),
    HUMIDITY("humidity"),
    PM25("pm25"),
    AIR_QUALITY("airquality");

    private String value;

    ExtType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
