/**
 * 
 */
package com.vision.edu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.enums.EnumInfoType;
import com.vision.edu.enums.EnumPlatform;
import com.vision.edu.enums.EnumRangeType;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseSchoolInfoService;
import com.vision.edu.service.base.IBaseSchoolService;

/**
*这里是图片墙的控制器
*@author:zyml
*@date:2017年7月6日下午3:05:20
*/
@Controller
@RequestMapping("/photoWall")
public class PhotoWallController extends BaseController{
	
	@Autowired
	private IBaseSchoolService baseSchoolService;     //注入IBaseSchoolService
	
	@Autowired
	private IBaseSchoolInfoService baseSchoolInfoService;  //注入IBaseSchoolInfoService
	
	/**
	*查询 banner图片墙的基本信息
	*@author:zyml
	*@date:2017年7月6日下午3:06:53
	*@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	*/
	@ResponseBody
	@RequestMapping("/findPhotoAll")
	public JsonResult findPhotoAll(String schoolId,String babyId) {
		JsonResult rs=null;
		if (schoolId!=null && schoolId!="" && babyId!=null && babyId!="") {
			Map<String, Object> map =new HashMap<>();       //定义一个map用来接收
			map.put("qpt", EnumRangeType.QPT.getValue());	//全平台
			map.put("qyx", EnumRangeType.QYX.getValue());   //全院校
			map.put("fzts", EnumRangeType.FZTS.getValue());  //分组推送
			map.put("bn", EnumInfoType.BN.getValue());      //banner
			map.put("schid", schoolId);                  //学校id
			map.put("babyId", babyId);                      //孩子id
			try {
				rs=new JsonResult();
				List<BaseEntity> listPhoto=baseSchoolInfoService.findPhotoAll(map);
				rs.setObj(listPhoto);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			Map<String, Object> map =new HashMap<>();       //定义一个map用来接收
			map.put("qpt", EnumRangeType.QPT.getValue());	//全平台
			map.put("qyx", EnumRangeType.QYX.getValue());   //全院校
			map.put("fzts", EnumRangeType.FZTS.getValue());  //分组推送
			map.put("bn", EnumInfoType.BN.getValue());      //banner
			map.put("schid", schoolId);                  //学校id
			map.put("babyId", babyId);                      //孩子id
			try {
				rs=new JsonResult();
				List<BaseEntity> listPhoto=baseSchoolInfoService.findPhotoAll(map);
				rs.setObj(listPhoto);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	/**
	*根据图片的id查询图片的详细信息
	*@author:zyml
	*@date:2017年7月7日下午3:05:48
	*@param strCode 图片的id
	*/
	@ResponseBody
	@RequestMapping("/findPhotoAllDetail")
	public JsonResult findPhotoAllDetail(HttpServletRequest request) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			String strCode=request.getParameter("strCode");
			if (strCode!=null) {
				BaseEntity listPhotoAllDetail= baseSchoolInfoService.findPhotoAllDetail(strCode);
				rs.setObj(listPhotoAllDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
