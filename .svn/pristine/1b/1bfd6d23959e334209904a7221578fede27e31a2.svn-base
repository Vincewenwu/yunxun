package com.vision.edu.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.openxml4j.opc.internal.unmarshallers.UnmarshallContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.RdbmsOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.sql.dialect.oracle.ast.clause.ModelClause.ReturnRowsClause;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.BaseSchoolDTO;
import com.vision.edu.dto.BaseSchoolMsgDTO;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseSchoolService;

/**
 * 
*Title:ParkController
*Description:这里是园所信息的控制器
*@author:zyml
*@date:2017年7月5日下午7:53:34
 */
@Controller
@RequestMapping("/park")
public class ParkController extends BaseController{
	
	@Autowired
	private IBaseSchoolService baseSchoolService;     //注入service
	
	/**
	*这是查询园校对应的所属地区
	*@author:zyml
	*@date:2017年7月5日下午8:40:04
	*/
	@ResponseBody
	@RequestMapping("/findSchoolList")
	public JsonResult findSchoolList() {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			System.out.println("================"+"开始查询园校对应的所属地区"+"==============");
			List<BaseSchoolDTO> baseSchoolPo=baseSchoolService.findSchoolList();
			rs.setObj(baseSchoolPo);
			System.out.println("================"+"开始查询园校对应的所属地区结束"+"==============");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	*这是查询园校对应的所属地区
	*@author:zyml
	*@date:2017年7月5日下午8:40:04
	*/
	@ResponseBody
	@RequestMapping("/findSchoolListOnly")
	public JsonResult findSchoolListOnly() {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			System.out.println("================"+"开始查询园校对应的所属地区"+"==============");
			List<BaseEntity> baseSchoolPo=baseSchoolService.findSchoolListOnly();
			rs.setObj(baseSchoolPo);
			System.out.println("================"+"开始查询园校对应的所属地区结束"+"==============");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	*模糊查询院校信息
	*@author:zyml
	*@date:2017年7月6日上午8:34:02
	*@param strSchoolName 学校名称
	*/
	@ResponseBody
	@RequestMapping("/findSchool")
	public JsonResult findSchool(HttpServletRequest request) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			System.out.println("========="+"开始进行数据的模糊查询"+"============");
			/*String strSchoolName="红";*/
			String strSchoolName=request.getParameter("name");
			List<String> listSchoolMsg=baseSchoolService.findSchool(strSchoolName);
			rs.setObj(listSchoolMsg);
			System.out.println("========="+"数据的模糊查询成功"+"================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	*根据学校的id查询园所介绍的基本信息
	*@author:zyml
	*@date:2017年7月10日下午2:12:20
	*@param strSchoolId 学校id
	*/
	@ResponseBody
	@RequestMapping("/findSchoolMsgBase")
	public JsonResult findSchoolMsgBase(String strSchoolId) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			System.out.println("==========="+"开始查询园所的信息"+"============");
			strSchoolId="10be84db7af5485cb0d67adfb7861814";
			BaseEntity baseSchoolMsgPo=baseSchoolService.findSchoolMsgBase(strSchoolId);
			rs.setObj(baseSchoolMsgPo);
			System.out.println("==========="+"查询园所的信息结束"+"============");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	*根据学校的id查询园所介绍的详细信息
	*@author:zyml
	*@date:2017年7月16日下午3:50:27
	*@param strSchoolId 学校id
	*/
	@ResponseBody
	@RequestMapping("/findSchoolMsgDetail")
	public JsonResult findSchoolMsgDetail(String strSchoolId) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			System.out.println("==========="+"开始查询园所详情的信息"+"============");
			strSchoolId="10be84db7af5485cb0d67adfb7861814";
			BaseEntity baseSchoolMsgDTO=baseSchoolService.findSchoolMsgDetail(strSchoolId);
			rs.setObj(baseSchoolMsgDTO);
			System.out.println("==========="+"查询园所详情的信息结束"+"============");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	
	/**
	 *查询学校的院所信息
	*@author:zyml
	*@date:2017年7月6日上午10:45:33
	*@param strSchoolName 学校名称
	*/
	@ResponseBody
	@RequestMapping("/findSchoolMsg")
	public JsonResult findSchoolMsg(String strSchoolName) {
		JsonResult rs=null;
		 try {
			 rs=new JsonResult();
			 strSchoolName="红星幼儿园";
			 BaseSchoolMsgDTO baseSchoolMsgPo =baseSchoolService.findSchoolMsg(strSchoolName);
			 rs.setObj(baseSchoolMsgPo);
		 } catch (Exception e) {
			 e.printStackTrace();
		}
		 return rs;
	}
	
	
	
	
	
	

}
