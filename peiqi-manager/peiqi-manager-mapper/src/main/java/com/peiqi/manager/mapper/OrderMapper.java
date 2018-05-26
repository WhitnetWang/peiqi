package com.peiqi.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peiqi.commons.pojo.order.Order;
import com.peiqi.commons.pojo.order.OrderItem;


public interface OrderMapper {

	List<Order> findAllOrder();

	List<Order> findOrderByState(@Param("state") Integer status);

	void updateState(@Param("oid") String oid);

	void saveOrder(Order order);

	void saveOrderItem(OrderItem orderItem);

	Order queryOrderById(String oid);

	void updateOrder(Order order);

}
