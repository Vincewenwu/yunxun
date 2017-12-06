package com.vision.edu.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.dto.OrderInfoDTO;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.entity.base.BaseClass;
import com.vision.edu.entity.member.MemOrder;
import com.vision.edu.enums.EnumOrderState;
import com.vision.edu.enums.EnumPaymentType;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.member.IMemOrderService;

/**
 * 用户订单信息
 * @author jiangwangying
 * @date 2017年8月1日 下午11:22:12
 * @version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{

	@Autowired
	private IMemOrderService memOrderService;
	
	/**
	 * 订单信息
	 * @author jiangwangying
	 * @date 2017年8月10日 下午16:46:06
	 * @param page 分页
	 * @param schoolName 园校名称
	 * @param orderType 订单类型
	 * @param starteTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findOrderInfo")
	public JsonResult findOrderInfo(Integer startPage, Integer pageSize,String vague,Integer orderState,String starteTime,String endTime){

		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		Page<BaseClass> page = new Page<BaseClass>(startPage, pageSize);
		List<OrderInfoDTO> list = memOrderService.findOrderInfo(page, vague, orderState, starteTime, endTime);
		if (list.size() > 0) {
			jsonObject.put("total", page.getTotal());
			jsonObject.put("list", list);
			jsonResult.setSuccess(true);
			jsonResult.setObj(jsonObject);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("没有符合条件的数据");
		}
		return jsonResult;
	}
	
	 /**
     * 
     * @author ChenWenWu
     * @date 2017年8月11日 下午3:00:00
     * @param memOrder  订单实体
     * @return
     */
	@ResponseBody
	@RequestMapping("/addMemOrder")
	public JsonResult addMemOrder(MemOrder memOrder) {
		SysUserDTO sysuser =super.getUserInfo();
		memOrder.setCreateMam(sysuser.getUsername());
	Integer num=memOrderService.addMemOrder(memOrder);
	  JsonResult re=new JsonResult();
	   if(num>0){
       	  re.setObj("新增成功");
             re.setMsg("ok");
         }else{
       	  re.setObj("新增失败");
             re.setMsg("false");
         }
      return re; 
		
	}
	 /**
     * 
     * @author ChenWenWu
     * @date 2017年8月11日 下午3:00:00
     * @param memOrder  订单实体
     * @return
     */
	@ResponseBody
	@RequestMapping("/findMemOrderBymenIDANDComID")
	public JsonResult findMemOrderBymenIDANDComID(MemOrder memOrder) {
		EntityWrapper<MemOrder> ew=new EntityWrapper<MemOrder>();
		System.out.println(memOrder.getMemberId());
		System.out.println(memOrder.getComboId());
		ew.setSqlSelect("id");
		ew.where("member_id = {0}", memOrder.getMemberId());
		ew.where("combo_id = {0}", memOrder.getComboId());
		JsonResult re=new JsonResult();
	List<MemOrder> memOrderlist=memOrderService.selectList(ew);
	   if(!memOrderlist.isEmpty()){
       	  re.setObj(true);
             re.setMsg("ok");
         }else{
       	  re.setObj(false);
             re.setMsg("false");
         }
      return re; 
		
	}
}
