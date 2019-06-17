package com.springcloud.dao;

import com.springcloud.entity.OrderDetalis;
import java.util.List;

public interface OrderDetalisMapper {
	int deleteByPrimaryKey(Integer orderDetailId);

	int insert(OrderDetalis record);

	OrderDetalis selectByPrimaryKey(Integer orderDetailId);

	List<OrderDetalis> selectAll();

	int updateByPrimaryKey(OrderDetalis record);

	/**
	 * 查询指定订单编号的订单明细信息
	 * 
	 * @param orderId 订单编号
	 * @return 成功返回java.util.List类型的实例，否则返回null
	 */
	public abstract List<OrderDetalis> selectByOrderId(Integer orderId);
}