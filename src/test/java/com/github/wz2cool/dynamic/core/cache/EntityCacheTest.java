package com.github.wz2cool.dynamic.core.cache;

import com.github.wz2cool.dynamic.core.model.ExampleModel;
import com.github.wz2cool.dynamic.core.model.PropertyInfo;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public class EntityCacheTest {

    @Test
    public void testGetPropertyInfoMap() throws Throwable {
        Map<String, PropertyInfo> propertyInfoMap = EntityCache.getInstance().getPropertyInfoMap(ExampleModel.class);
        ExampleModel exampleModel = new ExampleModel();
        exampleModel.setP1(BigDecimal.TEN);

        Object result = propertyInfoMap.get("p1").getMethodHandle().invoke(exampleModel);
        System.out.println(result);
    }
}
