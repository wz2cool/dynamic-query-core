package com.github.wz2cool.dynamic.memory;

import com.github.wz2cool.dynamic.core.cache.EntityCache;
import com.github.wz2cool.dynamic.core.exception.InternalRuntimeException;
import com.github.wz2cool.dynamic.core.helper.PredicateHelper;
import com.github.wz2cool.dynamic.core.model.FilterDescriptor;
import com.github.wz2cool.dynamic.core.query.DynamicQuery;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Predicate;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public class MemoryFilter {

    private final static EntityCache ENTITY_CACHE = EntityCache.getInstance();

    public static <T> Predicate<T> getPredicate(DynamicQuery<T> query) {
        return getPredicate(query.getEntityClass(), (FilterDescriptor) query.getFilters()[0]);
    }

    private static <T> Predicate<T> getPredicate(Class<T> clazz, FilterDescriptor filterDescriptor) {
        return (T obj) -> {
            Method method = ENTITY_CACHE.getPropertyInfo(clazz, filterDescriptor.getPropertyName()).getPropertyMethod();
            try {
                Object propertyValue = method.invoke(obj);
                return PredicateHelper.test(propertyValue, filterDescriptor.getOperator(), filterDescriptor.getValue());
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new InternalRuntimeException(e);
            }
        };
    }
}
