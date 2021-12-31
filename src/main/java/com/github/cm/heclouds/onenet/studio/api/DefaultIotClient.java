package com.github.cm.heclouds.onenet.studio.api;

import com.alibaba.fastjson.JSONObject;
import com.github.cm.heclouds.onenet.studio.api.auth.AuthorizationInterceptor;
import com.github.cm.heclouds.onenet.studio.api.auth.Signature;
import com.github.cm.heclouds.onenet.studio.api.auth.SignatureMethod;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;
import com.github.cm.heclouds.onenet.studio.api.exception.IotClientException;
import com.github.cm.heclouds.onenet.studio.api.exception.IotException;
import com.github.cm.heclouds.onenet.studio.api.exception.IotServerException;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAmount;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Default implement class of {@link IotClient}, it is based on OkHttp.
 * How to create it for calling API?
 * @see IotClient#create(IotProfile)
 * @author ChengQi
 * @date 2020-07-02 13:38
 */
public class DefaultIotClient implements IotClient {

    private static final String VERSION = Constant.OPEN_API_SIGN_VERSION;

    private boolean initialSuccess = false;
    private IotClientException initialError;

    private String passUrl = Constant.OPEN_API_URL;
    private OkHttpClient client;

    DefaultIotClient(String userId, String projectId, String groupId, String accessKey,
                     SignatureMethod method, TemporalAmount temporalAmount, String url, boolean enableSsl) {
        try {
            if (!checkConstructParams(userId, projectId, groupId, accessKey, method)) {
                return;
            }
            Signature signature = new Signature(VERSION, generateResource(userId, projectId, groupId),
                    convertExpireTime(temporalAmount), method);
            Interceptor authorization = new AuthorizationInterceptor(signature, accessKey);
            initClient(authorization, new RequestInterceptor());
            initPassUrl(enableSsl, url);
            initialSuccess = true;
        } catch (NoSuchAlgorithmException e) {
            initialError = new IotClientException("not support signature method", e);
        } catch (InvalidKeyException e) {
            initialError = new IotClientException("invalid accessKey", e);
        } catch (Exception e) {
            initialError = new IotClientException(e.getMessage(), e);
        }
    }

    @Override
    public <T extends IotResponse> T sendRequest(AbstractRequest<T> request)
            throws IotClientException, IotServerException {
        if (!initialSuccess) {
            throw initialError;
        }
        try {
            Call call = client.newCall(buildRequest(request));
            Response response = call.execute();
            return resolveResponse(response, request);
        } catch (IotException e) {
            throw e;
        } catch (Exception e) {
            throw new IotClientException(e.getMessage(), e);
        }
    }

    @Override
    public <T extends IotResponse> CompletableFuture<T> sendRequestAsync(AbstractRequest<T> request) {
        CompletableFuture<T> future = new CompletableFuture<>();
        if (!initialSuccess) {
            future.completeExceptionally(initialError);
            return future;
        }
        try {
            Call call = client.newCall(buildRequest(request));
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    future.completeExceptionally(new IotClientException(e.getMessage(), e));
                }

                @Override
                public void onResponse(Call call, Response response) {
                    try {
                        T result = resolveResponse(response, request);
                        future.complete(result);
                    } catch (IotException e) {
                        future.completeExceptionally(e);
                    } catch (Exception e) {
                        future.completeExceptionally(new IotClientException(e.getMessage(), e));
                    }
                }
            });
        } catch (Exception e) {
            future.completeExceptionally(new IotClientException(e.getMessage(), e));
        }
        return future;
    }

    /**
     * using {@link AbstractRequest} to build {@link Request}
     * @param request IotRequest
     * @return OkHttpRequest
     */
    private Request buildRequest(AbstractRequest<?> request) {
        return request.requestBuilder().url(passUrl).build();
    }

    /**
     * resolve {@link Response} and convert to a {@link IotResponse} or throw Exception
     * @param response OkHttpResponse
     * @param request IotRequest
     * @param <T> IotResponse type
     * @return IotResponse
     * @throws IotServerException if pass return not success response or http error
     * @throws IOException if resolve body error
     */
    private <T extends IotResponse> T resolveResponse(Response response, AbstractRequest<T> request)
            throws IotServerException, IOException {
        try(Response finalResponse = response) {
            if (!finalResponse.isSuccessful()) {
                throw new IotServerException(String.format(Constant.IOT_PROTOCOL_FORMAT, finalResponse.code()),
                        finalResponse.message());
            }
            JSONObject jsonObject = JSONObject.parseObject(new String(Objects.requireNonNull(finalResponse.body()).bytes(),
                    StandardCharsets.UTF_8));
            String requestId = jsonObject.getString("requestId");
            if (!jsonObject.getBoolean("success")) {
                String code = jsonObject.getString("code");
                String msg = jsonObject.getString("msg");
                throw new IotServerException(requestId, code, msg);
            }
            String content = jsonObject.getString("data");
            T result = request.newResponse(content);
            result.setRequestId(requestId);
            return result;
        }
    }

    /**
     * it is called to validate parameters by constructor
     * @param userId OneNET Studio userId
     * @param projectId OneNET Studio projectId
     * @param groupId OneNET Studio groupId
     * @param accessKey OneNET Studio accessKey
     * @param method signature method
     * @return {@code true} if validate successful,{@code false} or else
     */
    private boolean checkConstructParams(String userId, String projectId, String groupId,
                                         String accessKey, SignatureMethod method) {
        boolean resInfoInvalid = StringUtils.isEmpty(userId) &&
                (StringUtils.isEmpty(projectId) || StringUtils.isEmpty(groupId));
        if (resInfoInvalid) {
            initialError = new IotClientException("need userId or (projectId and groupId)");
            return false;
        }
        if (StringUtils.isEmpty(accessKey)) {
            initialError = new IotClientException("accessKey is empty");
            return false;
        }
        if (Objects.isNull(method)) {
            initialError = new IotClientException("signature method is null");
            return false;
        }
        return true;
    }

    /**
     * init OkHttpClient
     * @param interceptors for building client
     */
    private void initClient(Interceptor... interceptors) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        for (Interceptor interceptor: interceptors) {
            builder.addInterceptor(interceptor);
        }
        client = builder.build();
    }

    /**
     * OneNET pass host settings
     * @param enableSsl using https
     * @param url not required
     */
    private void initPassUrl(boolean enableSsl, String url) {
        if (enableSsl) {
            passUrl = Constant.OPEN_API_URL_SSL;
        }
        if (StringUtils.isNotEmpty(url)) {
            passUrl = url;
        }
    }

    /**
     * generate resource
     * @param userId OneNET Studio userId
     * @param projectId OneNET Studio projectId
     * @param groupId OneNET Studio groupId
     * @return resource
     */
    private String generateResource(String userId, String projectId, String groupId) {
        if (StringUtils.isNotEmpty(userId)) {
            return "userid/" + userId;
        }
        return "projectid/" + projectId + "/groupid/" + groupId;
    }

    /**
     * convert expire time to timestamp
     * @param temporalAmount expire duration
     * @return expire time
     */
    private long convertExpireTime(TemporalAmount temporalAmount) {
        LocalDateTime expireTime = LocalDateTime.now().plus(temporalAmount);
        return expireTime.toInstant(ZoneOffset.of("+8")).getEpochSecond();
    }

    @Override
    public void close() throws IOException {
        if (!Objects.isNull(client)) {
            client.dispatcher().executorService().shutdown();
            client.connectionPool().evictAll();
            Cache cache = client.cache();
            if (!Objects.isNull(cache)) {
                cache.close();
            }
        }
    }
}
