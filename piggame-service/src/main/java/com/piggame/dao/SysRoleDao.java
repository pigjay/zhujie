package com.piggame.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.piggame.model.system.SysRole;

@Mapper
public interface SysRoleDao {
	
	@Select("SELECT * FROM sys_role r INNER JOIN sys_user_role ur ON ur.role_id=r.id WHERE ur.sys_user_id = #{sysUserId}")
	@Results(
			{
				@Result(property="id",column="id"),
				@Result(property="permissions",column = "id",javaType=List.class,
				many=@Many(select="com.wisely.ch7_7.mapper.test1.SysPermissionMapper.findByRoleId"))
			}
			)
	List<SysRole> findBySysUserId(Long sysUserId);
}
