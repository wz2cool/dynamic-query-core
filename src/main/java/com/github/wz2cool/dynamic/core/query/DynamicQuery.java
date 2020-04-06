package com.github.wz2cool.dynamic.core.query;

import com.github.wz2cool.dynamic.core.cache.EntityCache;
import com.github.wz2cool.dynamic.core.helper.CommonsHelper;
import com.github.wz2cool.dynamic.core.lambda.GetPropertyFunction;
import com.github.wz2cool.dynamic.core.model.FilterCondition;
import com.github.wz2cool.dynamic.core.model.FilterOperator;
import com.github.wz2cool.dynamic.core.model.ISortDescriptor;
import com.github.wz2cool.dynamic.core.model.PropertyInfo;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public class DynamicQuery<T> extends BaseFilterGroup<T, DynamicQuery<T>> {
    private final EntityCache entityCache = EntityCache.getInstance();

    private ISortDescriptor[] sorts = new ISortDescriptor[]{};
    private boolean distinct = false;
    private Class<T> entityClass;

    public ISortDescriptor[] getSorts() {
        return sorts;
    }

    public void setSorts(ISortDescriptor[] sorts) {
        this.sorts = sorts;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public DynamicQuery(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public static <T> DynamicQuery<T> createQuery(Class<T> clazz) {
        return new DynamicQuery<>(clazz);
    }

    @Override
    protected <R extends Comparable> DynamicQuery<T> filterInternal(
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
        return this;
    }
}
