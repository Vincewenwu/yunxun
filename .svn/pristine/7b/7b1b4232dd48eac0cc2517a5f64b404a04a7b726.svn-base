package com.vision.edu.service.base;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.GradeClassDTO;
import com.vision.edu.entity.base.BaseGrade;
import com.vision.edu.entity.base.BaseSchool;

/**
 * <p>
 * 年级表 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-17
 */
public interface IBaseGradeService extends IService<BaseGrade> {

	/**
	 * 分页查找年级信息
	 * <p>Title: findAllGrade</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月22日 下午5:00:02
	 * @param page 分页
	 * @param gradeName 年级名称
	 * @return
	 */
	Page<BaseGrade> findAllGrade(Page<BaseGrade> page, String gradeName);

	/**
	 * 根据园校id查询年级
	 * @author zhangfeihong
	 * @date 2017年7月30日 下午5:17:55
	 * @param baseSchool
	 * @return
	 */
	List<BaseGrade> findGradeBySchoolId(BaseSchool baseSchool);

	/**
	 * 查询年级
	 * @author jiangwangying
	 * @date 2017年8月2日 下午2:50:40
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<GradeClassDTO> findGrade(Integer deleteFlag);

}
