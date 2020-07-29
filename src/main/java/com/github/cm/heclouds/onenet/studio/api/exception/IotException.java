package com.github.cm.heclouds.onenet.studio.api.exception;

/**
 * Exception of OneNET Studio API calling
 * @author ChengQi
 * @date 2020-07-02 11:11
 */
public class IotException extends Exception {

    public IotException(String message) {
        super(message);
    }

    public IotException(String message, Throwable cause) {
        super(message, cause);
    }
}
