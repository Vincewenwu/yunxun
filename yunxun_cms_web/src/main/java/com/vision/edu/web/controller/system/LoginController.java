package com.vision.edu.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.framework.cons.Constants;
import com.vision.edu.framework.support.HttpCode;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.platform.util.StringUtil;
import com.vision.edu.service.system.ISysUserService;

/**
 * 登录控制器类
 * @author XieFan
 * @date 2017年7月14日 下午5:07:54
 * @version 1.0
 */
@Controller
@RequestMapping()
public class LoginController extends BaseController {
	
	/**
	 * 注入sysUserService
	 */
	@Autowired
	private ISysUserService sysUserService;
	
	/**
	 * 登  录
	 * @author XieFan
	 * @date 2017年7月16日 下午3:17:06
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public JsonResult login(String username, String password){
		//返回的json数据接收集合
		JsonResult jsonResult = new JsonResult();
		//判断用户名
		if(StringUtil.isEmpty(username)){
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.LOGIN_FAIL.value().toString());
			jsonResult.setMsg("用户名不能为空");
			return jsonResult;
		}
		//判断密码
		if(StringUtil.isEmpty(password)){
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.LOGIN_FAIL.value().toString());
			jsonResult.setMsg("密码不能为空");
			return jsonResult;
		}
		//判断sysUser
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			
//			Subject反正就好像呈现的视图。所有Subject 都绑定到SecurityManager，
//			与Subject的所有交互都会委托给SecurityManager；可以把Subject认为是一个门面；
//			SecurityManager才是实际的执行者；对于上面这句话的理解呢？怎么去理解这个很重要，
//			看看别人的代码设计的流程也是比较的清楚的，Subject都绑定到了SecurityManager，
//			因此我们在创建Subject的时候，必须给框架的内部绑定了一个SecurityManager
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			System.out.println(Constants.CURRENT_USER);
			SysUserDTO sysUserDTO = (SysUserDTO) subject.getSession().getAttribute(Constants.CURRENT_USER);
			List<BaseEntity> sysRoleModulars = null;
			if(sysUserDTO != null){
				sysRoleModulars = sysUserService.findRoleModulatByRoleId(sysUserDTO.getDefaultRoleId());
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sysUser", sysUserDTO);
			map.put("sysRoleModulars", sysRoleModulars);//查询对应的权限模块就是菜单
			//登录成功
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("登录成功");
			jsonResult.setObj(map);
			return jsonResult;
		} catch (LockedAccountException lae) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.LOGIN_FAIL.value().toString());
			jsonResult.setMsg("账号已被禁用");
			return jsonResult;
		} catch (AuthenticationException ae) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.LOGIN_FAIL.value().toString());
			jsonResult.setMsg("用户名或密码错误");
			return jsonResult;
		} catch (Exception e) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.LOGIN_FAIL.value().toString());
			jsonResult.setMsg("登录异常");
			return jsonResult;
		}
	}
	
}
