package com.github.cm.heclouds.onenet.studio.api.exception;

/**
 * Exception of OneNET Studio API calling, which is a sub class of {@link IotException},
 * it`s thrown when the sdk has error
 * @author ChengQi
 * @date 2020-07-02 11:12
 */
public class IotClientException extends IotException {

    public IotClientException(String message) {
        super(message);
    }

    public IotClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
