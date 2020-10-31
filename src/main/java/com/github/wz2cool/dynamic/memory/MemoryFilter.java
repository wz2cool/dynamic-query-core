package com.github.wz2cool.dynamic.memory;

import com.github.wz2cool.dynamic.core.cache.EntityCache;
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
        Predicate<T> predicate = null;
        for (IFilterDescriptor filter : filters) {
            if (filter instanceof FilterGroupDescriptor) {
                if (Objects.isNull(predicate)) {
                    predicate = getPredicate(clazz, (FilterGroupDescriptor) filter);
                } else {
                    if (filter.getCondition() == FilterCondition.OR) {
                        predicate = predicate.or(getPredicate(clazz, (FilterGroupDescriptor) filter));
                    } else {
                        predicate = predicate.and(getPredicate(clazz, (FilterGroupDescriptor) filter));
                    }
                }
            } else if (filter instanceof FilterDescriptor) {
                if (Objects.isNull(predicate)) {
                    predicate = getPredicate(clazz, (FilterDescriptor) filter);
                } else {
                    if (filter.getCondition() == FilterCondition.OR) {
                        predicate = predicate.or(getPredicate(clazz, (FilterDescriptor) filter));
                    } else {
                        predicate = predicate.and(getPredicate(clazz, (FilterDescriptor) filter));
                    }
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
            if (Objects.isNull(obj)) {
                return false;
            }
            Function method;
            if (filterDescriptor instanceof EnhancedFilterDescriptor) {
                EnhancedFilterDescriptor enhancedFilterDescriptor = (EnhancedFilterDescriptor) filterDescriptor;
                if (Objects.nonNull(enhancedFilterDescriptor.getPropertyFunc())) {
                    method = ((EnhancedFilterDescriptor) filterDescriptor).getPropertyFunc();
                } else {
                    method = ENTITY_CACHE.getPropertyInfo(clazz, filterDescriptor.getPropertyName()).getPropertyFunc();
                }
            } else {
                method = ENTITY_CACHE.getPropertyInfo(clazz, filterDescriptor.getPropertyName()).getPropertyFunc();
            }
            Object propertyValue = method.apply(obj);
            return PredicateHelper.test(propertyValue, filterDescriptor.getOperator(), filterDescriptor.getValue());
        };
    }
}
