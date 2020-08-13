package com.github.cm.heclouds.onenet.studio.api;

import com.github.cm.heclouds.onenet.studio.api.auth.SignatureMethod;
import com.github.cm.heclouds.onenet.studio.api.exception.IotClientException;
import com.github.cm.heclouds.onenet.studio.api.exception.IotServerException;

import java.io.Closeable;
import java.time.Duration;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Provided for developer to call OneNET Studio open API,
 * contains synchronous and asynchronous methods,
 * you can read the following doc for the integral explanation
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/introduce.html">API calling</>
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/auth.html">authorization</a>
 * @author ChengQi
 * @date 2020-07-02 11:14
 */
public interface IotClient extends Closeable {

    SignatureMethod DEFAULT_SIGNATURE_METHOD = SignatureMethod.SHA1;

    /**
     * static factory method for creating IotClient by developer
     * @param profile contains necessary config properties
     * @return IotClient
     */
    static IotClient create(IotProfile profile) {
        Integer expiredAfterHours = profile.expiredAfterHours();
        TemporalAmount expiredDuration;
        if (Objects.isNull(expiredAfterHours) || expiredAfterHours <= 0) {
            expiredDuration = Period.ofYears(100);
        } else {
            expiredDuration = Duration.ofHours(expiredAfterHours);
        }
        SignatureMethod method = profile.signatureMethod();
        if (Objects.isNull(method)) {
            method = DEFAULT_SIGNATURE_METHOD;
        }
        return new DefaultIotClient(profile.userId(), profile.roleId(), profile.accessKey(),
                method, expiredDuration, profile.url(), profile.enableSsl());
    }

    /**
     * send request data to pass and wait response
     * @param request request data
     * @param <T> response type
     * @return response
     * @throws IotClientException if client error
     * @throws IotServerException if server not response success result
     */
    <T extends IotResponse> T sendRequest(AbstractRequest<T> request) throws IotClientException, IotServerException;

    /**
     * send request data to pass asynchronously
     * @param request request data
     * @param <T> response type
     * @return completableFuture contains response or cause
     */
    <T extends IotResponse> CompletableFuture<T> sendRequestAsync(AbstractRequest<T> request);
}
