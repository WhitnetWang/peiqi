package com.peiqi.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peiqi.commons.pojo.category.Category;
import com.peiqi.manager.mapper.CategoryMapper;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<Category> findAllCategory() {
		return categoryMapper.findAllCategory();
	}

	public Category findCategoryByCid(Integer cid) {
		return categoryMapper.findCategoryByCid(cid);
	}

	public void updateCategory(Category category) {
		categoryMapper.updateCategory(category);
	}

	public void deleteCategory(Integer cid) {
		categoryMapper.deleteCategory(cid);
	}

	public void addCategory(String cname) {
		categoryMapper.addCategory(cname);
	}

}
