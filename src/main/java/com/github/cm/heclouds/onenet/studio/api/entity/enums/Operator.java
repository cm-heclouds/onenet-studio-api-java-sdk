package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 比较运算符 枚举类型
 * @author ChengQi
 * @date 2020-07-10 17:37
 */
public enum Operator implements ValueHolder<String> {

    /**
     * 等于
     */
    EQ("eq"),
    /**
     * 小于
     */
    LT("lt"),
    /**
     * 大于
     */
    GT("gt"),
    /**
     * 小于等于
     */
    LTE("lte"),
    /**
     * 大于等于
     */
    GTE("gte");

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
