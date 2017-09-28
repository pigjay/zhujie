package com.piggame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piggame.model.system.SysUser;
import com.piggame.service.system.SysUserService;

@RestController
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping(value="/user/list")
	public List<SysUser> findAll() {
		return sysUserService.findAll();
	}
	
	@RequestMapping(value="/login")
	public String login() throws Exception{
	  throw new Exception("登录错误");
	}
}
