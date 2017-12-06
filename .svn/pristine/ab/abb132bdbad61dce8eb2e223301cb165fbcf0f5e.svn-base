package com.vision.edu.service.member;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.MemClassCircleDto;
import com.vision.edu.entity.member.MemClassCircle;

/**
 * <p>
 * 班级圈 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemClassCircleService extends IService<MemClassCircle> {

	/**
	 * 根据班级id查询班级圈
	 * @author lichenglong
	 * @date 2017年7月17日 上午10:04:32
	 * @param classId 班级id
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemClassCircleDto> findClassRingDynamic(String classId, Integer resourcesType, Integer deleteFlag);

	/**
	 * 班级圈动态集合
	 * @author lichenglong
	 * @date 2017年7月18日 下午4:14:16
	 * @param resourcesType 资源类型
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemClassCircleDto> findDynamicCollectionClassRing(Integer resourcesType, String resourcesId,Integer deleteFlag);

	/**
	 * 根据资源id查询班级圈详情
	 * @author lichenglong
	 * @date 2017年7月22日 上午8:50:41
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemClassCircleDto> findClassRingDetails(String resourcesId, Integer deleteFlag);

	
}
