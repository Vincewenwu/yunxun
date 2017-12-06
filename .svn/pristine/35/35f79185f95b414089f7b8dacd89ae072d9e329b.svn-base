package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.MemDynamicDto;
import com.vision.edu.entity.member.MemDynamic;

/**
 * <p>
  * 动态表包含[成长轨迹，营养食谱，班级圈，课堂动态，考勤签到....] Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-17
 */
public interface MemDynamicMapper extends BaseMapper<MemDynamic> {

	/**
	 * 和班-全部动态 
	 * @author lichenglong
	 * @date 2017年7月17日 下午2:42:43
	 * @param classId 班级id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemDynamicDto> findWholeInformation(Pagination page,@Param("classId")String classId,@Param("deleteFlag")Integer deleteFlag);
	
	/**
	 * 根据状态查询和班信息
	 * @author lichenglong
	 * @date 2017年7月23日 上午10:23:28
	 * @param page 翻页集合
	 * @param classId 班级id
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemDynamicDto> findAKindOfDynamic(Pagination page,@Param("classId")String classId,@Param("resourcesType")Integer resourcesType,@Param("deleteFlag")Integer deleteFlag);
}