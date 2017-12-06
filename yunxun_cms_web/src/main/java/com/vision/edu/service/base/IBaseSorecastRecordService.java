package com.vision.edu.service.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.KaoQinTongJiDTO;
import com.vision.edu.dto.SorecastRecord;
import com.vision.edu.entity.base.BaseSorecastRecord;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 预报名记录 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseSorecastRecordService extends IService<BaseSorecastRecord> {

	/**
	 * 查询预报名家长
	 * @author jiangwangying
	 * @date 2017年7月16日 下午5:26:42
	 * @param page 分页
	 * @param schoolId 园校id
	 * @param name 家长姓名
	 * @return=List 预报名家长list集合
	 */
	List<SorecastRecord> findSorecastRecord(Pagination page, String schoolId, String name);

	/**
	 * 删除预报名家长
	 * @author jiangwangying
	 * @date 2017年7月25日 上午1:45:24
	 * @param ids 主键id集合
	 * @param updateMan 修改人
	 * @return
	 */
	JsonResult delSorecastRecord(String ids,String updateMan);
	
	
}
