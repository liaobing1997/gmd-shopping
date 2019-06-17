package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.OrderDetalis;

/**
 * 订单明细模块模型层接口，用于定义订单明细模块的方法
 * 
 * @author LiaoBing
 *
 */
public interface OrderDetailsService {

	/**
	 * 查询指定订单编号的订单明细信息（分页功能）
	 * 
	 * @param orderId    订单编号
	 * @param pageNumber 页数
	 * @return 返回com.github.pagehelper.PageInfo<OrderDetalis>类型的实例
	 */
	public abstract PageInfo<OrderDetalis> selectOrderDetailsByOrderId(Integer orderId, Integer pageNumber);

}
