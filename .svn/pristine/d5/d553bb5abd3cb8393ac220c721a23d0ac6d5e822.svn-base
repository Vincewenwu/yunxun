package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.dto.MemClassTeacherDto;
import com.vision.edu.entity.member.MemClassTeacher;

/**
 * <p>
  * 班级教师 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */

   

public interface MemClassTeacherMapper extends BaseMapper<MemClassTeacher> {
	
	/**
	 * 根据教师id查询班级信息
	 * @author lichenglong
	 * @date 2017年7月25日 下午2:07:19
	 * @param memberId
	 * @param deleteFlag
	 * @return
	 */
	List<MemClassTeacherDto> findClassInformationQuery(@Param("memberId")String memberId,@Param("deleteFlag")Integer deleteFlag);

}