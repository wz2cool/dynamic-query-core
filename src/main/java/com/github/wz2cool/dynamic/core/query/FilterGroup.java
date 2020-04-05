package com.github.wz2cool.dynamic.core.query;

import com.github.wz2cool.dynamic.core.helper.CommonsHelper;
import com.github.wz2cool.dynamic.core.lambda.*;
import com.github.wz2cool.dynamic.core.model.FilterCondition;
import com.github.wz2cool.dynamic.core.model.FilterDescriptor;
import com.github.wz2cool.dynamic.core.model.FilterGroupDescriptor;
import com.github.wz2cool.dynamic.core.model.FilterOperator;
import com.github.wz2cool.dynamic.core.operator.IFilterOperator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.function.UnaryOperator;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public class FilterGroup<T> extends FilterGroupDescriptor {

    public FilterGroup<T> and(
            GetBigDecimalPropertyFunction<T> getPropertyFunc,
            IFilterOperator<BigDecimal> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> or(
            GetBigDecimalPropertyFunction<T> getPropertyFunc,
            IFilterOperator<BigDecimal> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> and(
            boolean enable,
            GetBigDecimalPropertyFunction<T> getPropertyFunc,
            IFilterOperator<BigDecimal> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> or(
            boolean enable,
            GetBigDecimalPropertyFunction<T> getPropertyFunc,
            IFilterOperator<BigDecimal> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> and(
            GetBytePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Byte> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> or(
            GetBytePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Byte> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> and(
            boolean enable,
            GetBytePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Byte> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> or(
            boolean enable,
            GetBytePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Byte> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> and(
            GetDatePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Date> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> or(
            GetDatePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Date> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> and(
            boolean enable,
            GetDatePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Date> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> or(
            boolean enable,
            GetDatePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Date> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> and(
            GetDoublePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Double> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> or(
            GetDoublePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Double> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> and(
            boolean enable,
            GetDoublePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Double> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> or(
            boolean enable,
            GetDoublePropertyFunction<T> getPropertyFunc,
            IFilterOperator<Double> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> and(
            GetFloatPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Float> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> or(
            GetFloatPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Float> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> and(
            boolean enable,
            GetFloatPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Float> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> or(
            boolean enable,
            GetFloatPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Float> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> and(
            GetIntegerPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Integer> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> or(
            GetIntegerPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Integer> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> and(
            boolean enable,
            GetIntegerPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Integer> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> or(
            boolean enable,
            GetIntegerPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Integer> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> and(
            GetLongPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Long> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> or(
            GetLongPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Long> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> and(
            boolean enable,
            GetLongPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Long> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> or(
            boolean enable,
            GetLongPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Long> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> and(
            GetShortPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Short> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> or(
            GetShortPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Short> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> and(
            boolean enable,
            GetShortPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Short> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> or(
            boolean enable,
            GetShortPropertyFunction<T> getPropertyFunc,
            IFilterOperator<Short> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> and(
            GetStringPropertyFunction<T> getPropertyFunc,
            IFilterOperator<String> filterOperator) {
        return and(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> or(
            GetStringPropertyFunction<T> getPropertyFunc,
            IFilterOperator<String> filterOperator) {
        return or(true, getPropertyFunc, filterOperator);
    }

    public FilterGroup<T> and(
            boolean enable,
            GetStringPropertyFunction<T> getPropertyFunc,
            IFilterOperator<String> filterOperator) {
        return filterInternal(FilterCondition.AND, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> or(
            boolean enable,
            GetStringPropertyFunction<T> getPropertyFunc,
            IFilterOperator<String> filterOperator) {
        return filterInternal(FilterCondition.OR, getPropertyFunc, filterOperator.getOperator(), filterOperator.getValue(), enable);
    }

    public FilterGroup<T> and(UnaryOperator<FilterGroup<T>> groupConsumer) {
        return and(true, groupConsumer);
    }

    public FilterGroup<T> or(UnaryOperator<FilterGroup<T>> groupConsumer) {
        return or(true, groupConsumer);
    }

    public FilterGroup<T> and(boolean enable, UnaryOperator<FilterGroup<T>> groupConsumer) {
        if (enable) {
            FilterGroup<T> filterGroup = new FilterGroup<>();
            filterGroup.setCondition(FilterCondition.AND);
            this.addFilters(groupConsumer.apply(filterGroup));
        }
        return this;
    }

    public FilterGroup<T> or(boolean enable, UnaryOperator<FilterGroup<T>> groupConsumer) {
        if (enable) {
            FilterGroup<T> filterGroup = new FilterGroup<>();
            filterGroup.setCondition(FilterCondition.OR);
            this.addFilters(groupConsumer.apply(filterGroup));
        }
        return this;
    }

    private <R extends Comparable> FilterGroup<T> filterInternal(
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
        return this;
    }
}
