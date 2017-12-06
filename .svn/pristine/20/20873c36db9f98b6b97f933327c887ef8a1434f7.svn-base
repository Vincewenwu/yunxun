/**
 * 
 */
package com.vision.edu.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.ParentingKnowledgeDTO;
import com.vision.edu.entity.base.BaseParentingKnowledge;
import com.vision.edu.entity.member.MemComment;
import com.vision.edu.entity.member.MemPraise;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseParentingKnowledgeService;
import com.vision.edu.service.member.IMemCommentService;
import com.vision.edu.service.member.IMemPraiseService;

/**
*这是育儿知识的模块控制器
*@author:zyml
*@date:2017年7月10日上午8:06:34
*/
@Controller
@RequestMapping("/parentingKnowledge")
public class ParentingKnowledgeControlller extends BaseController{
	
	@Autowired
	private IBaseParentingKnowledgeService baseParentingKnowledgeService;  //注入service
	
	@Autowired
	private IMemCommentService memCommentService;  //注入IMemCommentService
	
	
	private IMemPraiseService memPraiseService;   //注入IMemPraiseService
	
	/**
	*查询育儿知识的基本信息的集合
	*@author:zyml
	*@date:2017年7月10日上午8:08:50
	*@param schoolId 学校id sourseId 资源id
	*/
	@ResponseBody
	@RequestMapping("/findParentingKnowledge")
	public JsonResult findParentingKnowledge(String sourseId,String schoolId) {
		JsonResult rs=null;
		try {
			sourseId="10be84db7af5485cb0d67adfb7861814";
			schoolId="15a01f58760940b5aba5ba8612f223db";
			rs=new JsonResult();
			List<BaseEntity> listParentingKnowledge=baseParentingKnowledgeService.findParentingKnowledge(sourseId,schoolId);
			rs.setObj(listParentingKnowledge);
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
	@ResponseBody
	@RequestMapping("/findParentingKnowledgeMore")
	public JsonResult findParentingKnowledgeMore(String sourseId,String schoolId) {
		JsonResult rs=null;
		try {
			sourseId="10be84db7af5485cb0d67adfb7861814";
			schoolId="15a01f58760940b5aba5ba8612f223db";
			rs=new JsonResult();
			List<BaseEntity> listParentingKnowledge=baseParentingKnowledgeService.findParentingKnowledgeMore(sourseId,schoolId);
			rs.setObj(listParentingKnowledge);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	
	
	/**
	*根据育儿知识id进行育儿知识详情查看
	*@author:zyml
	*@date:2017年7月10日上午9:31:08
	*@param knowId 育儿知识id
	*/
	@ResponseBody
	@RequestMapping("/findParentingKnowledgeDetailById")
	public JsonResult findParentingKnowledgeDetailById(HttpServletRequest request) {
		JsonResult rs=null;
		try {
			String knowId=request.getParameter("id");
			/*knowId="10be84db7af5485cb0d67adfb7861814";*/
			System.out.println("==============="+"开始查询育儿知识详情"+"=================");
			rs=new JsonResult();
			BaseParentingKnowledge parentingKnowledgePoDetail=baseParentingKnowledgeService.findParentingKnowledgeDetailById(knowId);
			rs.setObj(parentingKnowledgePoDetail);
			System.out.println("==============="+"查询育儿知识详情结束"+"=================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	*根据育儿知识id查看相应的评论信息
	*@author:zyml
	*@date:2017年7月10日上午10:30:51
	*@param knowId 育儿知识id
	*/
	@ResponseBody
	@RequestMapping("/findParentingKnowledgeCommentById")
	public JsonResult findParentingKnowledgeCommentById(HttpServletRequest request) {
		JsonResult rs=null;
		try {
			/*knowId="10be84db7af5485cb0d67adfb7861814";*/
			String knowId=request.getParameter("id");
			rs=new JsonResult();
			System.out.println("========================"+"开始查询育儿知识相关的知识"+"=====================");
			List<BaseEntity> listParentingKnowledgePo=baseParentingKnowledgeService.findParentingKnowledgeCommentById(knowId);
			rs.setObj(listParentingKnowledgePo);
			System.out.println("========================"+"查询育儿知识相关的知识结束"+"=====================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/**
	*新增育儿知识详情评论
	*@author:zyml
	*@date:2017年7月10日下午5:41:32
	*@param MemComment 评论实体
	*/
	@ResponseBody
	@RequestMapping("/addYunErKnowComment")
	public void addYunErKnowComment(MemComment memComment) {
		this.memCommentService.addYunErKnowComment(memComment);
	}
	
	
	/**
	*新增育儿知识详情评论的点赞信息
	*@author:zyml
	*@date:2017年7月10日下午9:51:56
	*@param MemPraise 表扬实体
	*/
	@ResponseBody
	@RequestMapping("/addYunErKnowCommentParise")
	public void addYunErKnowCommentParise(MemPraise memPraise) {
		this.memPraiseService.addYunErKnowCommentParise(memPraise);
	}
	
	/**
	*根据id进行查询点赞数是否唯一显示相应的状态
	*@author:zyml
	*@date:2017年7月22日下午5:46:45
	*@param userId 用户id
	*/
	@ResponseBody
	@RequestMapping("/findByUserId")
	public JsonResult findByUserId(HttpServletRequest request) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			String userId=request.getParameter("id");
			String sourceId=request.getParameter("sourceId");
			MemPraise memPraise=memPraiseService.findByUserId(userId,sourceId);
			rs.setObj(memPraise);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/**
	*育儿知识点赞数的增加
	*@author:zyml
	*@date:2017年7月11日上午8:36:23
	*@param baseParentingKnowledge 育儿知识实体
	*/
	@ResponseBody
	@RequestMapping("/insertYunErKnow")
	public JsonResult insertYunErKnow(MemPraise memPraise) {
	  return baseParentingKnowledgeService.insertYunErKnow(memPraise);
	}
	
	
	/**
	 *育儿知识点赞数的修改
	 *@author:zyml
	 *@date:2017年7月12日上午8:20:24
	 *@param baseParentingKnowledge 育儿知识实体
	 */
	@ResponseBody
	@RequestMapping("/updateYunErKnow")
	public JsonResult updateYunErKnow(MemPraise memPraise) {
		return baseParentingKnowledgeService.updateYunErKnow(memPraise);
	}
	
	/**
	*育儿知识浏览量的增加
	*@author:zyml
	*@date:2017年7月11日上午10:42:06
	*@param baseParentingKnowledge 育儿知识实体
	*/
	@ResponseBody
	@RequestMapping("/updateYunErKnowBrow")
	public JsonResult updateYunErKnowBrow(BaseParentingKnowledge baseParentingKnowledge) {
		return baseParentingKnowledgeService.updateYunErKnowBrow(baseParentingKnowledge);
	}

}
