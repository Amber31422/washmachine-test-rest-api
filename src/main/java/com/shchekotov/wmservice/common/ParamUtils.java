package com.shchekotov.wmservice.common;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * ParamUtils.
 *
 * @author Max
 */
public final class ParamUtils {

    public static Map<String, Object> result(boolean error, Map<String, Object> values, Map<String, Object> errors) {
        Map<String, Object> result = new HashMap<>();
        result.putAll(values);
        result.put("error", error);
        result.put("errors", errors.isEmpty() ? null : errors);
        return result;
    }

    public static Map<String, Object> result(boolean error, Map<String, Object> errors) {
        return result(error, Collections.<String, Object>emptyMap(), errors);
    }

    public static Map<String, Object> result(boolean error) {
        return result(error, Collections.<String, Object>emptyMap(), Collections.<String, Object>emptyMap());
    }

    private ParamUtils() {
    }
}
