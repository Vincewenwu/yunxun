package com.vision.edu.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseClass;
import com.vision.edu.entity.base.BaseEvalContent;
import com.vision.edu.entity.base.BaseEvalProject;
import com.vision.edu.entity.member.MemBabyEval;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.platform.util.StringUtil;
import com.vision.edu.service.base.IBaseBabyService;
import com.vision.edu.service.base.IBaseClassService;
import com.vision.edu.service.base.IBaseEvalContentService;
import com.vision.edu.service.base.IBaseEvalProjectService;
import com.vision.edu.service.member.IMemBabyEvalService;
import com.vision.edu.service.member.IMemBabyTeamService;
import com.vision.edu.service.member.IMemClassTeacherService;

/**
 * 评测
 * @author ChenYuanRong
 * @date 2017年7月25日 下午2:58:05
 * @version 1.0
 */
@Controller
@RequestMapping("/evaluate")
public class EvaluateController implements Serializable
{
	
	private static final Logger LOG =LoggerFactory.getLogger(EvaluateController.class);
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	/**
	 * 评测项目
	 */
	@Autowired
	private IBaseEvalProjectService iBaseEvalProjectService;	
	
	/**
	 * 评测内容
	 */
	@Autowired
	private IBaseEvalContentService iBaseEvalContentService;	
	
	/**
	 * 宝贝评测
	 */
	@Autowired
	private IMemBabyEvalService iMemBabyEvalService;
	
	/**
	 * 学期
	 */
	@Autowired
	private IMemBabyTeamService iMemBabyTeamService;
	/**
	 * 老师
	 */
	@Autowired
	private IMemClassTeacherService iMemClassTeacherService;
	 
	/**
	 * 班级
	 */
	@Autowired
	private IBaseClassService iBaseClassService;
	
	/**
	 * 宝贝
	 */
	@Autowired
	private IBaseBabyService iBaseBabyService;
	
	public IBaseBabyService getiBaseBabyService() {
		return iBaseBabyService;
	}




	public void setiBaseBabyService(IBaseBabyService iBaseBabyService) {
		this.iBaseBabyService = iBaseBabyService;
	}




	public IBaseClassService getiBaseClassService() {
		return iBaseClassService;
	}
	
	


	public void setiBaseClassService(IBaseClassService iBaseClassService) {
		this.iBaseClassService = iBaseClassService;
	}


	public IMemClassTeacherService getiMemClassTeacherService() {
		return iMemClassTeacherService;
	}


	public void setiMemClassTeacherService(IMemClassTeacherService iMemClassTeacherService) {
		this.iMemClassTeacherService = iMemClassTeacherService;
	}


	public IMemBabyTeamService getiMemBabyTeamService() {
		return iMemBabyTeamService;
	}


	public void setiMemBabyTeamService(IMemBabyTeamService iMemBabyTeamService) {
		this.iMemBabyTeamService = iMemBabyTeamService;
	}


	public IMemBabyEvalService getiMemBabyEvalService() {
		return iMemBabyEvalService;
	}


	public void setiMemBabyEvalService(IMemBabyEvalService iMemBabyEvalService) {
		this.iMemBabyEvalService = iMemBabyEvalService;
	}


	public IBaseEvalProjectService getiBaseEvalProjectService() {
		return iBaseEvalProjectService;
	}


	public void setiBaseEvalProjectService(IBaseEvalProjectService iBaseEvalProjectService) {
		this.iBaseEvalProjectService = iBaseEvalProjectService;
	}


	public IBaseEvalContentService getiBaseEvalContentService() {
		return iBaseEvalContentService;
	}


