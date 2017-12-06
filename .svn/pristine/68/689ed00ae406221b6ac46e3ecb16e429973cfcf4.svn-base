package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.SorecastRecord;
import com.vision.edu.entity.base.BaseSorecastRecord;

/**
 * <p>
  * 预报名记录 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseSorecastRecordMapper extends BaseMapper<BaseSorecastRecord> {

	/**
	 * 查询预报名家长
	 * @author jiangwangying
	 * @date 2017年7月16日 下午5:26:42
	 * @param page 分页
	 * @param schoolId 园校id
	 * @param name 家长姓名
	 * @return=List 预报名家长list集合
	 */
	List<SorecastRecord> findSorecastRecord(Pagination page,@Param("schoolId") String schoolId,@Param("name") String name);
}