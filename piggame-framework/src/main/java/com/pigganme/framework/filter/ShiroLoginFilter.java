package com.pigganme.framework.filter;

import com.pigganme.framework.result.Result;
import com.pigganme.framework.utils.JsonUtils;
import com.pigganme.framework.utils.WebUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * shiro认证过滤器
 * @Author:zhujie
 * @Date: Create in 15:50 2017/11/23
 **/
public class ShiroLoginFilter extends AuthorizationFilter{

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request,response);
        String[] rolesArray = (String[]) mappedValue;

        if(rolesArray == null || rolesArray.length == 0){
            return true;
        }
        Set<String> roles = CollectionUtils.asSet(rolesArray);
        for (String role : roles) {
            if (subject.hasRole(role)){
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        Subject subject = getSubject(request,response);

        if(subject.getPrincipal() == null){
            if(WebUtils.isAjax(httpServletRequest)){
                WebUtils.sendJson(httpServletResponse, JsonUtils.toJsonString(new Result(533,"未登录")));
            }else{
                saveRequestAndRedirectToLogin(request,response);
            }
        }else{
            if(WebUtils.isAjax(httpServletRequest)){
                WebUtils.sendJson(httpServletResponse,JsonUtils.toJsonString(new Result(534,"没有权限")));
            }else{
                String unauthorizedUrl = getUnauthorizedUrl();
                if(StringUtils.hasText(unauthorizedUrl)){
                    WebUtils.issueRedirect(request, response, unauthorizedUrl);
                }else{
                    WebUtils.toHttp(response).sendError(401);
                }
            }
        }

        return false;
    }
}
