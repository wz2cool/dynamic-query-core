package com.github.wz2cool.dynamic.query.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Frank
 **/
public class FilterDescriptorTest {

    @Test
    public void testDefaultValue() {
        FilterDescriptor filterDescriptor = new FilterDescriptor();
        assertEquals(FilterCondition.AND, filterDescriptor.getCondition());
        assertEquals(FilterOperator.EQUAL, filterDescriptor.getOperator());
    }

    @Test
    public void testGetSet() {
        FilterDescriptor filterDescriptor = new FilterDescriptor();
        filterDescriptor.setCondition(FilterCondition.OR);
        filterDescriptor.setOperator(FilterOperator.NOT_EQUAL);
        filterDescriptor.setPropertyName("name");
        filterDescriptor.setValue("jack");

        assertEquals(FilterCondition.OR, filterDescriptor.getCondition());
        assertEquals(FilterOperator.NOT_EQUAL, filterDescriptor.getOperator());
        assertEquals("name", filterDescriptor.getPropertyName());
        assertEquals("jack", filterDescriptor.getValue());
    }
}
