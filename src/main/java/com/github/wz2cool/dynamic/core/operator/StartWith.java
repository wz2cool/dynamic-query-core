package com.github.wz2cool.dynamic.core.operator;

import com.github.wz2cool.dynamic.core.model.FilterOperator;

/**
 * @author Frank
 */
public class StartWith<T> implements ISingleValueFilterOperator {

    private final T value;

    public StartWith(T value) {
        this.value = value;
    }

    @Override
    public FilterOperator getOperator() {
        return FilterOperator.START_WITH;
    }

    @Override
    public T getValue() {
        return this.value;
    }
}
