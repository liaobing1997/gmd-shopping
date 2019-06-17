package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单明细表OrderDetalis对应的实体类：用来保存一行订单明细的信息
 * 
 * @author LiaoBing
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetalis implements java.io.Serializable {

	private static final long serialVersionUID = -5826513012388007767L;

	/**
	 * 订单明细编号
	 */
	private Integer orderDetailId;

	/**
	 * 订单编号
	 */
	private Integer orderId;

	/**
	 * 商品编号
	 */
	private Integer goodsId;

	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * 商品成交价
	 */
	private Double goodsFinalPrice;

	/**
	 * 成交数量
	 */
	private Integer goodsFinalNum;

}