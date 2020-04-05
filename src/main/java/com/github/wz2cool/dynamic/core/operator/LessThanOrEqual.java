package com.github.wz2cool.dynamic.core.operator;

import com.github.wz2cool.dynamic.core.model.FilterOperator;

/**
 * @author Frank
 */
public class LessThanOrEqual<T> implements ISingleValueFilterOperator<T> {

    private final T value;

    public LessThanOrEqual(T value) {
        this.value = value;
    }

    @Override
    public FilterOperator getOperator() {
        return FilterOperator.LESS_THAN_OR_EQUAL;
    }

    @Override
    public T getValue() {
        return this.value;
    }
}
