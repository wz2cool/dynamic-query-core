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
}
