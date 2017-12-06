package com.vision.edu.service.member.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.MemClassTeacherDto;
import com.vision.edu.entity.member.MemClassTeacher;
import com.vision.edu.mapper.member.MemClassTeacherMapper;
import com.vision.edu.service.member.IMemClassTeacherService;

/**
 * <p>
 * 班级教师 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
@Transactional
public class MemClassTeacherServiceImpl extends ServiceImpl<MemClassTeacherMapper, MemClassTeacher> implements IMemClassTeacherService {
	
	@Autowired
	private MemClassTeacherMapper memClassTeacherMapper;
	
	/**
	 * 根据教师id查询班级信息
	 * @author lichenglong
	 * @date 2017年7月25日 下午2:07:19
	 * @param memberId
	 * @param deleteFlag
	 * @return
	 */
	@Override
	public List<MemClassTeacherDto> findClassInformationQuery(String memberId,Integer deleteFlag){
		List<MemClassTeacherDto> listMemClassTeacherDto = memClassTeacherMapper.findClassInformationQuery(memberId, deleteFlag);
		return listMemClassTeacherDto;
	}
}
