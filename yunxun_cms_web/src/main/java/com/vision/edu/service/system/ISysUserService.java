package com.vision.edu.service.system;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.ClassTeacherDTO;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.dto.TeacherDTO;
import com.vision.edu.entity.base.BaseMember;
import com.vision.edu.entity.system.SysModular;
import com.vision.edu.entity.system.SysUser;
import com.vision.edu.entity.system.SysUserRole;
import com.vision.edu.platform.common.result.JsonResult;

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
	public List<TeacherDTO> findTeacherByDynamic(Pagination page,String schoolId,String vague,Integer memberType,String sysUserId,String groupId);

	/**
	 * 查询用户信息
	 * @author XieFan
	 * @date 2017年7月16日 上午10:32:43
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	SysUserDTO findSysUserByUserNameAndPass(String username, String password);
	
	/**
	 * 新增教师
	 * @author jiangwangying
	 * @date 2017年7月28日 下午0:26:46
	 * @param baseMember 用户基本信息
	 * @param sysUser 后台用户
	 * @param createMan 新建人
	 * @return
	 */
	JsonResult addTeacher(BaseMember baseMember,String dutiesId,String signature,String createMan);
	
	/**
	 * 根据后台用户id查询教师
	 * @author jiangwangying
	 * @date 2017年7月21日 上午9:17:12
	 * @param teacherId 后台用户id
	 * @param memberType 用户类型
	 * @return
	 */
    TeacherDTO findTeacherById(String teacherId,Integer memberType);

	/**
	 * 编辑教师
	 * @author jiangwangying
	 * @date 2017年7月21日 上午11:21:38
	 * @param baseMember 用户基本信息
	 * @param sysUserId 后台用户id
	 * @param dutiesId 职务id
	 * @param signature 签名
	 * @param updateMan 修改人
	 * @return
	 */
	JsonResult editTeacher(BaseMember baseMember,String sysUserId, String dutiesId, String signature, String updateMan);

	/**
	 * 停用教师账号
	 * @author jiangwangying
	 * @date 2017年7月21日 上午11:55:57
	 * @param sysUserIds 后台用户id集合
	 * @param updateMan 修改人
	 * @return
	 */
	JsonResult stopSysUser(String sysUserIds, String updateMan);

	/**
  	 * 将老师添加到分组/更改老师分组
  	 * @author jiangwangying
  	 * @date 2017年7月21日 下午4:16:22
  	 * @param sysUserIds 后台用户id集合
  	 * @param groupId 分组id
  	 * @return
  	 */
	JsonResult addToOrEditTeacherGroup(String sysUserIds, String groupId);

	/**
	 * 新增分组
	 * @author jiangwangying
	 * @date 2017年7月31日 下午2:46:39
	 * @param groupName 组名
	 * @param groupExplain 说明
	 * @param createMan 创建人
	 * @param schoolId 园id
	 * @return
	 */
	JsonResult addGroup(String groupName, String groupExplain,String createMan, String schoolId);
	
	/**
	 * 根据园校id查询教师
	 * @author jiangwangying
	 * @date 2017年7月25日 上午11:45:50
	 * @param schoolId 园校id
	 * @param memberType 用户类型
	 * @param classId  班级id
	 * @return
	 */
	List<TeacherDTO> findTeacherBySchoolId(String schoolId,Integer memberType, String classId);
	
	/**
	 * 查询用户角色
	 * @author XieFan
	 * @date 2017年7月23日 上午10:44:34
	 * @param page 分页器
	 * @param schoolId 园校ID
	 * @param nameNum 姓名/账号
	 * @return
	 */
	Page<BaseEntity> findUserRoleBySchoolId(Page<BaseEntity> page,String schoolId,String nameNum);
	
	/**
	 * 查询园校（绑定下拉框）
	 * @author XieFan
	 * @date 2017年7月23日 下午5:31:43
	 * @param schoolId 园校ID
	 * @return
	 */
	List<BaseEntity> findAllSchoolName(String schoolId);
	
	/**
	 * 查询角色
	 * @author XieFan
	 * @date 2017年7月24日 上午11:59:56
	 * @param schoolId 园校ID
	 * @return
	 */
	List<BaseEntity> findRoleNames(String schoolId);
	
	/**
	 * 新增编辑用户
	 * @author XieFan
	 * @date 2017年7月24日 下午4:31:06
	 * @param sysUser 用户实体
	 * @param map 其他新增信息（用户姓名，用户手机号码，校园ID，角色ID）
	 * @return
	 */
	JsonResult addEditUser(SysUser sysUser, Map<String, String> map);
	
	/**
	 * 根据用户名查询用户信息
	 * @author XieFan
	 * @date 2017年7月25日 下午3:09:14
	 * @param account 用户名
	 * @return
	 */
	SysUserDTO findSysUserByUserName(String username);
	
	/**
	 * 根据用户ID查询用户角色
	 * @author XieFan
	 * @date 2017年7月25日 下午3:21:25
	 * @param userId
	 * @return
	 */
	List<SysUserRole> findSysUserRoleByUserId(String userId);
	
	/**
	 * 根据角色ID查询模块
	 * @author XieFan
	 * @date 2017年7月25日 下午4:09:41
	 * @param roleId 角色ID
	 * @return
	 */
	Set<SysModular> findModularByRoleId(String roleId);
	
	/**
	 * 查询菜单子节点
	 * @author XieFan
	 * @date 2017年7月27日 下午11:29:10
	 * @param roleId
	 * @return
	 */
	List<BaseEntity> findRoleModulatByRoleId(String roleId);
	
	/**
	 * 教师排班：查询班级教师
	 * @author jiangwangying
	 * @date 2017年8月1日 上午9:01:47
	 * @param schoolId 园校id
	 * @param classId 班级id
	 * @param selType 查询类型： 全部、已分班、未分班
	 * @param vague 关键字
	 * @param page 分页
	 * @param memberType  用户类型
	 * @return
	 */
	List<ClassTeacherDTO> findClassTeacher(Pagination page,String schoolId,String classId,Integer selType,String vague, Integer memberType);

	/**
	 * 对选择的教师进行分班
	 * @author jiangwangying
	 * @date 2017年8月1日 上午10:53:37
	 * @param fenBanClassId 分配到班级的id
	 * @param teacherIds 教师id集合
	 * @param sysUserDTO 用户
	 * @return
	 */
	JsonResult selTeachersToFenBan(String fenBanClassId, String teacherIds, SysUserDTO sysUserDTO);
	
	/**
	 * 根据用户ID查询用户信息
	 * @author XieFan
	 * @date 2017年7月31日 下午3:08:24
	 * @param userId 用户ID
	 * @return
	 */
	BaseEntity findSysUserByUserId(String userId);
    
	/**
	 * 从组里面移除教师
	 * @author jiangwangying
	 * @date 2017年8月9日 上午10:46:15
	 * @param memberGroupIds
	 * @param updateMan
	 * @return
	 */
	public JsonResult toRemoveGroupTeacher(String memberGroupIds, String updateMan);

	/**
	 * 删除教师
	 * @author jiangwangying
	 * @date 2017年8月9日 下午12:00:06
	 * @param sysUserIds
	 * @param updateMan
	 * @return
	 */
	public JsonResult delSysUser(String sysUserIds, String updateMan);


}
