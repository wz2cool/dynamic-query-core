package com.github.wz2cool.dynamic.core.operator;

import com.github.wz2cool.dynamic.core.model.FilterOperator;

/**
 * @author Frank
 */
public class Contains<T> implements ISingleValueFilterOperator<T> {

    private final T value;

    public Contains(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public FilterOperator getOperator() {
        return FilterOperator.CONTAINS;
    }
}
