package com.github.cm.heclouds.onenet.studio.api.entity.application.device;

import com.github.cm.heclouds.onenet.studio.api.AbstractResponse;

/**
 * 设备属性设置响应
 * <a href="https://open.iot.10086.cn/doc/iot_platform/book/api/application/setDeviceProperty.html">设备属性设置</a>
 * @author ChengQi
 * @date 2020-07-06 17:18
 */
public class SetDevicePropertyResponse extends AbstractResponse {

    /**
     * 设备端回复消息id
     */
    private String id;

    /**
     * 设备端回复响应码
     */
    private Integer code;

    /**
     * 设备端回复响应消息
     */
    private String msg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
