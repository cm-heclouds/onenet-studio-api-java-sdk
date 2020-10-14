package com.github.cm.heclouds.onenet.studio.api.entity.application;

import com.github.cm.heclouds.onenet.studio.api.constant.Constant;
import com.github.cm.heclouds.onenet.studio.api.entity.AbstractPageableRequest;
import com.github.cm.heclouds.onenet.studio.api.entity.AbstractPagedResponse;

/**
 * Application developing request of OneNET Studio API which is pageable
 * @author ChengQi
 * @date 2020-07-06 14:37
 */
public abstract class BasePageableApplicationRequest<T extends AbstractPagedResponse<?>>
        extends AbstractPageableRequest<T> {

    public BasePageableApplicationRequest(String action) {
        super(Constant.OPEN_API_NAMESPACE_APPLICATION, action);
    }
}
