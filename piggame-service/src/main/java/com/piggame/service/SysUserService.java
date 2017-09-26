package com.piggame.service;

import java.util.List;

import com.piggame.model.system.SysUser;

public interface SysUserService{
  
	List<SysUser> findAll();
	
	SysUser findOne(long id);
	
	SysUser insert(SysUser sysUser);
	
	SysUser update(SysUser sysUser);
	
}
