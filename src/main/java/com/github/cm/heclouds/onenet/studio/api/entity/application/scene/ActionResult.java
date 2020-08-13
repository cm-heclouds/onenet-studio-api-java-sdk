package com.github.cm.heclouds.onenet.studio.api.entity.application.scene;

/**
 * 执行动作结果
 * @author ChengQi
 * @date 2020/7/8
 */
public class ActionResult extends ActionExpand {

    /**
     * 执行结果
     */
    private Boolean success;

    /**
     * 执行错误码
     */
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
