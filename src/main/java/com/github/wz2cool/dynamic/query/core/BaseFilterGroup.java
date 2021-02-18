package com.github.wz2cool.dynamic.query.core;


import com.github.wz2cool.dynamic.query.core.lambda.*;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

/**
 * @author Frank
 **/
public abstract class BaseFilterGroup<T, S extends BaseFilterGroup<T, S>> {

    private IFilterDescriptor[] filters = new IFilterDescriptor[]{};

    public IFilterDescriptor[] getFilters() {
        return filters;
    }

    public void setFilters(IFilterDescriptor[] filters) {
        this.filters = filters;
    }

    public void addFilters(IFilterDescriptor... newFilters) {
        setFilters(ArrayUtils.addAll(filters, newFilters));
    }

    public void removeFilters(IFilterDescriptor... removeFilters) {
        for (IFilterDescriptor removeFilter : removeFilters) {
            setFilters(ArrayUtils.removeAllOccurences(filters, removeFilter));
        }
    }

    public S and(
            GetBigDecimalPropertyFunction<T> getPropertyFunc,
            IFilterOperator<BigDecimal> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public S or(
            GetBigDecimalPropertyFunction<T> getPropertyFunc,
            IFilterOperator<BigDecimal> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public S and(
            boolean enable,
            GetBigDecimalPropertyFunction<T> getPropertyFunc,
            IFilterOperator<BigDecimal> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S or(
            boolean enable,
            GetBigDecimalPropertyFunction<T> getPropertyFunc,
            IFilterOperator<BigDecimal> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S and(
            GetBytePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Byte> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public S or(
            GetBytePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Byte> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public S and(
            boolean enable,
            GetBytePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Byte> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S or(
            boolean enable,
            GetBytePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Byte> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S and(
            GetDatePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Date> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public S or(
            GetDatePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Date> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public S and(
            boolean enable,
            GetDatePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Date> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S or(
            boolean enable,
            GetDatePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Date> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S and(
            GetDoublePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Double> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public S or(
            GetDoublePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Double> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public S and(
            boolean enable,
            GetDoublePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Double> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S or(
            boolean enable,
            GetDoublePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Double> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S and(
            GetFloatPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Float> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public S or(
            GetFloatPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Float> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public S and(
            boolean enable,
            GetFloatPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Float> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S or(
            boolean enable,
            GetFloatPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Float> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S and(
            GetIntegerPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Integer> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public S or(
            GetIntegerPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Integer> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public S and(
            boolean enable,
            GetIntegerPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Integer> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S or(
            boolean enable,
            GetIntegerPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Integer> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S and(
            GetLongPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Long> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public S or(
            GetLongPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Long> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public S and(
            boolean enable,
            GetLongPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Long> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S or(
            boolean enable,
            GetLongPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Long> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S and(
            GetShortPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Short> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public S or(
            GetShortPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Short> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public S and(
            boolean enable,
            GetShortPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Short> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S or(
            boolean enable,
            GetShortPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Short> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S and(
            GetStringPropertyFunction<T> getPropertyFunc,
            IFilterOperator<String> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public S or(
            GetStringPropertyFunction<T> getPropertyFunc,
            IFilterOperator<String> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public S and(
            boolean enable,
            GetStringPropertyFunction<T> getPropertyFunc,
            IFilterOperator<String> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S or(
            boolean enable,
            GetStringPropertyFunction<T> getPropertyFunc,
            IFilterOperator<String> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public S and(UnaryOperator<FilterGroupDescriptor<T>> groupConsumer) {
        return and(true, groupConsumer);
    }

    public S or(UnaryOperator<FilterGroupDescriptor<T>> groupConsumer) {
        return or(true, groupConsumer);
    }

    public S and(boolean enable, UnaryOperator<FilterGroupDescriptor<T>> groupConsumer) {
        if (enable) {
            FilterGroupDescriptor<T> filterGroupDescriptor = new FilterGroupDescriptor<>();
            filterGroupDescriptor.setCondition(FilterCondition.AND);
            this.addFilters(groupConsumer.apply(filterGroupDescriptor));
        }
        return (S) this;
    }

    public S or(boolean enable, UnaryOperator<FilterGroupDescriptor<T>> groupConsumer) {
        if (enable) {
            FilterGroupDescriptor<T> filterGroupDescriptor = new FilterGroupDescriptor<>();
            filterGroupDescriptor.setCondition(FilterCondition.OR);
            this.addFilters(groupConsumer.apply(filterGroupDescriptor));
        }
        return (S) this;
    }

    private <R extends Comparable> S filterInternal(
            FilterCondition condition,
            GetPropertyFunction<T, R> getPropertyFunc,
            FilterOperator operator, Object filterValue, boolean enable) {
        if (enable) {
            FilterDescriptor filterDescriptor = new FilterDescriptor();
            String propertyName = CommonsHelper.getPropertyName(getPropertyFunc);
            filterDescriptor.setCondition(condition);
            filterDescriptor.setPropertyName(propertyName);
            filterDescriptor.setOperator(operator);
            filterDescriptor.setValue(filterValue);
            this.addFilters(filterDescriptor);
        }
        return (S) this;
    }
}
