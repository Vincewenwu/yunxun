package com.vision.edu.service.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.ClassDTO;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.entity.base.BaseClass;
import com.vision.edu.entity.base.BaseGrade;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 班级 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseClassService extends IService<BaseClass> {
	
	/**
	 * 动态查询班级
	 * @author jiangwangying
	 * @date 2017年8月7日 下午8:26:08
	 * @param page 分页
	 * @param schoolId 园校id 
	 * @param gradeId 年级id
	 * @param vague 关键字搜索
	 * @return
	 */
	List<ClassDTO> findClassByDynamic(Pagination page,String schoolId,String gradeId,String vague);

	/**
	 * 新增班级
	 * @author jiangwangying
	 * @date 2017年7月25日 下午2:28:18
	 * @param baseClass 班级实体
	 * @param createMan 创建人
	 * @return
	 */
	JsonResult addClass(BaseClass baseClass, String createMan);
	
	/**
	 * 修改班级
	 * @author jiangwangying
	 * @date 2017年7月25日 下午2:45:15
	 * @param baseClass 班级实体
	 * @param updateMan 修改人
	 * @return
	 */
	JsonResult editClass(BaseClass baseClass, String updateMan);

	/**
	 * 删除班级
	 * @author jiangwangying
	 * @date 2017年7月25日 下午5:05:12
	 * @param classIds 班级id集合
	 * @param updateMan 修改人
	 * @return
	 */
	JsonResult delClassById(String classIds, String updateMan);

	/**
	 * 进行分班
	 * @author jiangwangying
	 * @date 2017年7月26日 上午1:25:22
	 * @param fenBanClassId 班级id
	 * @param babyIds 宝贝id集合
	 * @param teamValue 学期
	 * @param updateMan 修改人
	 * @return
	 */
	JsonResult toFenBan(String fenBanClassId, String babyIds, SysUserDTO sysUserDTO, Integer teamValue);
	
	/**
	 * 根据年级id查询当前园校当前年级的所有班级
	 * @author zhangfeihong
	 * @date 2017年7月30日 下午8:59:52
	 * @param baseGrade
	 * @return
	 */
	List<BaseClass> selectClassByGradeId(BaseGrade baseGrade);

	/**
	 * 对已分班的学生进行移除
	 * @author jiangwangying
	 * @date 2017年8月5日 上午8:38:37
	 * @param babyIds 宝贝id
	 * @param schoolId 园校id
	 * @param updateMan 修改人
	 * @return
	 */
	JsonResult toRemoveBaby(String babyIds, String schoolId, String updateMan);

	/**
	 * 刷新班级人数
	 * @author jiangwangying
	 * @date 2017年8月5日 上午10:02:46
	 * @param schoolId 园校id
	 * @param updateMan 修改人
	 * @return
	 */
	JsonResult refreshBabyNum(String schoolId, String updateMan);

	/**
	 * 移除已经分班的教师
	 * @author jiangwangying
	 * @date 2017年8月5日 下午8:57:18
	 * @param memClassTeacherIds 班级教师id
	 * @param updateMan 修改人
	 * @param teacherIds 教师id
	 * @return
	 */
	JsonResult toRemoveTeacher(String memClassTeacherIds, String updateMan, String teacherIds);
}
