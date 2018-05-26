package com.peiqi.manager.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peiqi.commons.interfaces.RpcCategoryService;
import com.peiqi.commons.pojo.category.Category;
import com.peiqi.commons.pojo.category.CategorySecond;
import com.peiqi.manager.mapper.CategoryMapper;
import com.peiqi.manager.mapper.SecondCategoryMapper;

@Service("rpcCategoryServiceImpl")
public class RpcCategoryServiceImpl implements RpcCategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private SecondCategoryMapper secondCategoryMapper;
	
	public List<Category> findAll() {
		List<Category> list = categoryMapper.findAllCategory();
		
		for (Category category : list) {
			List<CategorySecond> categorySeconds = secondCategoryMapper.findByCid(category.getCid());
			category.setCategorySeconds(categorySeconds);
		}
		
		return list;
	}

}
