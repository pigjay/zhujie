package com.piggame.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.piggame.model.system.SysUser;


@Mapper
public interface SysUserDao {

	@Select("SELECT * FROM sys_user WHERE username = #{username}")
    @Results({
    	@Result(property="id",column="id"),
        @Result(property="roleList",column="id",javaType=List.class,
        	    many=@Many(select="com.wisely.ch7_7.mapper.test1.SysRoleMapper.findBySysUserId"))
    })
	SysUser findByUsername(String username);
}
