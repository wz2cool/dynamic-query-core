package com.github.wz2cool.dynamic.query.core;

/**
 * the descriptor of filter
 *
 * @author Frank
 **/
public class FilterDescriptor implements IFilterDescriptor {

    private FilterCondition condition = FilterCondition.AND;
    private FilterOperator operator = FilterOperator.EQUAL;
    private String propertyName;
    private Object value;

    /**
     * get condition
     *
     * @return condition
     */
    public FilterCondition getCondition() {
        return condition;
    }

    /**
     * set condition
     *
     * @param condition the value need to set
     */
    public void setCondition(FilterCondition condition) {
        this.condition = condition;
    }

    /**
     * get operator
     *
     * @return operator
     */
    public FilterOperator getOperator() {
        return operator;
    }

    /**
     * set operator
     *
     * @param operator the value need to set
     */
    public void setOperator(FilterOperator operator) {
        this.operator = operator;
    }

    /**
     * get name of property
     *
     * @return name of property.
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * set name of property
     *
     * @param propertyName name of property
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * get value
     *
     * @return the value to which the field is compared
     */
    public Object getValue() {
        return value;
    }

    /**
     * set value
     *
     * @param value the value need to set
     */
    public void setValue(Object value) {
        this.value = value;
    }
}
