package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.dto.MemClassCircleDto;
import com.vision.edu.entity.member.MemClassCircle;

/**
 * <p>
  * 班级圈 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemClassCircleMapper extends BaseMapper<MemClassCircle> {

	/**
	 * 根据班级id查询班级圈
	 * @author lichenglong
	 * @date 2017年7月17日 上午10:00:14
	 * @param classId 班级id
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemClassCircleDto> findClassRingDynamic(@Param("classId")String classId,@Param("resourcesType")Integer resourcesType,@Param("deleteFlag")Integer deleteFlag);
	
	/**
	 * 班级圈动态集合
	 * @author lichenglong
	 * @date 2017年7月18日 下午4:14:16
	 * @param resourcesType 资源类型
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemClassCircleDto> findDynamicCollectionClassRing(@Param("resourcesType")Integer resourcesType,@Param("resourcesId")String resourcesId,@Param("deleteFlag")Integer deleteFlag);
	
	/**
	 * 根据资源id查询班级圈详情
	 * @author lichenglong
	 * @date 2017年7月22日 上午8:50:41
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemClassCircleDto> findClassRingDetails(@Param("resourcesId")String resourcesId,@Param("deleteFlag")Integer deleteFlag);
}