package com.piggame.dao.system;

import com.piggame.model.system.SysRole;
import com.piggame.model.system.SysRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface SysRoleMapper {
    @Delete({
        "delete from sys_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_role (id, role, ",
        "description, available)",
        "values (#{id,jdbcType=BIGINT}, #{role,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{available,jdbcType=TINYINT})"
    })
    int insert(SysRole record);

    @InsertProvider(type=SysRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SysRole record);

    @SelectProvider(type=SysRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="available", property="available", jdbcType=JdbcType.TINYINT)
    })
    List<SysRole> selectByExample(SysRoleExample example);

    @Select({
        "select",
        "id, role, description, available",
        "from sys_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="available", property="available", jdbcType=JdbcType.TINYINT)
    })
    SysRole selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysRole record);

    @Update({
        "update sys_role",
        "set role = #{role,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "available = #{available,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysRole record);
}