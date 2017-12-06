package com.vision.edu.service.base;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.base.BaseClass;

/**
 * <p>
 * 班级 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseClassService extends IService<BaseClass> {
	
	
	/**
	 * 查询班级通过教师ID
	 * @author ChenYuanRong
	 * @date 2017年7月27日 上午8:40:49
	 * @param teacherId
	 * @return
	 */
	public List<BaseClass> findClassByTeacherId( String teacherId);
	
}
