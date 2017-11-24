package com.piggame.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.piggame.model.system.SysUser;
import com.piggame.service.system.SysUserService;
import com.piggame.vo.system.SysUserVo;

@Controller
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping(value="/user/list")
	public List<SysUser> findAll() {
		return sysUserService.findAll();
	}
	
	@RequestMapping(value="/login")
	public void login(HttpServletRequest request,HttpServletResponse response,Map<String, Object> map) throws IOException {
		System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");
		System.out.println("exception = "+exception);
		String msg = "";
		if(exception != null) {
			if(UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
			}else if(IncorrectCredentialsException.class.getName().equals(exception)){
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
			}else if("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
			}else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
			}
		}
		map.put("msg", msg);
		// 此方法不处理登录成功,由shiro进行处理
		response.sendRedirect("/view/index.html");
	}
	
	@RequestMapping("/user/info")
	public @ResponseBody SysUserVo userInfo(HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		SysUserVo sysUser = (SysUserVo) subject.getPrincipal();
		return sysUser;
	}
}
