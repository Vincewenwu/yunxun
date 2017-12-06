package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.OrderInfoDTO;
import com.vision.edu.entity.member.MemOrder;

/**
 * <p>
  * 订单信息 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemOrderMapper extends BaseMapper<MemOrder> {

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
	List<OrderInfoDTO> findOrderInfo(Pagination page,@Param("vague") String vague,@Param("orderState") Integer orderState,@Param("starteTime") String starteTime,@Param("endTime") String endTime);
}