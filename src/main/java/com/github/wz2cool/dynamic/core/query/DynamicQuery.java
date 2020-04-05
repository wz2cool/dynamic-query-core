package com.github.wz2cool.dynamic.core.query;

import com.github.wz2cool.dynamic.core.model.ISortDescriptor;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public class DynamicQuery<T> extends FilterGroup<T, DynamicQuery<T>> {
    private ISortDescriptor[] sorts = new ISortDescriptor[]{};
    private boolean distinct = false;
    private Class<T> clazz;

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

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public DynamicQuery() {

    }

    public DynamicQuery(Class<T> clazz) {
        this.clazz = clazz;
    }

    public static <T> DynamicQuery<T> createQuery(Class<T> clazz) {
        return new DynamicQuery<>(clazz);
    }
}
