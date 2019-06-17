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
import com.springcloud.entity.OrderDetalis;
import com.springcloud.service.OrderDetailsService;
import com.springcloud.vo.ResultValue;

/**
 * 订单明细模块的控制层
 * 
 * @author LiaoBing
 *
 */
@RestController
@RequestMapping("orderDetails")
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderDetailsService;

	/**
	 * 查询指定订单编号的订单明细信息
	 * 
	 * @param orderId    查询条件
	 * @param pageNumber 页数
	 * @return
	 */
	@RequestMapping(value = "/selectByOrderId")
	public ResultValue selectByOrderId(@RequestParam("orderId") Integer orderId,
			@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			// 查询指定订单编号的订单明细信息
			PageInfo<OrderDetalis> info = this.orderDetailsService.selectOrderDetailsByOrderId(orderId, pageNumber);
			List<OrderDetalis> list = info.getList();
			// 如果找到
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>();
				map.put("orderDetailsList", list);

				PageUtils pageUtils = new PageUtils(5,info.getPages() * 5);
				pageUtils.setPageNumber(pageNumber);
				map.put("pageUtils", pageUtils);

				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("查询失败！！！");
		return rv;
	}

}
