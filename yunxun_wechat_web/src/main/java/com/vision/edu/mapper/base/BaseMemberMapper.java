package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.GardenerDTO;
import com.vision.edu.dto.PrincipalMsgDTO;
import com.vision.edu.entity.base.BaseMember;

/**
 * <p>
  * 用户基本信息 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseMemberMapper extends BaseMapper<BaseMember> {

	/**
	*根据学校的id查找园长的基本信息
	*@author:zyml
	*@date:2017年7月9日上午11:01:48
	*@param strSchoolId 学校id
	*@param roleId  角色id
	*/
	BaseEntity findPrincipalById(@Param("schoolId") String schoolId,@Param("memberType") Integer memberType);
	/**
	*通过园长的id查询园长的详细信息
	*@author:zyml
	*@date:2017年7月9日下午12:03:19
	*@param userId 用户id
	*@param sourceId 资源id
	*/
	PrincipalMsgDTO findPrincipalDetailByUserId(@Param("strCode") String strCode, @Param("memberId") String memberId);

	/**
	 *查询一个园校所有老师的基本信息
	*@author:zyml
	*@date:2017年7月9日下午4:03:25
	*@param strCode 学校id
	*/
	List<BaseEntity> findListTeacher(@Param("schoolId") String schoolId,@Param("memberType") Integer memberType);

	/**
	*根据园丁id查询所有的详细信息
	*@author:zyml
	*@date:2017年7月9日下午5:47:13
	*@param strCode 园丁的id
	 */
	BaseEntity findListTeacherDetailById(@Param("strCode") String strCode, @Param("memberId") String memberId);

	/**
	 *查询一个园校所有老师的更多信息
	 *@param strCode 学校id
	 */
	List<BaseEntity> findListTeacherMore(@Param("schoolId") String schoolId,@Param("memberType") Integer memberType);

}