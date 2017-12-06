package com.vision.edu.core.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.xiaoleilu.hutool.crypto.SecureUtil;

/**
 * Shiro 安全认证
 * @author zhangfeihong
 * @date 2017年7月6日 上午7:59:10
 * @version 1.0
 */
public class ShiroDBRealm extends AuthorizingRealm {

	//这里因为没有调用后台，直接默认只有一个用户("luoguohui"，"123456")
	private static final String USER_NAME = "luoguohui";
	private static final String PASSWORD = "123456";

	/**
	 * 权限认证
	 * @author zhangfeihong
	 * @date 2017年7月6日 上午8:32:48
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 登录验证
	 * @author zhangfeihong
	 * @date 2017年7月6日 上午8:32:48
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		if (token.getUsername().equals(USER_NAME)) {
			return new SimpleAuthenticationInfo(USER_NAME, SecureUtil.md5(PASSWORD), getName());
		} else {
			throw new AuthenticationException();
		}
	}


}
