package com.piggame.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piggame.dao.system.SysPermissionMapper;
import com.piggame.dao.system.SysRoleMapper;
import com.piggame.dao.system.SysUserMapper;
import com.piggame.dao.system.SysUserMapperCustom;
import com.piggame.model.system.SysUser;
import com.piggame.model.system.SysUserExample;
import com.piggame.service.system.SysUserService;
import com.piggame.vo.system.SysUserVo;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	
	@Autowired
	private SysUserMapperCustom  sysUserMapperCustom;
	
	@Override
	public List<SysUser> findAll() {
		return sysUserMapper.findAll();
	}

	@Override
	public SysUser findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysUser insert(SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysUser update(SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public SysUserVo findByUsername(String userName) {
		return sysUserMapperCustom.findByUsername(userName);
	}

}
