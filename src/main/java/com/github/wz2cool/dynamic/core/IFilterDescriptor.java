package com.github.wz2cool.dynamic.core;

/**
 * @author Frank
 */
public interface IFilterDescriptor {
    /**
     * get condition of and
     *
     * @return condition of and
     */
    FilterCondition getCondition();

    /**
     * set condition
     *
     * @param condition condition of and
     */
    void setCondition(FilterCondition condition);
}
