package com.github.wz2cool.dynamic.core.query;

import com.github.wz2cool.dynamic.core.model.FilterDescriptor;
import com.github.wz2cool.dynamic.core.model.PropertyInfo;

/**
 * @author Frank
 */
public class EnhancedFilterDescriptor extends FilterDescriptor {
    private PropertyInfo propertyInfo;

    public PropertyInfo getPropertyInfo() {
        return propertyInfo;
    }

    public void setPropertyInfo(PropertyInfo propertyInfo) {
        this.propertyInfo = propertyInfo;
    }
}
