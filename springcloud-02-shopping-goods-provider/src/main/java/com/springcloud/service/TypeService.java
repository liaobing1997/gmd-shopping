package com.springcloud.service;

import java.util.List;

import com.springcloud.entity.TypeOne;
import com.springcloud.entity.TypeTwo;

/**
 * 用于定义一级类别与二级类别模块的方法
 * 
 * @author LiaoBing
 *
 */
public interface TypeService {

	public abstract List<TypeOne> selectAllTypeOne();

	/**
	 * 根据一级类别编号查询相应的二级类别信息
	 * 
	 * @param typeOneId 一级类别
	 * @return 成功返回Java.util.List类型的实例，否则返回null
	 */
	public abstract List<TypeTwo> selectTypeTwoByTypeOneId(Integer typeOneId);

	
}
