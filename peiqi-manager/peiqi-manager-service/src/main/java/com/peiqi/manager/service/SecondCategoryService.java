package com.peiqi.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peiqi.commons.pojo.category.CategorySecond;
import com.peiqi.manager.mapper.SecondCategoryMapper;

@Service
public class SecondCategoryService {
	
	@Autowired
	private SecondCategoryMapper secondCategoryMapper;
	
	public PageInfo<CategorySecond> findAllSecondCategory(Integer page) {
		
		PageHelper.startPage(page, 10);
		
		List<CategorySecond> categorySeconds = secondCategoryMapper.findAllSecondCategory();
		
		return new PageInfo<>(categorySeconds);
	}

	public CategorySecond findSecondCategoryByCsid(Integer csid) {
		return secondCategoryMapper.findSecondCategoryByCsid(csid);
	}

	public void updateSecondCategory(CategorySecond categorySecond) {
		secondCategoryMapper.updateSecondCategory(categorySecond);
	}

	public void deleteSecondCategory(Integer csid) {
		secondCategoryMapper.deleteSecondCategory(csid);
	}

}
