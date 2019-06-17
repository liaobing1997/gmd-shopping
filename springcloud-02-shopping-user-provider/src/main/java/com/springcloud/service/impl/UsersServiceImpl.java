package com.springcloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.repository.UsersRepository;
import com.springcloud.service.UsersService;

/**
 * 模型层的实现类：实现用户模块的方法
 * @author LiaoBing
 *
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public Users login(Integer userId, String userPsw, Integer permissionId) {
		return this.usersRepository.login(userId, userPsw, permissionId);
	}

	@Transactional //表示这个方法需要支持事务
	@Override
	public Users insert(Users users) {
		return this.usersRepository.save(users);
	}

	@Override
	public Page<Users> select(Users users, Integer pageNumber) {
		//根据查询的条件来创建动态的条件
		@SuppressWarnings("serial")
		Specification<Users> specification = new Specification<Users>() {

			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				//创建一个List集合，用于保存所有的where条件
				List<Predicate> whereList = new ArrayList<>();
				
				//根据Users实体类中的查询数据，动态创建查询条件
				if(users.getUserName()!=null && !users.getUserName().trim().equals("")) {
					whereList.add(criteriaBuilder.like(root.get("userName"), "%" + users.getUserName() + "%"));
				}
				if(users.getUserStatus()!=-1) {
					whereList.add(criteriaBuilder.equal(root.get("userStatus"), users.getUserStatus()));
				}
				
				//将所有的条件以and关系连接在一起，并返回
				return criteriaBuilder.and(whereList.toArray(new Predicate[whereList.size()]));
			}
		};
		//创建Jpa的分页信息
		PageRequest of = PageRequest.of(pageNumber, PageUtils.PAGE_ROW_COUNT);
		return this.usersRepository.findAll(specification, of);
	}

	@Transactional
	@Override
	public Integer updataStatus(Integer userId, Integer userStatus) {
		return this.usersRepository.updateStatus(userId, userStatus);
	}

	@Override
	public Users selectById(Integer userId) {
		return this.usersRepository.findById(userId).get();
	}

	@Transactional
	@Override
	public Integer update(Users users) {
		return this.usersRepository.update(users);
	}

	@Transactional
	@Override
	public Integer updateMessage(Users users) {
		if(users.getUserImage()!=null && !users.getUserImage().trim().equals("")) {
			return this.usersRepository.updateImage(users);
		}
		if(users.getUserPsw()!=null && !users.getUserPsw().trim().equals("")) {
			return this.usersRepository.updatePsw(users);
		}
		if(users.getUserName()!=null && !users.getUserName().trim().equals("")) {
			return this.usersRepository.updateName(users);
		}
		return 0;
	}

}
