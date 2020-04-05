package com.github.wz2cool.dynamic.core.operator;

import java.util.List;

/**
 * @author Frank
 */
public interface ITwoValueFilterOperator<T> extends IFilterOperator<T> {
    /**
     * Get and value.
     *
     * @return and value.
     */
    @Override
    List<T> getValue();
}
