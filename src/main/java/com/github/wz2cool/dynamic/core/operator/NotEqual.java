package com.github.wz2cool.dynamic.core.operator;

import com.github.wz2cool.dynamic.core.model.FilterOperator;

/**
 * @author Frank
 */
public class NotEqual<T> implements ISingleValueFilterOperator<T> {

    private final T value;

    public NotEqual(T value) {
        this.value = value;
    }

    @Override
    public FilterOperator getOperator() {
        return FilterOperator.NOT_EQUAL;
    }

    @Override
    public T getValue() {
        return this.value;
    }
}
