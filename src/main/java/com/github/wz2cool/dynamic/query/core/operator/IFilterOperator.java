package com.github.wz2cool.dynamic.query.core.operator;

import com.github.wz2cool.dynamic.query.core.FilterOperator;

/**
 * @author Frank
 */
@SuppressWarnings("squid:S2326")
public interface IFilterOperator {
    /**
     * Get operator.
     *
     * @return filterOperator enum.
     */
    FilterOperator getOperator();

    /**
     * Get value.
     *
     * @return the value.
     */
    Object getValue();
}
