package com.peiqi.manager.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peiqi.commons.interfaces.RpcCategoryService;
import com.peiqi.commons.interfaces.RpcOrderService;
import com.peiqi.commons.pojo.order.Order;
import com.peiqi.commons.pojo.order.OrderItem;
import com.peiqi.manager.mapper.OrderMapper;

@Service("rpcOrderServiceImpl")
public class RpcOrderServiceImpl implements RpcOrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public void saveOrder(Order order) {
		
		System.out.println(order);
		
		orderMapper.saveOrder(order);
		
		List<OrderItem> orderItems = order.getOrderItems();
		
		for(OrderItem orderItem : orderItems) {
			System.out.println(orderItem);
			orderMapper.saveOrderItem(orderItem);
		}
		
	}

	@Override
	public Order queryOrderById(String oid) {
		return orderMapper.queryOrderById(oid);
	}

	@Override
	public void updateOrder(Order order) {
		orderMapper.updateOrder(order);
	}

}
