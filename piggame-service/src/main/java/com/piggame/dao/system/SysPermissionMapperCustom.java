package com.piggame.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.piggame.model.system.SysPermission;

@Mapper
public interface SysPermissionMapperCustom {
	@Select("SELECT * FROM sys_permission  sp INNER JOIN sys_role_permission srp ON srp.permission_id = sp.id WHERE srp.role_id = #{roleId}")
	List<SysPermission> findByRoleId(Long roleId);
}
