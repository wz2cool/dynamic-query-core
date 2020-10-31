package com.github.wz2cool.dynamic.core.direction;

import com.github.wz2cool.dynamic.core.model.SortDirection;

/**
 * Descending
 *
 * 降序
 *
 * @author Frank
 */
public class Descending implements ISortDirection {
    @Override
    public SortDirection getDirection() {
        return SortDirection.DESC;
    }
}
