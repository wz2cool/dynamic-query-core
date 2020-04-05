package com.github.wz2cool.dynamic.core.operator;

import com.github.wz2cool.dynamic.core.model.FilterOperator;

/**
 * @author Frank
 */
public class EndWith<T> implements ISingleValueFilterOperator<T> {

    private final T value;

    public EndWith(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public FilterOperator getOperator() {
        return FilterOperator.END_WITH;
    }
}
