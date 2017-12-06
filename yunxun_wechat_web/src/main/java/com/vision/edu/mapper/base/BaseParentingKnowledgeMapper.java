package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.ParentingKnowledgeDTO;
import com.vision.edu.entity.base.BaseParentingKnowledge;

/**
 * <p>
  * 育儿知识 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseParentingKnowledgeMapper extends BaseMapper<BaseParentingKnowledge> {

	/**
	*查询育儿知识的基本信息的集合
	*@author:zyml
	*@date:2017年7月10日上午9:02:08
	*@param schoolId 学校id
	*@return
	*/
	List<BaseEntity> findParentingKnowledge(@Param("sourseId") String sourseId,@Param("schoolId") String schoolId);

	/**
	 * 根据育儿知识id进行育儿知识详情查看
	*@author:zyml
	*@date:2017年7月10日上午9:41:45
	*@param knowId 育儿知识id
	*@return
	*/
	BaseParentingKnowledge findParentingKnowledgeDetailById(@Param("knowId") String knowId);

	/**
	*根据育儿知识id查看相应的评论信息
	*@author:zyml
	*@date:2017年7月10日上午10:35:54
	*@param knowId 育儿知识id
	*@return
	*/
	List<BaseEntity> findParentingKnowledgeCommentById(@Param("knowId") String knowId);

	/**
	*查询育儿知识的更多信息
	*@author:zyml
	*@date:2017年7月10日上午8:08:50
	*@param schoolId 学校id sourseId 资源id
	*/
	List<BaseEntity> findParentingKnowledgeMore(@Param("sourseId") String sourseId,@Param("schoolId") String schoolId);

}