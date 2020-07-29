package com.github.cm.heclouds.onenet.studio.api.entity;

/**
 * 分页信息
 * @author ChengQi
 * @date 2020-07-06 14:34
 */
public class Meta {

    /**
     * 每次请求记录数
     */
    private Integer limit;

    /**
     * 请求记录起始位置
     */
    private Integer offset;

    /**
     * 记录总数
     */
    private Integer total;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
