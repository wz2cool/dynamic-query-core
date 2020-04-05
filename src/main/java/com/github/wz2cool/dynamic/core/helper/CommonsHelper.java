package com.github.wz2cool.dynamic.core.helper;

import com.github.wz2cool.dynamic.core.exception.InternalRuntimeException;
import com.github.wz2cool.dynamic.core.lambda.GetPropertyFunction;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

/**
 * @author Frank
 * @date 2020/04/05
 **/
public final class CommonsHelper {

    private CommonsHelper() {
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

    public static String getPropertyName(String getMethodName) {
        String setString = "set";
        String getString = "get";
        String isString = "is";
        int len;
        if (getMethodName.startsWith(getString) || getMethodName.startsWith(setString)) {
            len = getString.length();
        } else if (getMethodName.startsWith(isString)) {
            len = isString.length();
        } else {
            len = 0;
        }
        return java.beans.Introspector.decapitalize(getMethodName.substring(len));
    }
}
