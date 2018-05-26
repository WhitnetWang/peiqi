package com.peiqi.item.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.peiqi.commons.pojo.category.Category;
import com.peiqi.commons.pojo.pruduct.Product;
import com.peiqi.item.service.CategoryService;
import com.peiqi.item.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/findProductByCid.action")
	public String findProductByCid(Integer cid,Integer page,HttpServletRequest request) {
		
		PageInfo<Product> pageInfo = productService.findProductByCid(cid,page);
		
		List<Category> categories = categoryService.findAll();
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("categories", categories);
		request.setAttribute("cid", cid);
		
		return "productList";
	}
	
	@RequestMapping("/findProductByCsid.action")
	public String findProductByCsid(Integer csid,Integer page,HttpServletRequest request) {
		
		PageInfo<Product> pageInfo = productService.findProductByCsid(csid,page);
		
		List<Category> categories = categoryService.findAll();
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("categories", categories);
		request.setAttribute("csid", csid);
		
		return "productList";
	}
	
	@RequestMapping("/findProductByPid.action")
	public String findProductByPid(Integer pid,HttpServletRequest request) {
		List<Category> categories = categoryService.findAll();
		request.setAttribute("categories", categories);
		
		Product product = productService.findProductByPid(pid);
		
		request.setAttribute("product", product);
		
		return "product";
	}
	
}
