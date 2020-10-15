package com.github.cm.heclouds.onenet.studio.api.json;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.stream.Stream;

/**
 * The implement class of {@link ObjectDeserializer} which is used to
 * deserialize OneNET Studio enums
 * @author ChengQi
 * @date 2020-07-10 13:59
 */
@SuppressWarnings("unchecked")
public class ValueHolderDeserializer implements ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        Class<?> typeClass = (Class<?>) type;
        if (!typeClass.isEnum()) {
            throw new IllegalStateException("except enum, but class:" + typeClass + " is not");
        }
        if (!ValueHolder.class.isAssignableFrom(typeClass)) {
            throw new IllegalStateException(typeClass + " must be ValueHolder");
        }
        Class<?> genericType = getValueHolderGenericType(typeClass);
        Object originalValue = parser.parseObject(genericType);
        ValueHolder<?>[] allPossibilities = (ValueHolder<?>[]) typeClass.getEnumConstants();
        return (T) Stream.of(allPossibilities)
                .filter(possibility -> possibility.getValue().equals(originalValue))
                .findAny()
                .orElse(null);
    }

    /**
     * get actual generic type of {@link ValueHolder}
     * @param clazz OneNET Studio enum type
     * @return actual type
     */
    private Class<?> getValueHolderGenericType(Class<?> clazz) {
        Type[] interfaces = clazz.getGenericInterfaces();
        Type genericType = Stream.of(interfaces)
                .filter(itf -> {
                    ParameterizedType type = (ParameterizedType) itf;
                    return type.getRawType() == ValueHolder.class;
                })
                .map(itf -> ((ParameterizedType) itf).getActualTypeArguments()[0])
                .findAny()
                .orElseThrow(() -> new IllegalStateException("could`t find actual generic type of ValueHolder"));
        return (Class<?>) genericType;
    }

    @Override
    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }
}
