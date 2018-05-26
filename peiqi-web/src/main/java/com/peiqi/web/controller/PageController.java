package com.peiqi.web.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peiqi.commons.interfaces.RpcCategoryService;
import com.peiqi.commons.interfaces.RpcProductService;
import com.peiqi.commons.pojo.category.Category;
import com.peiqi.commons.pojo.pruduct.Product;
import com.peiqi.commons.utils.UUIDUtils;

@Controller
@RequestMapping("/")
public class PageController {
	
	@Autowired
	private RpcCategoryService rpcCategoryService;
	
	@Autowired
	private RpcProductService rpcProductService;
	
	@RequestMapping("/index.html")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		
		List<Category> categories = rpcCategoryService.findAll();
		request.setAttribute("categories", categories);
		
		List<Product> hList = rpcProductService.findHotAll();
		request.setAttribute("hList", hList);
		
		List<Product> nList = rpcProductService.findNewAll();
		request.setAttribute("nList", nList);
		
		Cookie[] cookies = request.getCookies();
		
		boolean flag = false;
		
		if(cookies != null && cookies.length > 0) {
			
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("PEIQI_CART_TOKEN")) {
					flag = true;
				}
			}
			
			if(!flag) {
				
				Cookie cookie = new Cookie("PEIQI_CART_TOKEN", "CART_" + UUIDUtils.getUUID());

				cookie.setMaxAge(60 * 30);
				
				cookie.setDomain("peiqi.com");
					
				response.addCookie(cookie);
			}
		}else {
			
			Cookie cookie = new Cookie("PEIQI_CART_TOKEN", "CART_" + UUIDUtils.getUUID());

			cookie.setMaxAge(60 * 30);
			
			cookie.setDomain("peiqi.com");
				
			response.addCookie(cookie);
		}
		
		return "index";
	}
	
}
