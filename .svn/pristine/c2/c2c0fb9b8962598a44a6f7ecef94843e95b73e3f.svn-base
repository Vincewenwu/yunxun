package com.vision.edu.service.member;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.MemGrowthDto;
import com.vision.edu.entity.member.MemGrowth;

/**
 * <p>
 * 成长轨迹 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemGrowthService extends IService<MemGrowth> {

	/**
	 * 根据班级id查询和班中的成长轨迹
	 * @author lichenglong
	 * @date 2017年7月16日 下午9:47:00
	 * @param classId 班级id 
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<MemGrowthDto> findGrowthTrack(String classId, Integer resourcesType, Integer deleteFlag);

	/**
	 * 成长轨迹集合字段
	 * @author lichenglong
	 * @date 2017年7月18日 下午3:59:37
	 * @param resourcesType 资源类型
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemGrowthDto> findGrowthTrajectoryCollectionField(Integer resourcesType, String resourcesId,Integer deleteFlag);
	
}
