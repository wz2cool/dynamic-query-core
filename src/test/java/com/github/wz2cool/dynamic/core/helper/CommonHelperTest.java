package com.github.wz2cool.dynamic.core.helper;

import com.github.wz2cool.dynamic.core.model.ExampleModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public class CommonHelperTest {

    @Test
    public void testGetPropertyName() {
        String propertyName = CommonHelper.getPropertyName(ExampleModel::getP1);
        assertEquals("p1", propertyName);
    }

    @Test
    public void testGetPropertyNameInternal() {
        String booleanPropertyName = CommonHelper.getPropertyName("isBoolean");
        String getPropertyName = CommonHelper.getPropertyName("getName");
        String propertyName = CommonHelper.getPropertyName("name");
        assertEquals("boolean", booleanPropertyName);
        assertEquals("name", getPropertyName);
        assertEquals("name", propertyName);
    }
}
