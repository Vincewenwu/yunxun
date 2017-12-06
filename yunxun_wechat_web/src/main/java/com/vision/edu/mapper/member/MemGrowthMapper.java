package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.dto.MemGrowthDto;
import com.vision.edu.entity.member.MemGrowth;

/**
 * <p>
  * 成长轨迹 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemGrowthMapper extends BaseMapper<MemGrowth> {

	/**
	 * 根据班级id查询和班中的成长轨迹
	 * @author lichenglong
	 * @date 2017年7月16日 下午9:27:33
	 * @param classId 班级id
	 * @param resourcesType 资源类型
	 * @param DeleteFlag 删除标记
	 * @return
	 */
	List<MemGrowthDto> findGrowthTrack(@Param("classId")String classId,@Param("resourcesType")Integer resourcesType,@Param("deleteFlag")Integer deleteFlag);
	
	/**
	 * 成长轨迹集合字段
	 * @author lichenglong
	 * @date 2017年7月18日 下午3:59:37
	 * @param resourcesType 资源类型
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemGrowthDto> findGrowthTrajectoryCollectionField(@Param("resourcesType")Integer resourcesType,@Param("resourcesId")String resourcesId,@Param("deleteFlag")Integer deleteFlag);
}