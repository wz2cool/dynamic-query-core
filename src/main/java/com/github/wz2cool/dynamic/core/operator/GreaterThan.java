package com.github.wz2cool.dynamic.core.operator;

import com.github.wz2cool.dynamic.core.model.FilterOperator;

/**
 * @author Frank
 */
public class GreaterThan<T> implements ISingleValueFilterOperator<T> {

    private final T value;

    public GreaterThan(T value) {
        this.value = value;
    }

    @Override
    public FilterOperator getOperator() {
        return FilterOperator.GREATER_THAN;
    }

    @Override
    public T getValue() {
        return this.value;
    }
}
