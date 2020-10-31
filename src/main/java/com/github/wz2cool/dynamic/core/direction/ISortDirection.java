package com.github.wz2cool.dynamic.core.direction;

import com.github.wz2cool.dynamic.core.model.SortDirection;

/**
 * direction of sort
 * 排序方向
 *
 * @author Frank
 */
public interface ISortDirection {
    /**
     * Get sort direction.
     * 获取排序方向
     *
     * @return SortDirection enum. 排序方向枚举
     */
    SortDirection getDirection();
}
