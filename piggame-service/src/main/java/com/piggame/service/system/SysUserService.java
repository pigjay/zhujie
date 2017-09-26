package com.piggame.service.system;

import java.util.List;

import com.piggame.model.system.SysUser;

public interface SysUserService{
  
	/**
	 * 查询所有用户
	 * @return
	 */
	List<SysUser> findAll();
	
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	SysUser findOne(long id);
	
	/**
	 * 插入用户
	 * @param sysUser
	 * @return
	 */
	SysUser insert(SysUser sysUser);
	
	/**
	 * 更新用户
	 * @param sysUser
	 * @return
	 */
	SysUser update(SysUser sysUser);
	
	/**
	 * 通过userName查找用户信息
	 * @param userName
	 * @return
	 */
	SysUser findByUsername(String userName);
	
}
