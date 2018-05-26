package com.peiqi.manager.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.peiqi.commons.pojo.category.Category;
import com.peiqi.commons.pojo.category.CategorySecond;
import com.peiqi.manager.service.CategoryService;
import com.peiqi.manager.service.SecondCategoryService;

@Controller
@RequestMapping("/secondCategory")
public class SecondCategoryController {
	
	@Autowired
	private SecondCategoryService secondCategoryService;

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/findAllSecondCategory.action")
	public String findAllSecondCategory(Integer page, HttpServletRequest request) {
		
		PageInfo<CategorySecond> pageInfo = secondCategoryService.findAllSecondCategory(page);
		
		request.setAttribute("pageInfo", pageInfo);
		
		return "categorysecond/list";
	}
	
	@RequestMapping("/toEditPage.action")
	public String toEditPage(Integer csid, HttpServletRequest request) {
		CategorySecond categorySecond = secondCategoryService.findSecondCategoryByCsid(csid);
		
		List<Category> list = categoryService.findAllCategory();
		
		System.out.println(categorySecond);
		
		System.out.println(list);
		
		request.setAttribute("categorysecond",categorySecond);
		
		request.setAttribute("categories", list);
		
		return "categorysecond/edit";
	}
	
	@RequestMapping("/updateSecondCategory.action")
	public void updateSecondCategory(CategorySecond categorySecond,HttpServletRequest request,HttpServletResponse response) {
		secondCategoryService.updateSecondCategory(categorySecond);
		try {
			request.getRequestDispatcher("/secondCategory/findAllSecondCategory.action?page=1").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("deleteSecondCategory.action")
	public void deleteSecondCategory(Integer csid,HttpServletResponse response) throws IOException {
		secondCategoryService.deleteSecondCategory(csid);
		response.sendRedirect("/secondCategory/findAllSecondCategory.action?page=1");
	}
}
