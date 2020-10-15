package com.github.cm.heclouds.onenet.studio.api.json;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * The implement class of {@link ObjectSerializer} which id used to
 * serialize OneNET Studio enums
 * @author ChengQi
 * @date 2020-07-10 13:32
 */
public class ValueHolderSerializer implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
            throws IOException {
        if (!(object instanceof ValueHolder)) {
            throw new IOException("except " + ValueHolder.class + " type, but get " + object.getClass());
        }
        ValueHolder<?> valueHolder = (ValueHolder<?>) object;
        serializer.write(valueHolder.getValue());
    }
}
