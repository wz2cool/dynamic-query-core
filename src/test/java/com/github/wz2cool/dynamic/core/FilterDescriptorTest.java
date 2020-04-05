package com.github.wz2cool.dynamic.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public class FilterDescriptorTest {

    @Test
    public void testConstructorForDefaultValue() {
        FilterDescriptor filter = new FilterDescriptor();
        Assert.assertEquals(FilterCondition.AND, filter.getCondition());
        Assert.assertEquals(FilterOperator.EQUAL, filter.getOperator());
    }

    @Test
    public void testConstructor1() {
        FilterDescriptor filter = new FilterDescriptor();
        filter.setCondition(FilterCondition.OR);
        filter.setOperator(FilterOperator.CONTAINS);
        filter.setPropertyName("name");
        filter.setValue("frank");

        Assert.assertEquals(FilterCondition.OR, filter.getCondition());
        Assert.assertEquals(FilterOperator.CONTAINS, filter.getOperator());
        Assert.assertEquals("name", filter.getPropertyName());
        Assert.assertEquals("frank", filter.getValue());
    }

    @Test
    public void testConstructor2() {
        FilterDescriptor filter = new FilterDescriptor("age", FilterOperator.GREATER_THAN, 20);
        Assert.assertEquals(FilterCondition.AND, filter.getCondition());
        Assert.assertEquals(FilterOperator.GREATER_THAN, filter.getOperator());
        Assert.assertEquals("age", filter.getPropertyName());
        Assert.assertEquals(20, filter.getValue());
    }

    @Test
    public void testConstructor3() {
        FilterDescriptor filter = new FilterDescriptor(FilterCondition.OR, "age", FilterOperator.GREATER_THAN, 20);
        Assert.assertEquals(FilterCondition.OR, filter.getCondition());
        Assert.assertEquals(FilterOperator.GREATER_THAN, filter.getOperator());
        Assert.assertEquals("age", filter.getPropertyName());
        Assert.assertEquals(20, filter.getValue());
    }
}
