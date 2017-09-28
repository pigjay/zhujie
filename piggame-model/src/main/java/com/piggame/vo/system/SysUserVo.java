package com.piggame.vo.system;

import java.util.List;

import com.piggame.model.system.SysRole;
import com.piggame.model.system.SysUser;

public class SysUserVo extends SysUser{

	private List<SysRoleVo> roles;

	public List<SysRoleVo> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRoleVo> roles) {
		this.roles = roles;
	}
	
	
}
