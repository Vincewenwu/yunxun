package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.ClassDTO;
import com.vision.edu.entity.base.BaseClass;

/**
 * <p>
  * 班级 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseClassMapper extends BaseMapper<BaseClass> {

	/**
	 * 查询班级
	 * @author jiangwangying
	 * @date 2017年8月7日 下午8:32:11
	 * @param page 分页
	 * @param schoolId 园校id
	 * @param gradeId 年级id
	 * @param classId 班级id
	 * @return
	 */
	List<ClassDTO> findClassByDynamic(Pagination page,@Param("schoolId") String schoolId,@Param("gradeId") String gradeId,@Param("vague")String vague);
}