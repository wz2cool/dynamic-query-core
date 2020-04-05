package com.github.wz2cool.dynamic.core.operator;

import com.github.wz2cool.dynamic.core.model.FilterOperator;

/**
 * @author Frank
 */
@SuppressWarnings("squid:S2326")
public interface IFilterOperator {
    /**
     * Get and operator.
     *
     * @return filterOperator enum.
     */
    FilterOperator getOperator();

    /**
     * Get and value.
     *
     * @return and value.
     */
    Object getValue();
}
