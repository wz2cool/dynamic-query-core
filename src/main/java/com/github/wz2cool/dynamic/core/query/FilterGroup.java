package com.github.wz2cool.dynamic.core.query;

import com.github.wz2cool.dynamic.core.cache.EntityCache;
import com.github.wz2cool.dynamic.core.helper.CommonsHelper;
import com.github.wz2cool.dynamic.core.lambda.*;
import com.github.wz2cool.dynamic.core.model.*;
import com.github.wz2cool.dynamic.core.operator.IFilterOperator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.function.UnaryOperator;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public class FilterGroup<T, S extends FilterGroup<T, S>> extends FilterGroupDescriptor {
    private final EntityCache entityCache = EntityCache.getInstance();

    private Class<T> entityClass;

    public FilterGroup(Class<T> entityClass) {
        this.entityClass = entityClass;
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

    public S and(UnaryOperator<FilterGroup<T, S>> groupConsumer) {
        return and(true, groupConsumer);
    }

    public S or(UnaryOperator<FilterGroup<T, S>> groupConsumer) {
        return or(true, groupConsumer);
    }

    public S and(boolean enable, UnaryOperator<FilterGroup<T, S>> groupConsumer) {
        if (enable) {
            FilterGroup<T, S> filterGroup = new FilterGroup<>(this.entityClass);
            filterGroup.setCondition(FilterCondition.AND);
            this.addFilters(groupConsumer.apply(filterGroup));
        }
        return (S) this;
    }

    public S or(boolean enable, UnaryOperator<FilterGroup<T, S>> groupConsumer) {
        if (enable) {
            FilterGroup<T, S> filterGroup = new FilterGroup<>(this.entityClass);
            filterGroup.setCondition(FilterCondition.OR);
            this.addFilters(groupConsumer.apply(filterGroup));
        }
        return (S) this;
    }

    private <R extends Comparable> S filterInternal(
            FilterCondition condition,
            GetPropertyFunction<T, R> getPropertyFunc,
            FilterOperator operator, Object filterValue, boolean enable) {
        if (enable) {
            EnhancedFilterDescriptor filterDescriptor = new EnhancedFilterDescriptor();
            String propertyName = CommonsHelper.getPropertyName(getPropertyFunc);
            filterDescriptor.setCondition(condition);
            filterDescriptor.setPropertyName(propertyName);
            filterDescriptor.setOperator(operator);
            filterDescriptor.setValue(filterValue);
            PropertyInfo propertyInfo = entityCache.getPropertyInfo(entityClass, propertyName);
            filterDescriptor.setPropertyInfo(propertyInfo);
            this.addFilters(filterDescriptor);
        }
        return (S) this;
    }
}
