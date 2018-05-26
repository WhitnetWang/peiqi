package com.peiqi.manager.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.peiqi.commons.pojo.order.Order;
import com.peiqi.manager.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/findAllOrder.action")
	public String findAllOrder(Integer page, HttpServletRequest request) {
		
		PageInfo<Order> pageInfo = orderService.findAllOrder(page);
		
		request.setAttribute("pageInfo", pageInfo);
		
		return "order/list";
	}
	
	@RequestMapping("/findOrderByState.action")
	public String findOrderByState(HttpServletRequest request, Integer page, Integer status) {
		
		if(page == null) {
			page = 1;
		}
		
		PageInfo<Order> pageInfo = orderService.findOrderByState(page,status);
		
		request.setAttribute("pageInfo", pageInfo);
		
		return "order/list";
	}
	
	@RequestMapping("updateState.action")
	public void updateState(String oid, HttpServletResponse response) {
		
		orderService.updateState(oid);
		
		try {
			response.sendRedirect("/order/findOrderByState.action?state=3");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
