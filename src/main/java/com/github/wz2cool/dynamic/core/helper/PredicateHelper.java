package com.github.wz2cool.dynamic.core.helper;

import com.github.wz2cool.dynamic.core.model.FilterOperator;

import java.util.Date;

/**
 * @author Frank
 * @date 2020/03/15
 **/
public class PredicateHelper {

    public static boolean test(Object propertyValue, FilterOperator operator, Object filterValue) {
        switch (operator) {
            case LESS_THAN:
                return testForLessThan(propertyValue, filterValue);
            case LESS_THAN_OR_EQUAL:
                return testForLessThanOrEqual(propertyValue, filterValue);
            case GREATER_THAN:
                return testForGreaterThan(propertyValue, filterValue);
            case GREATER_THAN_OR_EQUAL:
                return testForGreaterThanOrEqual(propertyValue, filterValue);
            default:
                return true;
        }
    }

    private static boolean testForLessThan(Object propertyValue, Object filterValue) {
        if (!(propertyValue instanceof Comparable)
                || !(filterValue instanceof Comparable)) {
            return false;
        }
        // 时间我们特殊处理
        if (propertyValue instanceof Date && filterValue instanceof Date) {
            return ((Date) propertyValue).getTime() < ((Date) filterValue).getTime();
        }
        // 除了时间我们必须类型一致才能比较
        if (!propertyValue.getClass().equals(filterValue.getClass())) {
            return false;
        }
        return ((Comparable) propertyValue).compareTo(filterValue) < 0;
    }

    private static boolean testForLessThanOrEqual(Object propertyValue, Object filterValue) {
        if (!(propertyValue instanceof Comparable)
                || !(filterValue instanceof Comparable)) {
            return false;
        }
        // 时间我们特殊处理
        if (propertyValue instanceof Date && filterValue instanceof Date) {
            return ((Date) propertyValue).getTime() <= ((Date) filterValue).getTime();
        }
        // 除了时间我们必须类型一致才能比较
        if (!propertyValue.getClass().equals(filterValue.getClass())) {
            return false;
        }
        return ((Comparable) propertyValue).compareTo(filterValue) <= 0;
    }

    private static boolean testForGreaterThanOrEqual(Object propertyValue, Object filterValue) {
        if (!(propertyValue instanceof Comparable)
                || !(filterValue instanceof Comparable)) {
            return false;
        }
        // 时间我们特殊处理
        if (propertyValue instanceof Date && filterValue instanceof Date) {
            return ((Date) propertyValue).getTime() >= ((Date) filterValue).getTime();
        }
        // 除了时间我们必须类型一致才能比较
        if (!propertyValue.getClass().equals(filterValue.getClass())) {
            return false;
        }
        return ((Comparable) propertyValue).compareTo(filterValue) >= 0;
    }

    private static boolean testForGreaterThan(Object propertyValue, Object filterValue) {
        if (!(propertyValue instanceof Comparable)
                || !(filterValue instanceof Comparable)) {
            return false;
        }
        // 时间我们特殊处理
        if (propertyValue instanceof Date && filterValue instanceof Date) {
            return ((Date) propertyValue).getTime() > ((Date) filterValue).getTime();
        }
        // 除了时间我们必须类型一致才能比较
        if (!propertyValue.getClass().equals(filterValue.getClass())) {
            return false;
        }
        return ((Comparable) propertyValue).compareTo(filterValue) > 0;
    }

    private static boolean testForBetween(Object propertyValue, Object filterValue1, Object filterValue2) {
        if (!(propertyValue instanceof Comparable)
                || !(filterValue1 instanceof Comparable)
                || !(filterValue2 instanceof Comparable)) {
            return false;
        }
        // 时间我们特殊处理
        if (propertyValue instanceof Date && filterValue1 instanceof Date && filterValue2 instanceof Date) {
            return ((Date) propertyValue).getTime() >= ((Date) filterValue1).getTime()
                    && ((Date) propertyValue).getTime() <= ((Date) filterValue2).getTime();
        }
        // 除了时间我们必须类型一致才能比较
        if (!propertyValue.getClass().equals(filterValue1.getClass())
                || !propertyValue.getClass().equals(filterValue2.getClass())) {
            return false;
        }
        return ((Comparable) propertyValue).compareTo(filterValue1) >= 0
                && ((Comparable) propertyValue).compareTo(filterValue2) <= 0;
    }
}
