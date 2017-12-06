package com.vision.edu.service.member;

import java.util.List;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.MemDynamicDto;
import com.vision.edu.entity.member.MemDynamic;

/**
 * <p>
 * 动态表包含[成长轨迹，营养食谱，班级圈，课堂动态，考勤签到....] 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-17
 */
public interface IMemDynamicService extends IService<MemDynamic> {
	
	/**
	 * 和班-全部动态 
	 * @author lichenglong
	 * @date 2017年7月17日 下午2:46:07
	 * @param classId 班级id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemDynamicDto> findWholeInformation(Pagination page,String classId, Integer deleteFlag);

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
	List<MemDynamicDto> findAKindOfDynamic(Pagination page,String classId,Integer resourcesType,Integer deleteFlag);
	
}
