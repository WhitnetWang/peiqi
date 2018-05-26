package com.peiqi.manager.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.peiqi.commons.pojo.pruduct.Product;
import com.peiqi.manager.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/findAllProduct.action")
	public String findAllProduct(Integer page,HttpServletRequest request) {
		
		PageInfo<Product> pageInfo =  productService.findAllProduct(page);
		
		request.setAttribute("pageInfo", pageInfo);
		
		return "product/list";
	}
}
