package com.vision.edu.mapper.system;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.ClassTeacherDTO;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.dto.TeacherDTO;
import com.vision.edu.entity.system.SysModular;
import com.vision.edu.entity.system.SysUser;

/**
 * <p>
  * 后台用户 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

	/**
	 * 动态模糊查询教师
	 * @author jiangwangying
	 * @date 2017年7月31日 上午10:33:30
	 * @param page 分页
	 * @param schoolId 园校id
	 * @param vague 模糊
	 * @param memberType 成员类型
	 * @param sysUserId 用户id
	 * @param groupId 组id
	 * @return
	 */
	List<TeacherDTO> findTeacherByDynamic(Pagination page,@Param("schoolId") String schoolId,@Param("vague") String vague,@Param("memberType") Integer memberType,@Param("sysUserId")String sysUserId,@Param("groupId") String groupId);

	
	/**
	 * 查询用户信息
	 * @author XieFan
	 * @date 2017年7月16日 上午10:32:43
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	SysUserDTO findSysUserByUserNameAndPass(@Param("username")String username, @Param("password")String password);
	
	/**
	 * 根据后台用户id查询教师
	 * @author jiangwangying
	 * @date 2017年7月21日 上午9:17:12
	 * @param teacherId 后台用户id
	 * @param memberType 用户类型
	 * @return
	 */
	TeacherDTO findTeacherById(@Param("teacherId")String teacherId,@Param("memberType") Integer memberType);
	
	/**
	 * 根据园校id查询教师
	 * @author jiangwangying
	 * @date 2017年7月25日 上午11:45:50
	 * @param schoolId 园校id
	 * @param memberType 用户类型
	 * @param classId 班级id
	 * @return
	 */
	List<TeacherDTO>  findTeacherBySchoolId(@Param("schoolId")String schoolId,@Param("memberType") Integer memberType,@Param("classId") String classId);
	
	/**
	 * 查询用户角色
	 * @author XieFan
	 * @date 2017年7月23日 上午10:44:34
	 * @param page 分页器
	 * @param schoolId 园校ID
	 * @param nameNum 姓名/账号
	 * @return
	 */
	List<BaseEntity> findUserRoleBySchoolId(Pagination page,@Param("schoolId")String schoolId,@Param("nameNum")String nameNum);
	
	/**
	 * 查询园校信息
	 * @author XieFan
	 * @date 2017年7月23日 下午5:14:44
	 * @param schoolId 园校ID
	 * @return
	 */
	List<BaseEntity> findAllSchoolName(@Param("schoolId")String schoolId);
	
	/**
	 * 查询角色
	 * @author XieFan
	 * @date 2017年7月24日 上午11:58:14
	 * @param schoolId 园校ID
	 * @return
	 */
	List<BaseEntity> findRoleNames(@Param("schoolId")String schoolId);
	
	/**
	 * 根据用户名查询用户信息
	 * @author XieFan
	 * @date 2017年7月25日 下午3:04:13
	 * @param account 用户名
	 * @return
	 */
	SysUserDTO findSysUserByUserName(@Param("username")String username);
	
	/**
	 * 根据角色ID查询模块
	 * @author XieFan
	 * @date 2017年7月25日 下午4:08:11
	 * @param roleId 角色ID
	 * @return
	 */
	Set<SysModular> findModularByRoleId(@Param("roleId")String roleId);
	
	/**
	 * 查询菜单父节点
	 * @author XieFan
	 * @date 2017年7月27日 下午11:24:53
	 * @param roleId
	 * @return
	 */
	List<BaseEntity> findFarRoleModularByRoleId(@Param("roleId")String roleId);
	
	/**
	 * 查询菜单子节点
	 * @author XieFan
	 * @date 2017年7月27日 下午11:24:53
	 * @param roleId
	 * @return
	 */
	List<BaseEntity> findRoleModularByRoleId(@Param("roleId")String roleId, @Param("fatherId")String fatherId);
	
	/**
	 * 教师排班：查询班级教师
	 * @author jiangwangying
	 * @date 2017年8月1日 上午9:01:47
	 * @param schoolId 园校id
	 * @param classId 班级id
	 * @param selType 查询类型： 全部、已分班、未分班
	 * @param vague 姓名
	 * @param page 分页
	 * @return
	 */
	List<ClassTeacherDTO> findClassTeacher(Pagination page,@Param("schoolId")String schoolId,@Param("classId") String classId,@Param("selType")Integer selType,@Param("vague") String vague,@Param("memberType") Integer memberType);
}