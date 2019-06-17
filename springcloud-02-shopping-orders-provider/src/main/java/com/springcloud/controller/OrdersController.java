package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Order;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

/**
 * 订单模块的控制层
 * 
 * @author LiaoBing
 *
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	/**
	 * 查询满足条件的订单信息
	 * 
	 * @param order      查询条件
	 * @param pageNumber 页数
	 * @return
	 */
	@RequestMapping(value = "/selectOrders")
	public ResultValue selectOrders(Order order, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			// 查询满足条件的商品信息
			PageInfo<Order> pageInfo = this.ordersService.selectOrders(order, pageNumber);
			// 从分页信息中获得商品信息
			List<Order> list = pageInfo.getList();
			// 如果找到了满足条件的商品信息
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("ordersList", list);

				PageUtils pageUtils = new PageUtils(pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				map.put("pageUtils", pageUtils);

				rv.setDataMap(map);

				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("查询失败！");
		return rv;
	}

	/**
	 * 修改指定编号订单的订单状态
	 * 
	 * @param order 修改的订单信息
	 * @return
	 */
	@RequestMapping("/updateOrderStatus")
	public ResultValue updateOrderStatus(Order order) {
		ResultValue rv = new ResultValue();
		try {
			Integer status = this.ordersService.updateOrdersStatus(order);
			if (status > 0) {
				rv.setCode(0);
				rv.setMessage("修改成功！！！");
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("修改失败！！！");
		return rv;
	}

	@RequestMapping(value = "/selectGroup")
	public ResultValue selectGroup(Order order) {
		ResultValue rv = new ResultValue();
		try {
			List<Order> list = this.ordersService.selectGroup(order);
			if(list != null && list.size()>0) {
				rv.setCode(0);
				
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		return rv;
	}
}
