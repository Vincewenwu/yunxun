package com.vision.edu.mapper.system;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.base.BaseMember;
import com.vision.edu.entity.system.SysUser;
import com.vision.edu.entity.system.SysUserRole;

/**
 * <p>
  * 用户角色 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
	
	/**
	 * 根据手机号码和密码查询用户信息 
	 * @author XieFan
	 * @date 2017年7月31日 上午9:13:18
	 * @param phoneNum
	 * @return
	 */
	SysUser findUserByPoneNum(@Param("phoneNum") String phoneNum, @Param("password") String password);
	
	/**
	 * 根据账号查询用户信息
	 * @author XieFan
	 * @date 2017年7月31日 上午10:00:15
	 * @param account 账号
	 * @return
	 */
	SysUser findUserByAccount(@Param("account")String account);
	
	/**
	 * 根据手机号码查询用户基本信息
	 * @author XieFan
	 * @date 2017年7月31日 上午10:38:08
	 * @param phoneNum 手机号码
	 * @return
	 */
	BaseMember findBaseMemberByPhoneNum(@Param("phoneNum")String phoneNum);
	
	/**
	 * 根据用户ID查询用户信息
	 * @author XieFan
	 * @date 2017年7月31日 下午2:54:25
	 * @param userId 用户ID
	 * @return
	 */
	BaseEntity findSysUserByUserId(@Param("userId")String userId);

}