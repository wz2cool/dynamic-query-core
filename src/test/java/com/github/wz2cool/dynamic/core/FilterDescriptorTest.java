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
        FilterDescriptor filterDescriptor = new FilterDescriptor();
        Assert.assertEquals(FilterCondition.AND, filterDescriptor.getCondition());
        Assert.assertEquals(FilterOperator.EQUAL, filterDescriptor.getOperator());
    }
}
