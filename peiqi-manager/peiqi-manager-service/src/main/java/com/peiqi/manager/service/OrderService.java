package com.peiqi.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peiqi.commons.pojo.order.Order;
import com.peiqi.manager.mapper.OrderMapper;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	public PageInfo<Order> findAllOrder(Integer page) {
		
		PageHelper.startPage(page, 20);
		
		List<Order> list = orderMapper.findAllOrder();
		
		return new PageInfo<>(list);
	}

	public PageInfo<Order> findOrderByState(Integer page, Integer status) {
		
		PageHelper.startPage(page, 20);
		
		List<Order> orders = orderMapper.findOrderByState(status);
		
		return new PageInfo<>(orders);
	}
	
	public void updateState(String oid) {
		orderMapper.updateState(oid);
	}


}
