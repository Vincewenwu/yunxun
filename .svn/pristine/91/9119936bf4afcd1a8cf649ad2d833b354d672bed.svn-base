package com.vision.edu.service.base.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.ParentingKnowledgeDTO;
import com.vision.edu.entity.base.BaseParentingKnowledge;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.entity.member.MemPraise;
import com.vision.edu.mapper.base.BaseParentingKnowledgeMapper;
import com.vision.edu.mapper.member.MemPraiseMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseParentingKnowledgeService;

/**
 * <p>
 * 育儿知识 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseParentingKnowledgeServiceImpl extends ServiceImpl<BaseParentingKnowledgeMapper, BaseParentingKnowledge> implements IBaseParentingKnowledgeService {
	
	@Autowired
	private BaseParentingKnowledgeMapper baseParentingKnowledgeMapper;   //注入mapper
	
	@Autowired
	private MemPraiseMapper memPraiseMapper;
	
	/**
	 *查询育儿知识的基本信息的集合
	 *@param schoolId 学校id
	 */
	@Override
	public List<BaseEntity> findParentingKnowledge(String sourseId,String schoolId) {
		List<BaseEntity> listParentingKnowledge=baseParentingKnowledgeMapper.findParentingKnowledge(sourseId,schoolId);
		return listParentingKnowledge;
	}

	/**
	 *根据育儿知识id进行育儿知识详情查看
	 *@param knowId 育儿知识id
	 */
	@Override
	public BaseParentingKnowledge findParentingKnowledgeDetailById(String knowId) {
		BaseParentingKnowledge parentingKnowledgePo=baseParentingKnowledgeMapper.findParentingKnowledgeDetailById(knowId);
		return parentingKnowledgePo;
	}

	/**
	*根据育儿知识id查看相应的评论信息
	*@author:zyml
	*@date:2017年7月10日上午10:30:51
	*@param knowId 育儿知识id
	*/
	@Override
	public List<BaseEntity> findParentingKnowledgeCommentById(String knowId) {
		List<BaseEntity> listParentingKnowledgePo=baseParentingKnowledgeMapper.findParentingKnowledgeCommentById(knowId);
		return listParentingKnowledgePo;
	}

	/**
	*育儿知识点赞数的增加
	*@author:zyml
	*@date:2017年7月11日上午8:36:23
	*@param memPraise 点赞记录实体
	*/
	@Override
	public JsonResult insertYunErKnow(MemPraise memPraise) {
		JsonResult rs=null;
		try {
			System.out.println("================================");
			rs=new JsonResult();
			String userId =memPraise.getMemberId();   //获取用户id
			Integer cancel =1;                        //已经
			String sourseId=memPraise.getSourceId();
			memPraise.setMemberId(userId);
			memPraise.setCancelNo(cancel);
			memPraise.setSourceId(sourseId);
			memPraise.setCreateTime(new Date());
			memPraise.setPraiseType(1);
			memPraise.setDeleteFlag(1);
			this.memPraiseMapper.insert(memPraise);
			
			System.out.println("================进行修改操作====================");
			
			BaseParentingKnowledge baseParentingKnowledge=baseParentingKnowledgeMapper.findParentingKnowledgeDetailById(sourseId);  //查询相关的数据
			Integer praiseId=baseParentingKnowledge.getPointCount();
			Integer newpraiseId=praiseId+1;
			baseParentingKnowledge.setPointCount(newpraiseId);
			baseParentingKnowledgeMapper.updateById(baseParentingKnowledge);
			System.out.println("===============================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	*育儿知识浏览量的增加
	*@author:zyml
	*@date:2017年7月11日上午10:42:06
	*@param baseParentingKnowledge 育儿知识实体
	*/
	@Override
	public JsonResult updateYunErKnowBrow(BaseParentingKnowledge baseParentingKnowledge) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			System.out.println("==================================================");
			int i=baseParentingKnowledge.getBrowseCount();
			int newI=i+1;
			baseParentingKnowledge.setBrowseCount(newI);
			this.baseParentingKnowledgeMapper.updateById(baseParentingKnowledge);
			System.out.println("==================================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 *育儿知识点赞数的修改
	 *@author:zyml
	 *@date:2017年7月12日上午8:20:24
	 *@param baseParentingKnowledge 育儿知识实体
	 */
	@Override
	public JsonResult updateYunErKnow(MemPraise memPraise) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			String sourseId=memPraise.getSourceId();
			System.out.println("================================");
			Integer newpraiseId= null;
			System.out.println("================进行修改操作====================");
			BaseParentingKnowledge baseParentingKnowledge=baseParentingKnowledgeMapper.findParentingKnowledgeDetailById(sourseId);   //查询相关的数据
			Integer praiseId=baseParentingKnowledge.getPointCount();
			Integer cancel=memPraise.getCancelNo();
			if (cancel==0) {
				newpraiseId = praiseId-1;
				cancel=1;
			}else if(cancel==1){
				cancel=0;
				newpraiseId = praiseId + 1;
			}
			
			memPraise.setCancelNo(cancel);
			this.memPraiseMapper.updateById(memPraise);
			baseParentingKnowledge.setPointCount(newpraiseId);
			baseParentingKnowledgeMapper.updateById(baseParentingKnowledge);
			System.out.println("===============================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	*查询育儿知识的更多信息
	*@author:zyml
	*@date:2017年7月10日上午8:08:50
	*@param schoolId 学校id sourseId 资源id
	*/
	@Override
	public List<BaseEntity> findParentingKnowledgeMore(String sourseId, String schoolId) {
		List<BaseEntity> listParentingKnowledge=baseParentingKnowledgeMapper.findParentingKnowledgeMore(sourseId,schoolId);
		return listParentingKnowledge;
	}
	
}
