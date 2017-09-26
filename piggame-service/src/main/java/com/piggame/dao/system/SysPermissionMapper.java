package com.piggame.dao.system;

import com.piggame.model.system.SysPermission;
import com.piggame.model.system.SysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SysPermissionMapper {
    @Delete({
        "delete from sys_permission",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_permission (id, name, ",
        "resource_type, url, ",
        "permission, parent_id, ",
        "parent_ids, available)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{resourceType,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{permission,jdbcType=VARCHAR}, #{parentId,jdbcType=BIGINT}, ",
        "#{parentIds,jdbcType=VARCHAR}, #{available,jdbcType=TINYINT})"
    })
    int insert(SysPermission record);

    @InsertProvider(type=SysPermissionSqlProvider.class, method="insertSelective")
    int insertSelective(SysPermission record);

    @SelectProvider(type=SysPermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_type", property="resourceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="parent_ids", property="parentIds", jdbcType=JdbcType.VARCHAR),
        @Result(column="available", property="available", jdbcType=JdbcType.TINYINT)
    })
    List<SysPermission> selectByExample(SysPermissionExample example);

    @Select({
        "select",
        "id, name, resource_type, url, permission, parent_id, parent_ids, available",
        "from sys_permission",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_type", property="resourceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="parent_ids", property="parentIds", jdbcType=JdbcType.VARCHAR),
        @Result(column="available", property="available", jdbcType=JdbcType.TINYINT)
    })
    SysPermission selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysPermissionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysPermission record);

    @Update({
        "update sys_permission",
        "set name = #{name,jdbcType=VARCHAR},",
          "resource_type = #{resourceType,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "permission = #{permission,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=BIGINT},",
          "parent_ids = #{parentIds,jdbcType=VARCHAR},",
          "available = #{available,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysPermission record);
}