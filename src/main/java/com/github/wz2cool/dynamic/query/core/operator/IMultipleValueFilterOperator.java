package com.github.wz2cool.dynamic.query.core.operator;

import java.util.List;

/**
 * @author Frank
 */
public interface IMultipleValueFilterOperator<T> extends IFilterOperator {
    /**
     * Get value.
     *
     * @return the value.
     */
    List<T> getValue();
}
