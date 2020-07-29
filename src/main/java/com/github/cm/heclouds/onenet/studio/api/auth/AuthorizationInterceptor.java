package com.github.cm.heclouds.onenet.studio.api.auth;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * {@link Interceptor} for authorization, reference
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/auth.html"></a>
 * @author ChengQi
 * @date 2020-07-03 8:51
 */
public class AuthorizationInterceptor implements Interceptor {

    private Signature signature;
    private String accessKey;
    private String authorization;

    public AuthorizationInterceptor(Signature signature, String accessKey) throws Exception {
        this.signature = signature;
        this.accessKey = accessKey;
        initAuthHeader();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .header("authorization", authorization)
                .build();
        return chain.proceed(request);
    }

    private void initAuthHeader() throws Exception {
        String sign = signature.sign(accessKey);
        sign = URLEncoder.encode(sign, "UTF-8");
        String res = URLEncoder.encode(signature.res, "UTF-8");
        authorization = "version=" + signature.version
                + "&res=" + res
                + "&et=" + signature.et
                + "&method=" + signature.method.getMethodName()
                + "&sign=" + sign;
    }
}
