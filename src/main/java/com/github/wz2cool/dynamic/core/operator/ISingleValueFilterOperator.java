package com.github.wz2cool.dynamic.core.operator;

/**
 * @author Frank
 */
public interface ISingleValueFilterOperator<T> extends IFilterOperator {
    /**
     * Get and value.
     *
     * @return and value.
     */
    @Override
    T getValue();
}
