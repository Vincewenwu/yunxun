package com.vision.edu.service.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.MemClassCircleDTO;
import com.vision.edu.dto.OneBabybaseSurrogateDTO;
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
	 * 查询班级《圈》信息
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午3:27:03
	 * @param page
	 * @param memClassCircleDTO 班级圈实体
	 * @return
	 */
	 List<MemClassCircleDTO> findMemClassCircleDTO(Pagination page,MemClassCircleDTO memClassCircleDTO );
	 /**
	  * 删除班级圈
	  * @author ChenWenWu
	  * @date 2017年7月24日 下午4:10:45
	  * @param ids 班级圈集合
	  * @return
	  */
	 Integer delMemClassCircle(String ids,String updateMan);
	 /**
	  * 发布班级动态同时发布动态
	  * @author ChenWenWu
	  * @date 2017年8月9日 上午9:42:55
	  * @param memClassCircle
	  * @return
	  */
	 Integer addClassDT(MemClassCircle memClassCircle);
}
