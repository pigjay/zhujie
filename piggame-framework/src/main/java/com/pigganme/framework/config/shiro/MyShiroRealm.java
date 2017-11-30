package com.pigganme.framework.config.shiro;

import com.piggame.model.system.SysPermission;
import com.piggame.service.system.SysUserService;
import com.piggame.vo.system.SysRoleVo;
import com.piggame.vo.system.SysUserVo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm  extends AuthorizingRealm{

	@Autowired
	private SysUserService sysUserService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		SysUserVo sysUser = (SysUserVo) principals.getPrimaryPrincipal();
		for(SysRoleVo role : sysUser.getRoles()) {
			authorizationInfo.addRole(role.getRole());
			for(SysPermission permission : role.getPermissions()) {
				authorizationInfo.addStringPermission(permission.getPermission());
			}
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	    //获取用户的输入的账号.
	    String username = (String) token.getPrincipal();
	    System.out.println(token.getCredentials());
	    //通过username从数据库中查找 User对象，如果找到，没找到.
	    //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
	    SysUserVo sysUser=sysUserService.findByUsername(username);
	    System.out.println("------>>sysUser="+sysUser);
	    if(sysUser == null) {
	    	return null;
	    }
	    
	    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
	    		sysUser,
	    		sysUser.getPassword(),
	    		ByteSource.Util.bytes(sysUser.getCredentialsSalt()),
	    		getName()
	    		);
	    
		return authenticationInfo;
	}

/*	public static void main(String[] args) {
			String password = "123456";
			String salt = "admin11";
		Md5Hash md5Hash = new Md5Hash(password,salt,2);
		String password_md5 = md5Hash.toString();
		System.out.println(password_md5);
	}*/
}
