package com.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.dao.OrderMapper;
import com.springcloud.entity.Order;
import com.springcloud.service.OrdersService;

/**
 * 订单模块模型层的实现类，用于实现订单模块的方法
 * 
 * @author LiaoBing
 *
 */
@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public PageInfo<Order> selectOrders(Order order,Integer pageNumber) {
		if(order.getUser() != null) {
			//在用户名称的两端加%%
			order.getUser().setUserName("%" + order.getUser().getUserName() + "%");
		}
		//设置分页信息
		PageHelper.startPage(pageNumber+1,PageUtils.PAGE_ROW_COUNT);
		//查询满足条件的商品信息
		List<Order> list = this.orderMapper.selectOrders(order);
		return new PageInfo<>(list);
	}

	@Transactional
	@Override
	public Integer updateOrdersStatus(Order order) {
		return this.orderMapper.updateOrdersStatus(order);
	}

	@Override
	public List<Order> selectGroup(Order order) {
		return this.orderMapper.selectGroup(order);
	}

	

}
