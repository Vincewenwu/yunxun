package com.vision.edu.core.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.entity.system.SysModular;
import com.vision.edu.entity.system.SysUserRole;
import com.vision.edu.enums.EnumDisableFlag;
import com.vision.edu.framework.cons.Constants;
import com.vision.edu.service.system.ISysUserRoleService;
import com.vision.edu.service.system.ISysUserService;


/**
 * 
 * @author XieFan
 * @date 2017年7月16日 下午4:00:05
 * @version 1.0
 */
public class ShiroDBRealm extends AuthorizingRealm {
	
	/**
	 * 注入sysUserService
	 */
	@Autowired
	private ISysUserService sysUserService;
	
	/**
	 * 注入sysUserRoleService
	 */
	@Autowired
	private ISysUserRoleService sysUserRoleService;
  /** 
   *  理解为登陆验证。  认证过程   授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
   * @param principals
   * @author chenwenwu
   * @return=
   */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();	//这里是配合登录那边使用的AuthorizationInfo（授权、认证）  获取权限认证原理
//		          = anon
//   	 /login       = anon
//   	 /**		  = authc  表示必须经过认证之后才可以访问的页面
		//获取用户名
		String userName = (String) principals.getPrimaryPrincipal();
		//获取用户名
		//根据用户名查询用户信息
		SysUserDTO sysUser = this.sysUserService.findSysUserByUserName(userName);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();	//这里是配合登录那边使用的AuthorizationInfo（授权、认证）  获取权限认证原理
		if(sysUser != null){// 查用户角色
			List<SysUserRole> sysUserRoles = this.sysUserService.findSysUserRoleByUserId(sysUser.getId());
			Set<String> permissionSet = new HashSet<String>();
			for (SysUserRole sysUserRole : sysUserRoles) {
				if(StringUtils.isNotBlank(sysUserRole.getRoleId())){
					info.addRole(sysUserRole.getRoleId());//收集角色ID
					Set<SysModular> resources = sysUserService.findModularByRoleId(sysUserRole.getRoleId());//查询权限模块
					if(resources!=null && !resources.isEmpty()){
						for(SysModular r : resources){
							if(StringUtils.isNotBlank(r.getUrl())){
								System.out.println(r.getUrl());
								permissionSet.add(r.getUrl()); //收集url路径
							}
						}
					}
				}
			}
			//向与帐户直接相关的用户添加（分配）多个权限。
			//如果该帐户还没有任何基于字符串的权限，将自动创建一个新的权限集合（Set <String>）。
			info.addStringPermissions(permissionSet);
		}
		return info;
	}
/**
 * 授权流程
 * @param authcToken
 * @return
 * @throws AuthenticationException=
 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
		if(StringUtils.isEmpty(token.getUsername())){
        	return null;
        }
		SysUserDTO sysUser = this.sysUserService.findSysUserByUserName(token.getUsername());
		if(sysUser != null){
			if(sysUser.getDisableNo() == EnumDisableFlag.YTY.getValue()){
        		throw new LockedAccountException();
        	}
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(sysUser.getAccount(), sysUser.getPassword(), this.getName());
			Subject subject = SecurityUtils.getSubject();
			if(subject != null){
				Session session = subject.getSession();
				if(session != null){
					session.setAttribute(Constants.CURRENT_USER, sysUser);
				}
			}
			return authcInfo;
		}
		return null;
	}
	public static void main(String[] args) {
		
	}
	
}
