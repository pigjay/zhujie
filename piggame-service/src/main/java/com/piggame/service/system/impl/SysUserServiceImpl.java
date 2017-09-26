package com.piggame.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piggame.dao.system.SysPermissionMapper;
import com.piggame.dao.system.SysRoleMapper;
import com.piggame.dao.system.SysUserMapper;
import com.piggame.model.system.SysUser;
import com.piggame.model.system.SysUserExample;
import com.piggame.service.system.SysUserService;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	
	@Override
	public List<SysUser> findAll() {
		// TODO Auto-generated method stub
		return null;
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
	public SysUser findByUsername(String userName) {
		SysUserExample example =new SysUserExample();
		example.createCriteria().andUsernameEqualTo(userName);
		SysUser sysUser =sysUserMapper.selectByExample(example).get(0);
		
		return null;
	}

}
