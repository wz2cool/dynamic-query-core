package com.github.wz2cool.dynamic.memory;

import com.github.wz2cool.dynamic.core.cache.EntityCache;
import com.github.wz2cool.dynamic.core.exception.InternalRuntimeException;
import com.github.wz2cool.dynamic.core.helper.PredicateHelper;
import com.github.wz2cool.dynamic.core.model.FilterCondition;
import com.github.wz2cool.dynamic.core.model.FilterDescriptor;
import com.github.wz2cool.dynamic.core.model.FilterGroupDescriptor;
import com.github.wz2cool.dynamic.core.model.IFilterDescriptor;
import com.github.wz2cool.dynamic.core.query.DynamicQuery;
import com.github.wz2cool.dynamic.core.query.EnhancedFilterDescriptor;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public final class MemoryFilter {

    private MemoryFilter() {

    }

    private static final EntityCache ENTITY_CACHE = EntityCache.getInstance();

    public static <T> Predicate<T> getPredicate(DynamicQuery<T> query) {
        return getPredicate(query.getEntityClass(), query.getFilters());
    }

    private static <T> Predicate<T> getPredicate(Class<T> clazz, IFilterDescriptor[] filters) {
        Predicate<T> predicate = (obj) -> true;
        for (IFilterDescriptor filter : filters) {
            if (filter instanceof FilterGroupDescriptor) {
                if (filter.getCondition() == FilterCondition.OR) {
                    predicate = predicate.or(getPredicate(clazz, (FilterGroupDescriptor) filter));
                } else {
                    predicate = predicate.and(getPredicate(clazz, (FilterGroupDescriptor) filter));
                }
            } else if (filter instanceof FilterDescriptor) {
                if (filter.getCondition() == FilterCondition.OR) {
                    predicate = predicate.or(getPredicate(clazz, (FilterDescriptor) filter));
                } else {
                    predicate = predicate.and(getPredicate(clazz, (FilterDescriptor) filter));
                }
            }
        }
        return predicate;
    }

    private static <T> Predicate<T> getPredicate(Class<T> clazz, FilterGroupDescriptor filterGroupDescriptor) {
        return getPredicate(clazz, filterGroupDescriptor.getFilters());
    }

    private static <T> Predicate<T> getPredicate(Class<T> clazz, FilterDescriptor filterDescriptor) {
        return (T obj) -> {
            Function method;
            if (filterDescriptor instanceof EnhancedFilterDescriptor) {
                EnhancedFilterDescriptor enhancedFilterDescriptor = (EnhancedFilterDescriptor) filterDescriptor;
                if (Objects.nonNull(enhancedFilterDescriptor.getPropertyInfo())
                        && Objects.nonNull(enhancedFilterDescriptor.getPropertyInfo().getPropertyFunc())) {
                    method = ((EnhancedFilterDescriptor) filterDescriptor).getPropertyInfo().getPropertyFunc();
                } else {
                    method = ENTITY_CACHE.getPropertyInfo(clazz, filterDescriptor.getPropertyName()).getPropertyFunc();
                }
            } else {
                method = ENTITY_CACHE.getPropertyInfo(clazz, filterDescriptor.getPropertyName()).getPropertyFunc();
            }
            try {
                Object propertyValue = method.apply(obj);
                return PredicateHelper.test(propertyValue, filterDescriptor.getOperator(), filterDescriptor.getValue());
            } catch (Exception e) {
                throw new InternalRuntimeException(e);
            }
        };
    }
}
