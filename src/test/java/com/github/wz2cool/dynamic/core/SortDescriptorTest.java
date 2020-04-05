package com.github.wz2cool.dynamic.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public class SortDescriptorTest {

    @Test
    public void testConstructorForDefaultValue() {
        SortDescriptor sort = new SortDescriptor();
        assertEquals(SortDirection.ASC, sort.getDirection());
    }

    @Test
    public void testConstructor1() {
        SortDescriptor sort = new SortDescriptor();
        sort.setPropertyName("name");
        sort.setDirection(SortDirection.DESC);

        assertEquals("name", sort.getPropertyName());
        assertEquals(SortDirection.DESC, sort.getDirection());
    }

    @Test
    public void testConstructor2() {
        SortDescriptor sort = new SortDescriptor("name", SortDirection.DESC);
        assertEquals("name", sort.getPropertyName());
        assertEquals(SortDirection.DESC, sort.getDirection());
    }
}
