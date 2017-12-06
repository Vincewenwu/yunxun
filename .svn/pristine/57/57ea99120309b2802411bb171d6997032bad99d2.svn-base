package com.vision.edu.service.member.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.common.base.OrderUtil;
import com.vision.edu.dto.OrderInfoDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.member.MemComboRecord;
import com.vision.edu.entity.member.MemOrder;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumOrderState;
import com.vision.edu.enums.EnumOrderType;
import com.vision.edu.enums.EnumPaymentType;
import com.vision.edu.mapper.base.BaseBabyMapper;
import com.vision.edu.mapper.member.MemComboRecordMapper;
import com.vision.edu.mapper.member.MemOrderMapper;
import com.vision.edu.service.member.IMemOrderService;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class MemOrderServiceImpl extends ServiceImpl<MemOrderMapper, MemOrder> implements IMemOrderService {

	@Autowired
	private MemOrderMapper memOrderMapper;
	@Autowired
	private MemComboRecordMapper memComboRecordMapper;
	
	@Autowired
	private BaseBabyMapper baseBabyMapper;

	/**
	 * 订单信息
	 * @author jiangwangying
	 * @date 2017年8月10日 下午4:45:09
	 * @param page 分页
	 * @param vague 关键字
	 * @param orderState 订单状态
	 * @param starteTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	public List<OrderInfoDTO> findOrderInfo(Pagination page,String vague,Integer orderState,String starteTime,String endTime){
	
		return memOrderMapper.findOrderInfo(page, vague, orderState, starteTime, endTime);
	}
	/**
	 *
	 * @author ChenWenWu
	 * @date 2017年8月11日 下午3:00:00
	 * @param memOrder  订单实体
	 * @return
	 */
	@Override
	public Integer addMemOrder(MemOrder memOrder) {
		memOrder.setState(EnumOrderState.YZF.getValue());
		memOrder.setCreateTime(new Date());
		memOrder.setPayTime(new Date());
		memOrder.setOrderNum(OrderUtil.getOrderNum());
		memOrder.setOrderType(EnumOrderType.PTFW.getValue());
		memOrder.setPaymentType(EnumPaymentType.XTKT.getValue());
		memOrder.setOrderTime(new Date());
		memOrder.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		Integer j=memOrderMapper.insert(memOrder);
		Integer i =0;
		if(j>0){
			MemComboRecord memComboRecord =new MemComboRecord();
			memComboRecord.setOrderId(memOrder.getId());
			memComboRecord.setUserId(memOrder.getMemberId());
			memComboRecord.setComboId(memOrder.getComboId());
			memComboRecord.setPrice(memOrder.getTotalAmount());
			memComboRecord.setPayTime(new Date());
			memComboRecord.setCreateTime(new Date());
			memComboRecord.setCreateMam(memOrder.getCreateMam());
			memComboRecord.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			memComboRecord.setStatus(EnumOrderState.YZF.getValue());
			i=memComboRecordMapper.insert(memComboRecord);
			BaseBaby baseBaby =new BaseBaby();//只要开通服务了，都改变孩子状态
			baseBaby.setState(0);
			baseBaby.setId(memOrder.getBabyId());
			baseBabyMapper.updateById(baseBaby);
		}else {
			i=0;
		}

		return i;
	}
}
