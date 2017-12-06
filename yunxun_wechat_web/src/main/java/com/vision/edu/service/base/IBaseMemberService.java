package com.vision.edu.service.base;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.PrincipalMsgDTO;
import com.vision.edu.dto.WebUserVo;
import com.vision.edu.entity.base.BaseMember;
import com.vision.edu.entity.base.BaseWechat;

/**
 * <p>
 * 用户基本信息 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseMemberService extends IService<BaseMember> {


	/**
	 *根据学校的id查找园长的基本信息
	 *@author:zyml
	 *@date:2017年7月9日上午10:59:43
	 *@param strSchoolId 学校id
	 *@param roleId  角色id
	 */
	BaseEntity findPrincipalById(String schoolId, Integer emberType);

	/**
	 *通过园长的id查询园长的详细信息
	 *@author:zyml
	 *@date:2017年7月9日下午12:02:05
	 *@param userId 用户id
	 *@param sourceId 资源id
	 */
	PrincipalMsgDTO findPrincipalDetailByUserId(String userId);

	/**
	 *查询一个园校所有老师的基本信息
	 *@author:zyml
	 *@date:2017年7月9日下午4:01:26
	 *@param strCode 学校id
	 */
	List<BaseEntity> findListTeacher(String schoolId,Integer memberType);

	/**
	 *根据园丁id查询所有的详细信息
	 *@author:zyml
	 *@date:2017年7月9日下午5:47:13
	 *@param strCode 园丁的id
	 */
	BaseEntity findListTeacherDetailById(String strCode);

	/**
	 *查询一个园校的更多老师
	 *@author:zyml
	 *@date:2017年7月9日下午7:29:14
	 *@param strCode 学校id
	 */
	List<BaseEntity> findListTeacherMore(String schoolId,Integer memberType);

	/**
	 * 查询并判断当前微信用户是游客/申请中家长/已付费家长/过期家长/老师/
	 * @author zhangfeihong
	 * @date 2017年7月22日 下午8:15:51
	 * @param baseWechat
	 * @return
	 */
	WebUserVo checkMember(BaseWechat baseWechat);

}
