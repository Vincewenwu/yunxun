package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.dto.GradeClassDTO;
import com.vision.edu.entity.base.BaseGrade;
import com.vision.edu.entity.base.BaseSchool;

/**
 * <p>
 * 年级表 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-17
 */
public interface BaseGradeMapper extends BaseMapper<BaseGrade> {

	/**
	 * 分页查找年级信息
	 * <p>Title: findAllGrade</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月22日 下午5:02:17
	 * @param page 分页
	 * @param gradeName 年级名称
	 * @return
	 */
	List<BaseGrade> findAllGrade(Page<BaseGrade> page, @Param("gradeName")String gradeName);

	/**
	 * 根据园校id查询年级
	 * @author zhangfeihong
	 * @date 2017年7月30日 下午8:48:09
	 * @param baseSchool
	 * @return
	 */
	List<BaseGrade> findGradeBySchoolId(@Param("baseSchool") BaseSchool baseSchool);

	/**
	 * 查询年级
	 * @author jiangwangying
	 * @date 2017年8月2日 下午2:52:57
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<GradeClassDTO> findGrade(@Param("deleteFlag") Integer deleteFlag);

}