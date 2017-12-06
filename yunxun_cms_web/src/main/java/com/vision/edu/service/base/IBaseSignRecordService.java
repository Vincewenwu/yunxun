package com.vision.edu.service.base;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.KaoQinTongJiDTO;
import com.vision.edu.dto.SigStatisticsDTO;
import com.vision.edu.entity.base.BaseSign;
import com.vision.edu.entity.base.BaseSignRecord;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 签到记录 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseSignRecordService extends IService<BaseSignRecord> {

	/**
	 * 新增宝贝签到记录
	 * @author zhangfeihong
	 * @date 2017年7月31日 下午2:32:45
	 * @param baseSignRecord
	 * @return
	 */
	BaseSign addBabySurrogate(BaseSignRecord baseSignRecord);
	
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
	List<KaoQinTongJiDTO> kaoQinTongJi(String schoolId,String babyId,String classId,String startTime,String endTime,Integer deleteFlag);

	/**
	 * 辅助考勤统计
	 * @author jiangwangying
	 * @date 2017年8月3日 下午9:40:23
	 * @param schoolId 园校id
	 * @param classId 班级id
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param updateMan 修改人
	 * @return
	 */
	JsonResult TongJi(Pagination page,String schoolId, String classId, String startTime, String endTime, String updateMan);

}
