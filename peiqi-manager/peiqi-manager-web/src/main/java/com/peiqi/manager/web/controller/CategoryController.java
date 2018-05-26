package com.peiqi.manager.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peiqi.commons.pojo.category.Category;
import com.peiqi.manager.service.CategoryService;

@RequestMapping("/category")
@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 查询所有的一级分类
	 * @param request
	 * @return
	 */
	@RequestMapping("/findAllCategory.action")
	public String findAllCategory(HttpServletRequest request) {
		List<Category> categories = categoryService.findAllCategory();
		request.setAttribute("categories", categories);
		return "category/list";
	}
	
	/**
	 * 编辑一级分类
	 */
	@RequestMapping("/updateCategory.action")
	public void updateCategory(Category category,HttpServletResponse response) {
		categoryService.updateCategory(category);
		try {
			response.sendRedirect("/category/findAllCategory.action");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 删除一级分类
	 */
	@RequestMapping("/deleteCategory.action")
	public void deleteCategory(Integer cid,HttpServletResponse response) {
		
		categoryService.deleteCategory(cid);
		
		try {
			response.sendRedirect("/category/findAllCategory.action");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 添加一级分类
	 */
	
	@RequestMapping("addCategory.action")
	public void addCategory(String cname,HttpServletResponse response) {
		categoryService.addCategory(cname);
		
		try {
			response.sendRedirect("/category/findAllCategory.action");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
