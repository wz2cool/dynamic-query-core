package com.github.wz2cool.dynamic.query.core;

/**
 * the descriptor of filter group
 *
 * @author Frank
 **/
public class FilterGroupDescriptor<T> implements IFilterDescriptor {

    private FilterCondition condition = FilterCondition.AND;

    public FilterCondition getCondition() {
        return condition;
    }

    public void setCondition(FilterCondition condition) {
        this.condition = condition;
    }
}
