package com.piggame.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.piggame.vo.system.SysUserVo;

@Mapper
public interface SysUserMapperCustom {
	@Select("SELECT * FROM sys_user WHERE username = #{username}")
    @Results({
    	@Result(property="id",column="id"),
        @Result(property="roles",column="id",javaType=List.class,
        	    many=@Many(select="com.piggame.dao.system.SysRoleMapperCustom.findBySysUserId"))
    })
	SysUserVo findByUsername(String username);
}
