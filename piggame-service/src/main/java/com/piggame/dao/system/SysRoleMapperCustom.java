package com.piggame.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.piggame.vo.system.SysRoleVo;




public interface SysRoleMapperCustom {
	@Select("SELECT * FROM sys_role r INNER JOIN sys_user_role ur ON ur.role_id=r.id WHERE ur.sys_user_id = #{sysUserId}")
	@Results(
			{
				@Result(property="id",column="id"),
				@Result(property="permissions",column = "id",javaType=List.class,
				many=@Many(select="com.piggame.dao.system.SysPermissionMapperCustom.findByRoleId"))
			}
			)
	List<SysRoleVo> findBySysUserId(Long sysUserId);
}
