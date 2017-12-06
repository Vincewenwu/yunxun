package com.vision.edu.web.controller.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.dto.MemSchoolRecipeDetailDTO;
import com.vision.edu.dto.SysRecipeBankDTO;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.entity.base.BaseRecipeBank;
import com.vision.edu.entity.member.MemSchoolRecipe;
import com.vision.edu.entity.member.MemSchoolRecipeDetail;
import com.vision.edu.entity.system.SysRecipeBank;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.framework.util.UploadUtil;
import com.vision.edu.mapper.system.SysRecipeBankMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseRecipeBankService;
import com.vision.edu.service.member.IMemSchoolRecipeDetailService;
import com.vision.edu.service.member.IMemSchoolRecipeService;
import com.vision.edu.service.system.ISysRecipeBankService;

@Controller
@RequestMapping("/sysrecipebank")
public class RecipeBankController extends BaseController {

	@Autowired
	private ISysRecipeBankService sysRecipeBankService;
	@Autowired
	private IBaseRecipeBankService baseRecipeBankService;
	@Autowired
	private IMemSchoolRecipeDetailService memSchoolRecipeDetailService;
	@Autowired
	private IMemSchoolRecipeService memSchoolRecipeService;

	@Autowired
	private SysRecipeBankMapper sysRecipeBankMapper;

	Map<String, String> uploadImg;

	/**
	 * 上传图片
	 * @author jiangwangying
	 * @date 2017年7月11日 上午11:06:37
	 * @param baseSchool
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadLogo")
	public void uploadLogo() {
		uploadImg = new HashMap<String, String>();
		uploadImg = UploadUtil.uploadImage(super.getRequest(), "sysrecipebank");
	}

	/**
	 * 查询营养餐谱
	 * @author ChenWenWu
	 * @date 2017年7月10日 上午11:40:22
	 */
	public void findSysRecipeBankDTO() {
		Page<SysRecipeBankDTO> page = new Page<SysRecipeBankDTO>(1, 10);
		String dishNmae = "菜名1";
		String baseSchoolName = "";
		List<SysRecipeBankDTO> sysRecipeBankDTO = sysRecipeBankService.findSysRecipeBankDTO(page, dishNmae, baseSchoolName);
		System.out.println(sysRecipeBankDTO.get(0).getName());
	}

	/**
	 * 查询菜谱表
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午10:00:31
	 * @param schoolId
	 */

	@ResponseBody
	@RequestMapping("/findBaseRecipeBank")
	public JsonResult findBaseRecipeBank(Integer startPage, Integer pageSise, BaseRecipeBank baseRecipeBank) {
		SysUserDTO sysuser = super.getUserInfo();
		 if(sysuser.getSchoolId()==null){
				baseRecipeBank.setSchoolId("");
   	  }else{
   		baseRecipeBank.setSchoolId(sysuser.getSchoolId());
   	  }
		Page<BaseRecipeBank> page = new Page<BaseRecipeBank>(startPage, pageSise);
		List<BaseRecipeBank> sysRecipeBankDTO = baseRecipeBankService.findBaseRecipeBank(page, baseRecipeBank);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("sysRecipeBankDTO", sysRecipeBankDTO);
		JsonResult re = new JsonResult();
		re.setObj(map);
		re.setMsg("ok");
		return re;
	}

