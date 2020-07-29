package com.github.cm.heclouds.onenet.studio.api;

import com.github.cm.heclouds.onenet.studio.api.json.ValueHolder;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * The implement class of {@link Interceptor} which helping to build request
 * @author ChengQi
 * @date 2020-07-03 9:19
 */
public class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        AbstractRequest<?> tag = request.tag(AbstractRequest.class);
        HttpUrl.Builder urlBuilder = request.url().newBuilder();
        urlBuilder.addPathSegment(tag.getNameSpace());
        Map<String, Object> queryParams = tag.getQueryParams();
        queryParams.forEach((name, value) -> {
            String parameter = null;
            if (!Objects.isNull(value)) {
                parameter = value.toString();
                if (value instanceof ValueHolder) {
                    parameter = ((ValueHolder) value).getValue().toString();
                }
            }
            urlBuilder.addQueryParameter(name, parameter);
        });
        request = request.newBuilder().url(urlBuilder.build()).build();
        return chain.proceed(request);
    }
}
