package com.github.wz2cool.dynamic.query.core;

/**
 * 筛选描述器接口
 *
 * @author Frank
 **/
public interface IFilterDescriptor {
    /**
     * get condition
     *
     * @return condition
     */
    FilterCondition getCondition();

    /**
     * set condition
     *
     * @param condition condition of and
     */
    void setCondition(FilterCondition condition);
}
