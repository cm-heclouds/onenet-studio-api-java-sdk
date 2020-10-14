package com.github.cm.heclouds.onenet.studio.api.entity.enums;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;

/**
 * 数据类型 枚举类型
 * @author ChengQi
 * @date 2020-07-10 17:06
 */
public enum DataType implements ValueHolder<String> {

    /**
     * 整数型
     */
    INT32("int32"),
    /**
     * 长整形
     */
    INT64("int64"),
    /**
     * 单精度浮点型
     */
    FLOAT("float"),
    /**
     * 双精度浮点型
     */
    DOUBLE("double"),
    /**
     * 枚举
     */
    ENUM("enum"),
    /**
     * 布尔
     */
    BOOL("bool"),
    /**
     * 字符串
     */
    STRING("string"),
    /**
     * 结构体
     */
    STRUCT("struct"),
    /**
     * 位图
     */
    BIT_MAP("bitMap"),
    /**
     * int64类型UTC时间戳毫秒
     */
    DATE("date"),
    /**
     * 数组
     */
    ARRAY("array");

    private final String value;

    DataType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
