package com.github.wz2cool.dynamic.query.core;

/**
 * The enum Filter operator.
 *
 * @author Frank
 */
public enum FilterOperator {
    /**
     * Less than and operator.
     */
    LESS_THAN,
    /**
     * Less than or equal and operator.
     */
    LESS_THAN_OR_EQUAL,
    /**
     * Equal and operator.
     */
    EQUAL,
    /**
     * Not equal and operator.
     */
    NOT_EQUAL,
    /**
     * Greater than or equal and operator.
     */
    GREATER_THAN_OR_EQUAL,
    /**
     * Greater than and operator.
     */
    GREATER_THAN,
    /**
     * Start with and operator.
     */
    START_WITH,
    /**
     * End with and operator.
     */
    END_WITH,
    /**
     * Contains and operator.
     */
    CONTAINS,
    /**
     * In and operator.
     */
    IN,
    /**
     * Not in and operator.
     */
    NOT_IN,
    /**
     * Between and operator.
     */
    BETWEEN
}
