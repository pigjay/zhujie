package com.piggame.vo.system;

import java.util.List;

import com.piggame.model.system.SysPermission;
import com.piggame.model.system.SysRole;

public class SysRoleVo extends SysRole{

	private List<SysPermission> permissions;

	public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}
	
}
