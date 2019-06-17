package com.springcloud.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单表ORDER对应的实体类：用来保存一行订单的信息
 * 
 * @author LiaoBing
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements java.io.Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 2788831316078458520L;

	/**
	 * 订单编号
	 */
	private Integer orderId;

	/**
	 * 当前订单对应的用户信息
	 */
	private Users user;

	/**
	 * 收货人姓名
	 */
	private String receiverName;

	/**
	 * 收货人电话
	 */
	private String receiverTel;

	/**
	 * 收获地址
	 */
	private String receiverAddr;

	/**
	 * 订单时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderTime;

	/**
	 * 订单总额
	 */
	private Double orderTotal;

	/**
	 * 订单状态
	 */
	private Integer orderStatus;
	
	/**
	 * 订单起始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDateMin;
	
	/**
	 * 订单终止时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDateMax;
	
	/**
	 * 查询条件：起始年月
	 */
	private String startMonth;

	/**
	 * 查询条件：终止年月
	 */
	private String endtMonth;
	
	/**
	 * 统计结果的年月
	 */
	private String orderMonth;
	
	/**
	 * 统计结果的销售额
	 */
	private Double orderPrice;

}