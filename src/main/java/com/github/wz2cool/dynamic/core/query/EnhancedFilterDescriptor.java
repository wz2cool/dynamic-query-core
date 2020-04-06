package com.github.wz2cool.dynamic.core.query;

import com.github.wz2cool.dynamic.core.model.FilterDescriptor;

import java.util.function.Function;

/**
 * @author Frank
 */
public class EnhancedFilterDescriptor extends FilterDescriptor {
    private Function propertyFunc;

    public Function getPropertyFunc() {
        return propertyFunc;
    }

    public void setPropertyFunc(Function propertyFunc) {
        this.propertyFunc = propertyFunc;
    }
}
