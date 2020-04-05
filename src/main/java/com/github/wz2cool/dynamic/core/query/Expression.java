package com.github.wz2cool.dynamic.core.query;

import com.github.wz2cool.dynamic.core.direction.Ascending;
import com.github.wz2cool.dynamic.core.direction.Descending;
import com.github.wz2cool.dynamic.core.operator.*;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public final class Expression {

    private Expression() {
    }

    public static <R> LessThan<R> lessThan(R value) {
        return new LessThan<>(value);
    }

    public static <R> LessThanOrEqual<R> lessThanOrEqual(R value) {
        return new LessThanOrEqual<>(value);
    }

    public static <R> Equal<R> isEqual(R value) {
        return new Equal<>(value);
    }

    public static <R> NotEqual<R> notEqual(R value) {
        return new NotEqual<>(value);
    }

    public static <R> GreaterThanOrEqual<R> greaterThanOrEqual(R value) {
        return new GreaterThanOrEqual<>(value);
    }

    public static <R> GreaterThan<R> greaterThan(R value) {
        return new GreaterThan<>(value);
    }

    public static <R> StartWith<R> startWith(R value) {
        return new StartWith<>(value);
    }

    public static <R> EndWith<R> endWith(R value) {
        return new EndWith<>(value);
    }

    public static <R> Contains<R> contains(R value) {
        return new Contains<>(value);
    }

    @SafeVarargs
    public static <R> In<R> in(R... values) {
        return new In<>(values);
    }

    @SafeVarargs
    public static <R> NotIn<R> notIn(R... values) {
        return new NotIn<>(values);
    }

    public static <R> Between<R> between(R value1, R value2) {
        return new Between<>(value1, value2);
    }

    /// endregion

    /// region sort direction

    private static final Ascending ASC = new Ascending();
    private static final Descending DESC = new Descending();

    public static Ascending asc() {
        return ASC;
    }

    public static Descending desc() {
        return DESC;
    }

    /// endregion
}
