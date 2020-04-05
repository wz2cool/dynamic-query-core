package com.github.wz2cool.dynamic.core.helper;

import com.github.wz2cool.dynamic.core.exception.InternalRuntimeException;
import com.github.wz2cool.dynamic.core.lambda.GetPropertyFunction;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public final class CommonHelper {

    private CommonHelper() {
    }

    public static <T, R extends Comparable> String getPropertyName(GetPropertyFunction<T, R> fn) {
        try {
            Method method = fn.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(true);
            SerializedLambda serializedLambda = (SerializedLambda) method.invoke(fn);
            String methodName = serializedLambda.getImplMethodName();
            return getPropertyName(methodName);
        } catch (ReflectiveOperationException e) {
            throw new InternalRuntimeException(e);
        }
    }

    static String getPropertyName(String methodName) {
        String getString = "get";
        String isString = "is";
        int len;
        if (methodName.startsWith(getString)) {
            len = getString.length();
        } else if (methodName.startsWith(isString)) {
            len = isString.length();
        } else {
            len = 0;
        }
        return java.beans.Introspector.decapitalize(methodName.substring(len));
    }
}
