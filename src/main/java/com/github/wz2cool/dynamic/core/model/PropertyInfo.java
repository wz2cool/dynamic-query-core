package com.github.wz2cool.dynamic.core.model;

import java.lang.reflect.Method;

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
    private Method propertyMethod;

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

    public Method getPropertyMethod() {
        return propertyMethod;
    }

    public void setPropertyMethod(Method propertyMethod) {
        this.propertyMethod = propertyMethod;
    }
}
