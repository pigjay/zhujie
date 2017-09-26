package com.piggame.service.system;

import java.util.List;

import com.piggame.model.system.SysRole;

public interface SysRoleService {

	List<SysRole> findAll();
	
	SysRole findOne(Long id);
}
