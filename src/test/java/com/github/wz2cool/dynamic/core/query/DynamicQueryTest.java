package com.github.wz2cool.dynamic.core.query;

import com.github.wz2cool.dynamic.core.model.ExampleModel;
import com.github.wz2cool.dynamic.core.model.FilterCondition;
import com.github.wz2cool.dynamic.core.model.FilterDescriptor;
import com.github.wz2cool.dynamic.core.model.FilterOperator;
import org.junit.Test;

import java.math.BigDecimal;


import static com.github.wz2cool.dynamic.core.query.Expression.greaterThan;
import static org.junit.Assert.assertEquals;


/**
 * @author Frank
 * @date 2020/04/05
 **/
public class DynamicQueryTest {

    @Test
    public void testConstructorDefaultValue() {
        DynamicQuery<ExampleModel> filterGroup = new DynamicQuery<>();
        assertEquals(FilterCondition.AND, filterGroup.getCondition());
    }

    @Test
    public void testAddBigDecimalFilter() {
        DynamicQuery<ExampleModel> filterGroup = new DynamicQuery<>();
        filterGroup.and(ExampleModel::getP1, greaterThan(BigDecimal.ONE));
        assertEquals(1, filterGroup.getFilters().length);
        FilterDescriptor filterDescriptor = (FilterDescriptor) filterGroup.getFilters()[0];
        assertEquals("p1", filterDescriptor.getPropertyName());
        assertEquals(FilterOperator.GREATER_THAN, filterDescriptor.getOperator());
        assertEquals(BigDecimal.ONE, filterDescriptor.getValue());
    }
}
