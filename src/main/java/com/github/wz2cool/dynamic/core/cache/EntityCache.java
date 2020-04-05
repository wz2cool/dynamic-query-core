package com.github.wz2cool.dynamic.core.cache;

import com.github.wz2cool.dynamic.core.helper.CommonsHelper;
import com.github.wz2cool.dynamic.core.model.PropertyInfo;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public final class EntityCache {

    private static final EntityCache INSTANCE = new EntityCache();

    private EntityCache() {
    }

    public static EntityCache getInstance() {
        return INSTANCE;
    }

    private static final Map<Class, Map<String, PropertyInfo>> PROPERTY_INFO_CACHE = new ConcurrentHashMap<>();
    private static final String ENTITY_CLASS = "entityClass";

    public PropertyInfo getPropertyInfo(Class entityClass, String propertyName) {
        return getPropertyInfoMap(entityClass).get(propertyName);
    }

    public Map<String, PropertyInfo> getPropertyInfoMap(Class entityClass) {
        Map<String, PropertyInfo> map = PROPERTY_INFO_CACHE.get(entityClass);
        if (Objects.nonNull(map)) {
            return map;
        }
        map = getPropertyInfoMapInternal(entityClass);
        PROPERTY_INFO_CACHE.put(entityClass, map);
        return map;
    }

    private Map<String, PropertyInfo> getPropertyInfoMapInternal(Class entityClass) {
        if (Objects.isNull(entityClass)) {
            throw new NullPointerException(ENTITY_CLASS);
        }
        Map<String, PropertyInfo> result = new HashMap<>();
        // get all public methods
        Method[] publicMethods = entityClass.getMethods();
        List<Method> getMethodList = getPropertyGetMethodList(publicMethods);
        for (Method getMethod : getMethodList) {
            getMethod.setAccessible(true);
            String methodName = getMethod.getName();
            String propertyName = CommonsHelper.getPropertyName(methodName);
            PropertyInfo propertyInfo = new PropertyInfo();
            propertyInfo.setPropertyName(propertyName);
            propertyInfo.setPropertyMethod(getMethod);
            result.put(propertyName, propertyInfo);
        }
        return result;
    }

    private List<Method> getPropertyGetMethodList(Method[] methods) {
        // only get method which both have get/set method
        List<Method> result = new ArrayList<>();
        Map<String, Method> candidateMap = new HashMap<>();
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get") || methodName.startsWith("is")) {
                String propertyName = CommonsHelper.getPropertyName(methodName);
                if (candidateMap.containsKey(propertyName)) {
                    result.add(method);
                } else {
                    candidateMap.put(propertyName, method);
                }
            } else if (methodName.startsWith("set")) {
                String propertyName = CommonsHelper.getPropertyName(methodName);
                if (candidateMap.containsKey(propertyName)) {
                    result.add(candidateMap.get(propertyName));
                } else {
                    candidateMap.put(propertyName, method);
                }
            }
        }
        return result;
    }
}



