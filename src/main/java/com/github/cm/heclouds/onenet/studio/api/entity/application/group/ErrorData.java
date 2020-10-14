package com.github.cm.heclouds.onenet.studio.api.entity.application.group;

/**
 * 失败的错误信息
 * @author ChengQi
 * @date 2020/10/14
 */
public class ErrorData {

    /**
     * 移除失败原因
     */
    private String cause;

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
