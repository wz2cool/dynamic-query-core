package com.github.wz2cool.dynamic.core;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author Frank
 **/
public class FilterGroupDescriptor implements IFilterDescriptor {

    private FilterCondition condition = FilterCondition.AND;
    private IFilterDescriptor[] filters = new IFilterDescriptor[]{};

    @Override
    public FilterCondition getCondition() {
        return condition;
    }

    @Override
    public void setCondition(FilterCondition condition) {
        this.condition = condition;
    }

    public IFilterDescriptor[] getFilters() {
        return filters;
    }

    public void setFilters(IFilterDescriptor[] filters) {
        this.filters = filters;
    }

    public void addFilters(IFilterDescriptor... newFilters) {
        setFilters(ArrayUtils.addAll(filters, newFilters));
    }
}
