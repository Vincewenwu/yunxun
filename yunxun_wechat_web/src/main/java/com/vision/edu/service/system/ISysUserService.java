package com.vision.edu.service.system;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.CookbookPublishersSetDto;
import com.vision.edu.dto.SysUserDto;
import com.vision.edu.entity.system.SysUser;

/**
 * <p>
 * 后台用户 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface ISysUserService extends IService<SysUser> {

	/**
	 * 根据资源id查询发布菜谱者信息
	 * @author lichenglong
	 * @date 2017年7月20日 下午2:37:34
	 * @param resourcesId 资源id
	 * @return
	 */
	CookbookPublishersSetDto findDailyRecipes(String resourcesId,Integer resourcesType);

	/**
	 * 根据教师id查询出教师信息绑定教师端我的信息 
	 * @author lichenglong
	 * @date 2017年7月24日 上午8:46:09
	 * @param sysUserId 教师id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<SysUserDto> findMainPage(String sysUserId, Integer deleteFlag);

	/**
	 * 根据教师id查询出园校id
	 * @author lichenglong
	 * @date 2017年7月25日 上午10:03:34
	 * @param sysUserId 教师id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	SysUserDto findSysUserData(String sysUserId, Integer deleteFlag);

	/**
	 * 根据园校id查询教师信息绑定通讯录
	 * @author lichenglong
	 * @date 2017年7月25日 上午10:32:56
	 * @param schoolId  园校id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<SysUserDto> findTeacherAddressBook(String schoolId, Integer deleteFlag);
	
}