	/**
	 * 新增菜谱加平台菜谱
	 * @author ChenWenWu
	 * @date 2017年7月25日 下午3:55:13
	 * @param baseRecipeBank
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addSysRecipeBank")
	public JsonResult addSysRecipeBank(BaseRecipeBank baseRecipeBank, String pingtai, String imageUrl) {
		SysUserDTO sysuser = super.getUserInfo();
//		baseRecipeBank.setSchoolId(sysuser.getSchoolId());
		String to = (String) super.getRequest().getSession().getServletContext().getAttribute("imgService");
		if (imageUrl.contains(to)) { // 判断是否包含上传路径，
//	    		   http://yunxunimg.xuechenedu.com//upload/20170724233929.jpg
			String jieguo = imageUrl.substring(imageUrl.indexOf(to) + to.length());//截取字符串
			baseRecipeBank.setCoverImages(jieguo);
		} else {
			baseRecipeBank.setCoverImages(uploadImg.get("sysrecipebankImg"));
		}
		uploadImg = null;
//		baseRecipeBank.setSchoolId(sysuser.getSchoolId());
//		baseRecipeBank.setCoverImages(uploadImg.get("sysrecipebankImg"));
		String num1 = baseRecipeBankService.addSysRecipeBank(baseRecipeBank, pingtai);
		JsonResult re = new JsonResult();
		re.setObj(num1);
		re.setMsg("ok");
		return re;
	}

	/**
	 * 新增菜谱加平台菜谱
	 * @author ChenWenWu
	 * @date 2017年7月25日 下午3:55:13
	 * @param baseRecipeBank
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findOneBaseRecipeBank")
	public JsonResult findOneBaseRecipeBank(BaseRecipeBank baseRecipeBank) {
		SysUserDTO sysuser = super.getUserInfo();
		if (sysuser.getSchoolId()==null) {
			baseRecipeBank.setSchoolId("");
		}else{
			baseRecipeBank.setSchoolId(sysuser.getSchoolId());
		}
		BaseRecipeBank baseRecipeBank1 = baseRecipeBankService.findOneBaseRecipeBank(baseRecipeBank);
		JsonResult re = new JsonResult();
		re.setObj(baseRecipeBank1);
		re.setMsg("ok");
		return re;
	}

	/**
	 * 修改院校菜谱库
	 * @author ChenWenWu
	 * @date 2017年7月25日 下午4:51:33
	 * @param baseRecipeBank
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editSysRecipeBank")
	public JsonResult editSysRecipeBank(BaseRecipeBank baseRecipeBank, String brbid, String imageUrl) {

		SysUserDTO sysuser = super.getUserInfo();
		baseRecipeBank.setSchoolId(sysuser.getSchoolId());
		String to = (String) super.getRequest().getSession().getServletContext().getAttribute("imgService");
		if (imageUrl.contains(to)) { // 判断是否包含上传路径，
//	    		   http://yunxunimg.xuechenedu.com//upload/20170724233929.jpg
			String jieguo = imageUrl.substring(imageUrl.indexOf(to) + to.length());//截取字符串
			baseRecipeBank.setCoverImages(jieguo);
		} else {
			baseRecipeBank.setCoverImages(uploadImg.get("sysrecipebankImg"));
		}

		baseRecipeBank.setUpdateTime(new Date());
		baseRecipeBank.setId(brbid);
		boolean num1 = baseRecipeBankService.updateById(baseRecipeBank);
		JsonResult re = new JsonResult();
		if (num1) {
			re.setObj("修改成功");
			re.setMsg("ok");
		} else {
			re.setObj("修改失败");
			re.setMsg("false");
		}
		return re;
	}

	/**
	 * 删除菜谱
	 * @author ChenWenWu
	 * @date 2017年7月25日 下午5:25:04
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delSysRecipeBank")
	public JsonResult delSysRecipeBank(String ids) {
		JsonResult re = new JsonResult();
		String[] id = ids.split(",");
		String[] aa = new String[id.length];
		BaseRecipeBank baseRecipeBank = new BaseRecipeBank();
		baseRecipeBank.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		Integer num = 0;
		for (int i = 0; i < id.length; i++) {
			aa[i] = id[i];
		}
		for (String lj : aa) {
			baseRecipeBank.setId(lj);
			baseRecipeBankService.updateById(baseRecipeBank);
			num++;
		}
		if (num > 0) {
			re.setObj(num + "条删除成功");
			re.setMsg("ok");
		} else {
			re.setObj("删除失败");
			re.setMsg("false");
		}
		return re;
	}

	/**
	 * 发布菜谱，顺便发布动态
	 * @author ChenWenWu
	 * @date 2017年8月4日 下午5:46:02
	 * @param memSchoolRecipeDetail
	 * @param PublishTime
	 * @param weekly
	 * @param xycpName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addMemSchoolRecipe")
	public JsonResult addMemSchoolRecipe(MemSchoolRecipeDetail memSchoolRecipeDetail, String PublishTime, Integer weekly, String xycpName) {
		SysUserDTO sysuser = super.getUserInfo();
		memSchoolRecipeDetail.setCreateMam(sysuser.getUsername());
		Integer num1 = baseRecipeBankService.addMemSchoolRecipe(memSchoolRecipeDetail, sysuser.getSchoolId(), sysuser.getId(), PublishTime, weekly, xycpName);
		JsonResult re = new JsonResult();
		if (num1 > 0) {
			re.setObj("食谱发布成功");
			re.setMsg("ok");
		} else {
			re.setObj("新增失败");
			re.setMsg("false");
		}
		return re;
	}

	/**
	 * 根据年份月份查询周谱
	 * @author ChenWenWu
	 * @date 2017年7月31日 上午11:39:06
	 * @param page
	 * @param memSchoolRecipeDetailDTO 条件实体
	 * @param year 年份
	 * @param month 月份
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findMemSchoolRecipeDetails")
	public JsonResult findMemSchoolRecipeDetails(Integer startPage, Integer pageSise, MemSchoolRecipeDetailDTO memSchoolRecipeDetailDTO, String year, String month) {
		SysUserDTO sysuser = super.getUserInfo();
		 if(sysuser.getSchoolId()==null){
				memSchoolRecipeDetailDTO.setShoolID("");
   	  }else{
   		memSchoolRecipeDetailDTO.setShoolID(sysuser.getSchoolId());
   	  }
	
		Page<MemSchoolRecipeDetailDTO> page = new Page<MemSchoolRecipeDetailDTO>(startPage, pageSise);
		Integer M = Integer.valueOf(month) + 1;
		String yue = "";
		if (month.length() == 1) {
			yue = 0 + Integer.toString(M);
		} else {
			yue = Integer.toString(M);
		}
		List<MemSchoolRecipeDetailDTO> memSchoolRecipeDetailList = memSchoolRecipeDetailService.findMemSchoolRecipeDetails(page, memSchoolRecipeDetailDTO, year, yue);
		int j = memSchoolRecipeDetailList.size();
		for (int i = 0; i < j; i++) {
			memSchoolRecipeDetailList.get(i).setPublishTime(memSchoolRecipeDetailList.get(i).getPublishTime().substring(0, 10));
		}

	     Map<String ,Object> map=new HashMap<String ,Object>();
        map.put("page", page);
        map.put("memSchoolRecipeDetailList", memSchoolRecipeDetailList);
        JsonResult re=new JsonResult();
          re.setObj(map);
          re.setMsg("ok");
          return re; 
	}

	/**
	 * 根据年份月查询周次
	 * @author ChenWenWu
	 * @date 2017年7月31日 上午11:40:32
	 * @param page
	 * @param memSchoolRecipeDetailDTO
	 * @param year 年分
	 * @param month 月份
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findzhouandyears")
	public JsonResult findzhouandyears(Integer startPage, Integer pageSise, MemSchoolRecipeDetailDTO memSchoolRecipeDetailDTO, String year, String month) {
		SysUserDTO sysuser = super.getUserInfo();
		Page<MemSchoolRecipe> page = new Page<MemSchoolRecipe>(startPage, pageSise);
		 if(sysuser.getSchoolId()==null){
				memSchoolRecipeDetailDTO.setShoolID("");
   	  }else{
   		memSchoolRecipeDetailDTO.setShoolID(sysuser.getSchoolId());
   	  }
	
		Integer M = Integer.valueOf(month) + 1;

		String yue = "";
		if (month.length() == 1) {
			yue = 0 + Integer.toString(M);
		} else {
			yue = Integer.toString(M);
		}
		List<MemSchoolRecipeDetailDTO> memSchoolRecipe = memSchoolRecipeDetailService.findzhouandyears(page, memSchoolRecipeDetailDTO, year, yue);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("memSchoolRecipe", memSchoolRecipe);
		JsonResult re = new JsonResult();
		re.setObj(map);
		re.setMsg("ok");
		return re;
	}

	/**
	 * 删除周谱
	 * @author ChenWenWu
	 * @date 2017年7月31日 上午11:40:32
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delMemSchoolRecipeDetail")
	public JsonResult delMemSchoolRecipeDetail(String ids) {
		SysUserDTO sysuser = super.getUserInfo();
		Integer num1 = memSchoolRecipeDetailService.delMemSchoolRecipeDetail(ids);
		JsonResult re = new JsonResult();
		if (num1 > 0) {
			re.setObj("删除" + num1 + "条数据成功");
			re.setMsg("ok");
		} else {
			re.setObj("新增失败");
			re.setMsg("false");
		}
		return re;
	}

	/**
	 * 查询平台食谱
	 * @author ChenWenWu
	 * @date 2017年7月31日 上午11:40:32
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findsysRecipeBankName")
	public JsonResult findsysRecipeBankName(String ids) {
		JsonResult jsonResult = new JsonResult();
		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		String sid="";
		 if (sysUserDTO.getSchoolId()==null){
			 sid="";
           }else {
        	   sid= sysUserDTO.getSchoolId();
           }
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		EntityWrapper<SysRecipeBank> ew = new EntityWrapper<SysRecipeBank>();
		ew.where("delete_flag = {0}", EnumDeleteFlag.WSC.getValue());
		ew.where("school_id != {0}", sid);
		ew.setSqlSelect("id,name");
		List<SysRecipeBank> list = sysRecipeBankMapper.selectList(ew);
		if (list.size() > 0) {
			jsonResult.setSuccess(true);
			jsonResult.setObj(list);
		} else {
			jsonResult.setSuccess(false);
			return jsonResult;
		}
		return jsonResult;
	}

	/**
	 * 查询单条平台食谱绑定值
	 * @author ChenWenWu
	 * @date 2017年7月31日 上午11:40:32
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findOneSysRecipeBank")
	public JsonResult findOneSysRecipeBank(String id) {
		JsonResult jsonResult = new JsonResult();
		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		SysRecipeBank list = baseRecipeBankService.findOneSysRecipeBank(id);
		if (list != null) {
			jsonResult.setSuccess(true);
			jsonResult.setObj(list);
		} else {
			jsonResult.setSuccess(false);
			return jsonResult;
		}
		return jsonResult;
	}

}
