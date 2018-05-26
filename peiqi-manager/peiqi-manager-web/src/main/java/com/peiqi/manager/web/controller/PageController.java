package com.peiqi.manager.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peiqi.commons.pojo.category.Category;
import com.peiqi.manager.service.CategoryService;

@RequestMapping("/")
@Controller
public class PageController {
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 转发到主页面
	 * @return
	 */
	@RequestMapping("/index.html")
	public String index() {
		return "home";
	}
	
	/**
	 * 转发到顶部页面
	 * @return
	 */
	@RequestMapping("/top.html")
	public String top() {
		return "top";
	}
	
	/**
	 * 转发到左部菜单页面
	 * @return
	 */
	@RequestMapping("/left.html")
	public String left() {
		return "left";
	}
	
	/**
	 * 转发到欢迎页面
	 * @return
	 */
	@RequestMapping("/welcome.html")
	public String welcome() {
		return "welcome";
	}
	
	/**
	 * 转发到底部页面
	 * @return
	 */
	@RequestMapping("/bottom.html")
	public String bottom() {
		return "bottom";
	}
	
	@RequestMapping("/category/edit.html")
	public String toCategoryEditPage(Integer cid,HttpServletRequest request) {
		Category category = categoryService.findCategoryByCid(cid);
		request.setAttribute("category", category);
		return "category/edit";
	}
	
	@RequestMapping("/category/add.html")
	public String toAddPage() {
		return "category/add";
	}
	
}
