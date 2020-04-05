package com.github.wz2cool.dynamic.core.operator;

import com.github.wz2cool.dynamic.core.model.FilterOperator;

/**
 * @author Frank
 */
public class LessThan<T> implements ISingleValueFilterOperator<T> {
    private final T value;

    public LessThan(T value) {
        this.value = value;
    }

    @Override
    public FilterOperator getOperator() {
        return FilterOperator.LESS_THAN;
    }

    @Override
    public T getValue() {
        return this.value;
    }
}
