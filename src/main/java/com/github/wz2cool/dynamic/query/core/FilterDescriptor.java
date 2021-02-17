package com.github.wz2cool.dynamic.query.core;

/**
 * the descriptor of filter
 *
 * @author Frank
 **/
public class FilterDescriptor implements IFilterDescriptor {

    private FilterCondition condition = FilterCondition.AND;
    private FilterOperator operator = FilterOperator.EQUAL;

    public FilterCondition getCondition() {
        return condition;
    }

    public void setCondition(FilterCondition condition) {
        this.condition = condition;
    }

    public FilterOperator getOperator() {
        return operator;
    }

    public void setOperator(FilterOperator operator) {
        this.operator = operator;
    }
}
