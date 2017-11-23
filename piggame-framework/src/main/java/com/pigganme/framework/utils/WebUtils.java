package com.pigganme.framework.utils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Web工具类
 * @Author:zhujie
 * @Date: Create in 18:13 2017/11/23
 **/
public class WebUtils {

    /**
     * 判断请求是否是Ajax请求
     * @param request
     * @return
     */
    public static  boolean isAjax(HttpServletRequest request){
        String requestType = request.getHeader("X-Requested-With");
        if(requestType != null && "XMLHttpRequest".equals(requestType)){
            return true;
        }
        return false;
    }

    /**
     * 向客户端返回json数据
     * @param json
     */
    public  static  void sendJson(HttpServletResponse response,String json) throws IOException{

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.append(json);
        out.close();
    }

    public static void issueRedirect(ServletRequest request, ServletResponse response, String unauthorizedUrl) {
        //TODO
    }

    public static HttpServletResponse toHttp(ServletResponse response) {
        //TODO
    }
}