	public void setiBaseEvalContentService(IBaseEvalContentService iBaseEvalContentService) {
		this.iBaseEvalContentService = iBaseEvalContentService;
	}
    
	
	/**
	 * 获取老师所教的班级
	 * @author ChenYuanRong
	 * @date 2017年7月26日 上午11:33:48
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getClassByTeacherId")
	public JsonResult getClassByTeacherId()
	{
		String teacherId = "1";//老师ID
		List <BaseClass> list= iBaseClassService.findClassByTeacherId(teacherId);
		JsonResult jsonResult =new JsonResult();
		jsonResult.setObj(list);
		return jsonResult;
	}
	
	
	/**
	 * 获取宝贝 通过班级ID
	 * @author ChenYuanRong
	 * @date 2017年7月26日 下午3:04:34
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBadyByClassId")
	public JsonResult getBadyByClassId(HttpServletRequest request){
		
		String classId = request.getParameter("classId");
		JsonResult jsonResult=new JsonResult();
		if(StringUtil.isNotEmpty(classId) )
		{ 
		   List <BaseBaby> list = iBaseBabyService.getBabyByClassId(classId);
		   jsonResult.setObj(list);
		}
		else 
		{
			jsonResult.setMsg("classId 为空");
			LOG.error("classId 为空");
		}
		return jsonResult;
	}
	
	
	
	
	
	

	/**
	 * 家长端获取宝贝评测
	 * @author ChenYuanRong
	 * @date 2017年7月25日 下午3:00:48
	 * @param bodyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getEvaluate")
	public JsonResult getEvaluate(String bodyId)
	{
		return null;
	}
	
	
	
	
	
	/**
	 * 老师端获取宝贝评测
	 * @author ChenYuanRong
	 * @date 2017年7月25日 下午3:00:48
	 * @param bodyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getEvaluateTeacher")
	public JsonResult getEvaluateTeacher()
	{
		List<Object> list =new ArrayList<Object>();
		/**
		 * 获取评测项目
		 */
		List<BaseEvalProject> BaseEvalProjectList=iBaseEvalProjectService.getEvalProjectList();
		for (BaseEvalProject b : BaseEvalProjectList) 
		{
			Map<String ,Object> map = new HashMap<String ,Object>();
			map.put("evalProject", b);
			// 获取评测内容
			List<BaseEvalContent> BaseEvalContentList = iBaseEvalContentService.getEvalContentList(b.getId());
			Integer count =0;//项目总分
			List<Object> contentList = new ArrayList<Object>();
			for(BaseEvalContent e :BaseEvalContentList)
			{
				Integer max = 0;
				Map<String ,Object> contentMap = new HashMap<String ,Object>();
				List scoringList = null;
				try
				{
					    scoringList =  StringUtil.strSplitRetList( e.getScoringRange(), ",");//分割等分
						for (int i = 0; i < scoringList.size(); i++) 
						{
						    Integer index =	Integer.parseInt(scoringList.get(i).toString());
							if(max <= index)
							{
								max = index;//获取最大的分数
							}
						}
				}
				catch (Exception ex)
				{
					 LOG.error("字符转换错误：{}",  e.getScoringRange());
				}
				count += max ;//把最大的分数加起来
				contentMap.put("Content", e);
				contentMap.put("sco", scoringList); 
				contentList.add(contentMap);
			}
			map.put("count", count);
			map.put("evalContent", contentList);
			list.add(map);
		}
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(list);
		return jsonResult;
	}
	
	
	
	
	
	
	/**
	 * 老师评价学生保存
	 * @author ChenYuanRong
	 * @date 2017年7月26日 上午12:06:28
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insertEvaluteTeacher")
	public JsonResult insertEvaluteTeacher(HttpServletRequest request)
	{
		String selectData = request.getParameter("selectData");
		String badyId = request.getParameter("badyId");
		String mgs ="";
		if(StringUtil.isNotEmpty(selectData) && StringUtil.isNotEmpty(badyId)){
		   // System.out.println(selectData);
			List<Object> list = new ArrayList<Object>();
			String [] str = selectData.split("_");
		    for (int i = 0; i < str.length; i++) 
		    {
		    	String [] str2 = str[i].split(",");
		    	Map<String ,String> map =new HashMap<String ,String>();
		    	for (int j = 0; j < str2.length; j++) 
		    	{
		    		String [] str3 = str2[j].split(":");
		    		map.put(str3[0], str3[1]);
				}
		    	list.add(map);
			}
		    Boolean b = false;
			try {
				//获取学期ID
              // String memBabyTeamId = iMemBabyTeamService.findMemBabyTeamByBadyId(badyId);
               b = iMemBabyEvalService.add(list, badyId,"22221");
			} catch (Exception e) {
				mgs ="网络好像有点问题，请稍后重试！";//新增失败
				e.printStackTrace();
			}
		   
		    if(b)
		    {
		      mgs ="评价成功！";
		    }
		    else {
		      mgs = "评价失败！！";
		    	
		    } 
		} else {
			mgs = "网络好像有点问题，请稍后重试！！";//  参数错误
		}
		JsonResult jsonResult = new JsonResult();
		jsonResult.setMsg(mgs);
		return jsonResult;
	}
	
	/**
	 * 获取显示宝贝评测信息  
	 * @author ChenYuanRong
	 * @date 2017年7月26日 下午5:06:14
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeacherEvaluateShow")
	public JsonResult getTeacherEvaluateShow(HttpServletRequest request) {
		String babyId =request.getParameter("babyId");
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj("");
		return jsonResult;
	}
	
	/**
	 * 获取八角的需要的数据
	 * @author ChenYuanRong
	 * @date 2017年7月26日 下午5:26:52
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getEchartsData")
	public JsonResult getEchartsData()
	{
		//定义一个保存项目名和总分的数组
		List<Object> list =new ArrayList<Object>();
		/**
		 * 获取评测项目
		 */
		List<BaseEvalProject> BaseEvalProjectList=iBaseEvalProjectService.getEvalProjectList();
		// 获取评测内容
		for (BaseEvalProject b : BaseEvalProjectList) 
		{
			Integer count =0;//项目总分
		    List<BaseEvalContent> BaseEvalContentList = iBaseEvalContentService.getEvalContentList(b.getId());
		    for(BaseEvalContent e :BaseEvalContentList)
			{
				Integer max = 0; 
				List<String> scoringList = null;
				try
				{
				    scoringList =  StringUtil.strSplitRetList( e.getScoringRange(), ",");//分割等分
					for (int i = 0; i < scoringList.size(); i++) 
					{
					    Integer index =	Integer.parseInt(scoringList.get(i).toString());
						if(max <= index)
						{
							max = index;//获取最大的分数
						}
					}
				}
				catch (Exception ex)
				{
					 LOG.error("字符转换错误：{}",  e.getScoringRange());
				}
				count += max ;//把最大的分数加起来
			}
		    Map<String ,String> map =new HashMap<String ,String>(); 
		    map.put("name", b.getProjectName());
		    map.put("max", count.toString() );
		    list.add(map);
		}
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(list);
		return jsonResult;
	}

}
