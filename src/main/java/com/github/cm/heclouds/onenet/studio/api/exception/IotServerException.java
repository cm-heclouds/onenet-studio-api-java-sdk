package com.github.cm.heclouds.onenet.studio.api.exception;

/**
 * Exception of OneNET Studio API calling, which is a sub class of {@link IotException},
 * it`s thrown when the pass return a unsuccessful response or http is not 200,
 * the following document shows specific error codes
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/code.html">error codes</a>
 * @author ChengQi
 * @date 2020-07-02 11:12
 */
public class IotServerException extends IotException {

    private String requestId;
    private String code;
    private String msg;

    public IotServerException(String requestId, String code, String msg) {
        this(msg);
        this.requestId = requestId;
        this.code = code;
        this.msg = msg;
    }

    public IotServerException(String code, String msg) {
        this(null, code, msg);
    }

    public IotServerException(int code) {
        this(null, String.valueOf(code), "network error, status:" + code);
    }

    public IotServerException(String message) {
        super(message);
    }

    public IotServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getRequestId() {
        return requestId;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
