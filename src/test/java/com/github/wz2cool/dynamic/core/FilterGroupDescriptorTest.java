package com.github.wz2cool.dynamic.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public class FilterGroupDescriptorTest {

    @Test
    public void testConstructorForDefaultValue() {
        FilterGroupDescriptor groupFilter = new FilterGroupDescriptor();
        assertEquals(FilterCondition.AND, groupFilter.getCondition());
        assertEquals(0, groupFilter.getFilters().length);
    }

    @Test
    public void testConstructor1() {
        FilterGroupDescriptor groupFilter = new FilterGroupDescriptor();
        groupFilter.setCondition(FilterCondition.OR);
        assertEquals(FilterCondition.OR, groupFilter.getCondition());
    }

    @Test
    public void testAddFilters() {
        FilterDescriptor filter = new FilterDescriptor("name", FilterOperator.EQUAL, "frank");
        FilterGroupDescriptor groupFilter = new FilterGroupDescriptor();
        groupFilter.addFilters(filter);
        assertEquals(1, groupFilter.getFilters().length);
        assertEquals(filter, groupFilter.getFilters()[0]);

    }
}
