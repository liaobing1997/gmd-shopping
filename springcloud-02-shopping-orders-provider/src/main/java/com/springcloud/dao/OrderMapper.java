package com.springcloud.dao;

import com.springcloud.entity.Order;
import java.util.List;

public interface OrderMapper {
	int deleteByPrimaryKey(Integer orderId);

	int insert(Order record);

	Order selectByPrimaryKey(Integer orderId);

	List<Order> selectAll();

	int updateByPrimaryKey(Order record);

	/**
	 * 查询ORDER表中满足条件的订单信息
	 * 
	 * @param orders 查询条件
	 * @return 成功返回java.util.List类型的实例，否则返回null
	 */
	public abstract List<Order> selectOrders(Order orders);

	/**
	 * 修改ORDER表中指定ORDER_ID的订单状态
	 * 
	 * @param order 修改订单的信息
	 * @return 成功返回大于0的整数，否则返回小于0的整数
	 */
	public abstract Integer updateOrdersStatus(Order order);

	/**
	 * 查询指定日期范围内的销售额
	 * 
	 * @param order 查询条件
	 * @return 成功返回java.util.List类型的实例，否则返回null
	 */
	public abstract List<Order> selectGroup(Order order);
}