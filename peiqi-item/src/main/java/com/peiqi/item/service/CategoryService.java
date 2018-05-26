package com.peiqi.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peiqi.commons.interfaces.RpcCategoryService;
import com.peiqi.commons.interfaces.RpcSecondCategoryService;
import com.peiqi.commons.pojo.category.Category;
import com.peiqi.commons.pojo.category.CategorySecond;

@Service
public class CategoryService {
	
	@Autowired
	private RpcCategoryService rpcCategoryService;
	
	public List<Category> findAll() {
		
		List<Category> list = rpcCategoryService.findAll();
		
		return list;
	}

}
