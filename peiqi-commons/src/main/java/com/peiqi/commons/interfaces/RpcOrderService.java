package com.peiqi.commons.interfaces;

import com.peiqi.commons.pojo.order.Order;

public interface RpcOrderService {

	void saveOrder(Order order);

	Order queryOrderById(String oid);

	void updateOrder(Order order);
	
}
