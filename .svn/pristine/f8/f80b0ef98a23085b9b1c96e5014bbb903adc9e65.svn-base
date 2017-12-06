package com.vision.edu.service.base;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.ParentingKnowledgeDTO;
import com.vision.edu.entity.base.BaseParentingKnowledge;
import com.vision.edu.entity.member.MemPraise;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 育儿知识 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseParentingKnowledgeService extends IService<BaseParentingKnowledge> {
	
	/**
	 *查询育儿知识的基本信息的集合
	*@author:zyml
	*@date:2017年7月10日上午8:58:53
	*@param schoolId 学校id
	*@return
	*/
	List<BaseEntity> findParentingKnowledge(String sourseId,String schoolId);

	/**
	 *根据育儿知识id进行育儿知识详情查看
	*@author:zyml
	*@date:2017年7月10日上午9:36:57
	*@param knowId 育儿知识id
	*@return
	*/
	BaseParentingKnowledge findParentingKnowledgeDetailById(String knowId);

	/**
	*根据育儿知识id查看相应的评论信息
	*@author:zyml
	*@date:2017年7月10日上午10:32:58
	*@param knowId 育儿知识id
	*@return
	*/
	List<BaseEntity> findParentingKnowledgeCommentById(String knowId);

	/**
	*育儿知识点赞数的增加,更新一条数据
	*@author:zyml
	*@date:2017年7月11日上午8:36:23
	*@param memPraise 点赞记录实体
	*/
	public JsonResult insertYunErKnow(MemPraise memPraise);

	/**
	*育儿知识浏览量的增加
	*@author:zyml
	*@date:2017年7月11日上午10:42:06
	*@param baseParentingKnowledge 育儿知识实体
	*/
	public JsonResult updateYunErKnowBrow(BaseParentingKnowledge baseParentingKnowledge);

	/**
	 *育儿知识点赞数的修改
	 *@author:zyml
	 *@date:2017年7月12日上午8:20:24
	 *@param baseParentingKnowledge 育儿知识实体
	 */
	JsonResult updateYunErKnow(MemPraise memPraise);

	/**
	*查询育儿知识的更多信息
	*@author:zyml
	*@date:2017年7月10日上午8:08:50
	*@param schoolId 学校id sourseId 资源id
	*/
	List<BaseEntity> findParentingKnowledgeMore(String sourseId, String schoolId);
	
}
