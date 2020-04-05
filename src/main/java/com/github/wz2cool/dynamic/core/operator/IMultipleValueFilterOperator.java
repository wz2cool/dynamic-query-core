package com.github.wz2cool.dynamic.core.operator;

import java.util.List;

/**
 * @author Frank
 */
public interface IMultipleValueFilterOperator<T> extends IFilterOperator {
    /**
     * Get and value.
     *
     * @return and value.
     */
    @Override
    List<T> getValue();
}
