package com.peiqi.sso.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peiqi.commons.interfaces.RpcCategoryService;
import com.peiqi.commons.pojo.category.Category;

@Controller
@RequestMapping("/")
public class PageController {

	@Autowired
	private RpcCategoryService rpcCategoryService;
	
	@RequestMapping("/login.html")
	public String toLoginPage(HttpServletRequest request) {
		List<Category> categories = rpcCategoryService.findAll();
		request.setAttribute("categories", categories);
		return "login";
	}
	
	@RequestMapping("/regist.html")
	public String toRegistPage(HttpServletRequest request) {
		List<Category> categories = rpcCategoryService.findAll();
		request.setAttribute("categories", categories);
		return "regist";
	}
	
}
