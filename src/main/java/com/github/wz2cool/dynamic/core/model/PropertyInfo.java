package com.github.wz2cool.dynamic.core.model;

import java.util.function.Function;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public class PropertyInfo {
    /**
     * full path of field
     * eg: com.github.wz2cool.dynamic.fooClass.fooField
     */
    private String propertyName;
    private Class propertyType;
    private Function propertyFunc;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Class getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Class propertyType) {
        this.propertyType = propertyType;
    }

    public Function getPropertyFunc() {
        return propertyFunc;
    }

    public void setPropertyFunc(Function propertyFunc) {
        this.propertyFunc = propertyFunc;
    }
}
