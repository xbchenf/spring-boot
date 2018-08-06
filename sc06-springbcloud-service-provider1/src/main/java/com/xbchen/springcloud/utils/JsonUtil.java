package com.xbchen.springcloud.utils;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

public class JsonUtil {
    
    private static ObjectMapper objectMapper = null;
    static {
        if (objectMapper == null) {
            synchronized (JsonUtil.class) {
                if (objectMapper == null) {
                    objectMapper = new ObjectMapper();
                    objectMapper.setSerializationInclusion(Inclusion.NON_NULL);// 返回的时候去掉空属性
                    objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);// 去掉未知属性
                }
            }
        }
    }
    
    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
    
    public static String obj2String(Object obj) {
        String s = "";
        try {
            s = getObjectMapper().writeValueAsString(obj);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    
    private JsonUtil() {
    }
}
