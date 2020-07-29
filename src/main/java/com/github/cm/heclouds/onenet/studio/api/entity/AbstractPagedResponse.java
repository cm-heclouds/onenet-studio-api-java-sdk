package com.github.cm.heclouds.onenet.studio.api.entity;

import com.github.cm.heclouds.onenet.studio.api.AbstractResponse;

import java.util.List;

/**
 * Paged response of OneNET Studio API
 * @author ChengQi
 * @date 2020-07-06 14:29
 */
public abstract class AbstractPagedResponse<T> extends AbstractResponse {

    /**
     * 分页信息
     */
    private Meta meta;

    /**
     * 信息集合
     */
    private List<T> list;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
