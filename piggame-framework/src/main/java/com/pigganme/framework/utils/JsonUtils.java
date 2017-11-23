package com.pigganme.framework.utils;

import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;

/**
 * Json对象转换工具类
 * @Author:zhujie
 * @Date: Create in 18:23 2017/11/23
 **/
public class JsonUtils {

    /**
     * 将object对象转换成json字符串
     * @param object
     * @return
     */
    public static String toJsonString(Object object){
        JSONObject jsonObject  = new JSONObject(object);
        return jsonObject.toString();
    }
}
