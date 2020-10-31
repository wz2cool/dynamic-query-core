package com.github.wz2cool.dynamic.core.cache;

import com.github.wz2cool.dynamic.core.exception.InternalRuntimeException;
import com.github.wz2cool.dynamic.core.helper.CommonsHelper;
import com.github.wz2cool.dynamic.core.model.PropertyInfo;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Entity cache
 * 实体缓存
 *
 * @author Frank
 * @date 2020/04/05
 **/
@SuppressWarnings({"java:S3011", "java:S374", "java:S3740"})
public final class EntityCache {

    private static final EntityCache INSTANCE = new EntityCache();

    private EntityCache() {
    }

    public static EntityCache getInstance() {
        return INSTANCE;
    }

    private static final Map<Class, Map<String, PropertyInfo>> PROPERTY_INFO_CACHE = new ConcurrentHashMap<>();
    private static final String ENTITY_CLASS = "entityClass";

    /**
     * get property info of entity class
     * 获取目标对象的属性（C# 里的属性为同时拥有get/set 方法）
     *
     * @param entityClass  entity class 实体类
     * @param propertyName the name of property 属性名
     * @return propery info of entity class
     */
    public PropertyInfo getPropertyInfo(Class entityClass, String propertyName) {
        return getPropertyInfoMap(entityClass).get(propertyName);
    }

    private Map<String, PropertyInfo> getPropertyInfoMap(Class entityClass) {
        Map<String, PropertyInfo> map = PROPERTY_INFO_CACHE.get(entityClass);
        if (Objects.nonNull(map)) {
            return map;
        }
        map = getPropertyInfoMapInternal(entityClass);
        PROPERTY_INFO_CACHE.put(entityClass, map);
        return map;
    }

    private Map<String, PropertyInfo> getPropertyInfoMapInternal(Class entityClass) {
        try {
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

                MethodHandles.Lookup lookup = MethodHandles.lookup();
                CallSite site = LambdaMetafactory.metafactory(lookup,
                        "apply",
                        MethodType.methodType(Function.class),
                        MethodType.methodType(Object.class, Object.class),
                        lookup.findVirtual(entityClass, methodName, MethodType.methodType(getMethod.getReturnType())),
                        MethodType.methodType(getMethod.getReturnType(), entityClass));
                Function getterFunction = (Function) site.getTarget().invokeExact();
                PropertyInfo propertyInfo = new PropertyInfo();
                propertyInfo.setPropertyName(propertyName);
                propertyInfo.setPropertyFunc(getterFunction);
                result.put(propertyName, propertyInfo);
            }
            return result;
        } catch (Throwable ex) {
            throw new InternalRuntimeException(ex);
        }
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



