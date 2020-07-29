package com.github.cm.heclouds.onenet.studio.api.entity.application;

import com.github.cm.heclouds.onenet.studio.api.AbstractRequest;
import com.github.cm.heclouds.onenet.studio.api.IotResponse;
import com.github.cm.heclouds.onenet.studio.api.constant.Constant;

/**
 * Application developing request of OneNET Studio API
 * @author ChengQi
 * @date 2020-07-02 14:05
 */
public abstract class BaseApplicationRequest<T extends IotResponse> extends AbstractRequest<T> {

    public BaseApplicationRequest(Method method, String action) {
        super(Constant.OPEN_API_NAMESPACE_APPLICATION, method, action);
    }
}
