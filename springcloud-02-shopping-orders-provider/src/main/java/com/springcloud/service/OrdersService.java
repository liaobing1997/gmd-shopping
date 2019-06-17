package com.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Order;

/**
 * 订单模块模型层接口，用于定义订单模块的方法
 * 
 * @author LiaoBing
 *
 */
public interface OrdersService {

	/**
	 * 查询满足条件的订单信息（分页功能）
	 * 
	 * @param order 查询条件
	 * @return 返回com.github.pagehelper.PageInfo<Order>类型实例
	 */
	public abstract PageInfo<Order> selectOrders(Order order, Integer pageNumber);

	/**
	 * 修改指定编号的订单状态
	 * 
	 * @param order 修改的订单信息
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
