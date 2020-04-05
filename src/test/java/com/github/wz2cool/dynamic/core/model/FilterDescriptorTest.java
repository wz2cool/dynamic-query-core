package com.github.wz2cool.dynamic.core.model;


import com.github.wz2cool.dynamic.core.model.FilterCondition;
import com.github.wz2cool.dynamic.core.model.FilterDescriptor;
import com.github.wz2cool.dynamic.core.model.FilterOperator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author Frank
 * @date 2020/04/05
 **/
public class FilterDescriptorTest {

    @Test
    public void testConstructorForDefaultValue() {
        FilterDescriptor filter = new FilterDescriptor();
        assertEquals(FilterCondition.AND, filter.getCondition());
        assertEquals(FilterOperator.EQUAL, filter.getOperator());
    }

    @Test
    public void testConstructor1() {
        FilterDescriptor filter = new FilterDescriptor();
        filter.setCondition(FilterCondition.OR);
        filter.setOperator(FilterOperator.CONTAINS);
        filter.setPropertyName("name");
        filter.setValue("frank");

        assertEquals(FilterCondition.OR, filter.getCondition());
        assertEquals(FilterOperator.CONTAINS, filter.getOperator());
        assertEquals("name", filter.getPropertyName());
        assertEquals("frank", filter.getValue());
    }

    @Test
    public void testConstructor2() {
        FilterDescriptor filter = new FilterDescriptor("age", FilterOperator.GREATER_THAN, 20);
        assertEquals(FilterCondition.AND, filter.getCondition());
        assertEquals(FilterOperator.GREATER_THAN, filter.getOperator());
        assertEquals("age", filter.getPropertyName());
        assertEquals(20, filter.getValue());
    }

    @Test
    public void testConstructor3() {
        FilterDescriptor filter = new FilterDescriptor(FilterCondition.OR, "age", FilterOperator.GREATER_THAN, 20);
        assertEquals(FilterCondition.OR, filter.getCondition());
        assertEquals(FilterOperator.GREATER_THAN, filter.getOperator());
        assertEquals("age", filter.getPropertyName());
        assertEquals(20, filter.getValue());
    }
}
