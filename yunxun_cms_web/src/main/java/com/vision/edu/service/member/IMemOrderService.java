package com.vision.edu.service.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.OrderInfoDTO;
import com.vision.edu.entity.member.MemOrder;

/**
 * <p>
 * 订单信息 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemOrderService extends IService<MemOrder> {
	
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
	List<OrderInfoDTO> findOrderInfo(Pagination page,String vague,Integer orderState,String starteTime,String endTime);
	 /**
     * 
     * @author ChenWenWu
     * @date 2017年8月11日 下午3:00:00
     * @param memOrder  订单实体
     * @return
     */
	Integer addMemOrder(MemOrder memOrder);
}
