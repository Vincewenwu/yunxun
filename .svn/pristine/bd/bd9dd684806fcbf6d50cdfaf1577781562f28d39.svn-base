package com.vision.edu.service.system.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.CookbookPublishersSetDto;
import com.vision.edu.dto.SysUserDto;
import com.vision.edu.entity.system.SysUser;
import com.vision.edu.mapper.system.SysUserMapper;
import com.vision.edu.service.system.ISysUserService;

/**
 * <p>
 * 后台用户 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;//注入SysUserMapper
	
	/**
	 * 根据资源id查询发布菜谱者信息
	 * @author lichenglong
	 * @date 2017年7月20日 下午2:37:34
	 * @param resourcesId 资源id
	 * @return
	 */
	@Override
	public CookbookPublishersSetDto findDailyRecipes(String resourcesId,Integer resourcesType){
		CookbookPublishersSetDto cookbookPublishersSetDto = sysUserMapper.findDailyRecipes(resourcesId,resourcesType);
		return cookbookPublishersSetDto;
	}
	
	/**
	 * 根据教师id查询出教师信息绑定教师端我的信息 
	 * @author lichenglong
	 * @date 2017年7月24日 上午8:46:09
	 * @param sysUserId 教师id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	@Override
	public List<SysUserDto> findMainPage(String sysUserId,Integer deleteFlag){
		List<SysUserDto> listSysUserDto = sysUserMapper.findMainPage(sysUserId, deleteFlag);
		return listSysUserDto;
	}
	
	/**
	 * 根据教师id查询出园校id
	 * @author lichenglong
	 * @date 2017年7月25日 上午10:03:34
	 * @param sysUserId 教师id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	@Override
	public SysUserDto findSysUserData(String sysUserId,Integer deleteFlag){
		SysUserDto sysUserDto = sysUserMapper.findSysUserData(sysUserId, deleteFlag);
		return sysUserDto;
	}
	
	/**
	 * 根据园校id查询教师信息绑定通讯录
	 * @author lichenglong
	 * @date 2017年7月25日 上午10:32:56
	 * @param schoolId  园校id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	@Override
	public List<SysUserDto> findTeacherAddressBook(String schoolId,Integer deleteFlag){
		List<SysUserDto> listSysUserDto = sysUserMapper.findTeacherAddressBook(schoolId, deleteFlag);
		return listSysUserDto;
	}
	 
}
