package com.pigganme.framework.filter;

import com.pigganme.framework.result.Result;
import com.pigganme.framework.utils.JsonUtils;
import com.pigganme.framework.utils.WebUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * shiro登录认证器
 * @Author:zhujie
 * @Date: Create in 10:50 2017/11/24
 **/
public class ShiroLoginFilter extends FormAuthenticationFilter{

    private  static  final Logger  log = LoggerFactory.getLogger(ShiroLoginFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                return executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                //allow them to see the login page ;)
                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the " +
                        "Authentication url [" + getLoginUrl() + "]");
            }

            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (!"XMLHttpRequest".equalsIgnoreCase(httpServletRequest
                .getHeader("X-Requested-With"))) {// 不是ajax请求
            issueSuccessRedirect(request, response);
        } else {
            WebUtils.sendJson( httpServletResponse,JsonUtils.toJsonString(new Result(201,"登录成功")));
        }
        return false;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (!"XMLHttpRequest".equalsIgnoreCase(httpServletRequest
                .getHeader("X-Requested-With"))) {// 不是ajax请求
            setFailureAttribute(request, e);
            return true;
        }
            Result result = new Result();
            String message = e.getClass().getSimpleName();
            if ("IncorrectCredentialsException".equals(message)) {
                result.setCode(410);
                result.setMessage("密码错误");
            } else if ("UnknownAccountException".equals(message)) {
                result.setCode(411);
                result.setMessage("账号不存在");
            } else if ("LockedAccountException".equals(message)) {
                result.setCode(412);
                result.setMessage("账号被锁定");
            } else {
                result.setCode(413);
                result.setMessage("未知错误");
            }
        try {
            WebUtils.sendJson(httpServletResponse,JsonUtils.toJsonString(result));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }
}
