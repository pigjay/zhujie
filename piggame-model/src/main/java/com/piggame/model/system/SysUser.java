package com.piggame.model.system;

import java.util.List;

import com.piggame.base.BaseEntity;



public class SysUser extends BaseEntity<SysUser>{

	private Long id;
	
	private String username;
	
	private String name;
	
	private String password;
	
	private String salt;
	
	private Boolean state;
	
	private List<SysRole> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
	
	/**
	 * 重新对盐进行定义,用户名+salt
	 * @return
	 */
	public String getCredentialsSalt() {
		return this.username+this.salt;
	}
}
