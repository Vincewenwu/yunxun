package com.vision.edu.service.member;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.MemClassTeacherDto;
import com.vision.edu.entity.member.MemClassTeacher;

/**
 * <p>
 * 班级教师 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemClassTeacherService extends IService<MemClassTeacher> {

	/**
	 * 根据教师id查询班级信息
	 * @author lichenglong
	 * @date 2017年7月25日 下午2:07:19
	 * @param memberId
	 * @param deleteFlag
	 * @return
	 */
	List<MemClassTeacherDto> findClassInformationQuery(String memberId, Integer deleteFlag);
	
}
