package com.vision.edu.service.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.KaoQinTongJiDTO;
import com.vision.edu.dto.SignDTO;
import com.vision.edu.entity.base.BaseSign;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 签到表，宝贝排班的时候就要添加到签到表，每天定时更新这表的状态。签到，签离时候更新这签到状态，同时同步新增一条签到记录到 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseSignService extends IService<BaseSign> {
	
	/**
	 * 查询签到
	 * @author jiangwangying
	 * @date 2017年8月3日 下午3:40:46
	 * @param page 分页
	 * @param schoolId 学校id
	 * @param vague 关键字
	 * @param classId 班级id
	 * @param signState 签到状态
	 * @return
	 */
	List<SignDTO> findSign(Pagination page,String schoolId, String classId, String vague, Integer signState);
	
	/**
	 * 查询未签到宝贝
	 * @author jiangwangying
	 * @date 2017年8月2日 下午8:41:26
	 * @param schoolId
	 * @param classId
	 * @return
	 */
	List<SignDTO> findNoSignBaby(String schoolId,String classId);

	/**
	 * 补考勤
	 * @author jiangwangying
	 * @date 2017年8月3日 上午7:52:12
	 * @param babyId 宝贝id集合
	 * @param signType 签到类型
	 * @param signState 签到状态
	 * @param updateMan 修改人
	 * @return
	 */
	JsonResult buKaoQin(String babyId, Integer signType, Integer signState, String updateMan);

	/**
	 * 根据签到id删除签到
	 * @author jiangwangying
	 * @date 2017年8月3日 下午2:44:44
	 * @param signId 签到id
	 * @param updateMan 签到宝贝
	 * @return
	 */
	JsonResult delSignById(String signId, String updateMan);
	
	/**
	 * 更新签到类别  不是重置  是将未纳入或者已在签到表中删除的正常的宝贝加入进签到表
	 * @author jiangwangying
	 * @param schoolId 
	 * @date 2017年8月3日 下午3:08:41
	 * @param createMan 新建人
	 * @param schoolId 园校id
	 * @return
	 */
	JsonResult gengxinQianDao(String createMan, String schoolId);
	
	/**
	 * 考勤统计
	 * @author jiangwangying
	 * @date 2017年8月3日 下午9:17:18
	 * @param schoolId 学校id
	 * @param babyId 宝贝id
	 * @param classId 班级id
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param deleteFlag 删除标记
	 * @param signState 签到状态
	 * @return
	 */
	 List<KaoQinTongJiDTO> kaoQinTongJiBySign(Pagination page,String schoolId,String babyId,String classId,Integer deleteFlag);
}
