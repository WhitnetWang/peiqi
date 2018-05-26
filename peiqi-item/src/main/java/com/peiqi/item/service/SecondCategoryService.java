package com.peiqi.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peiqi.commons.interfaces.RpcSecondCategoryService;
import com.peiqi.commons.pojo.category.CategorySecond;

@Service
public class SecondCategoryService {

	@Autowired
	private RpcSecondCategoryService rpcSecondCategoryService;
	
	public List<CategorySecond> findByCid(Integer cid) {
		return rpcSecondCategoryService.findByCid(cid);
	}
	
}
