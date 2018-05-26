package com.peiqi.manager.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peiqi.commons.interfaces.RpcSecondCategoryService;
import com.peiqi.commons.pojo.category.CategorySecond;
import com.peiqi.manager.mapper.SecondCategoryMapper;

@Service("rpcSecondCategoryServiceImpl")
public class RpcSecondCategoryServiceImpl implements RpcSecondCategoryService{
	
	@Autowired
	private SecondCategoryMapper secondCategoryMapper;
	
	@Override
	public List<CategorySecond> findByCid(Integer cid) {
		List<CategorySecond> categorySeconds = secondCategoryMapper.findByCid(cid);
		return categorySeconds;
	}

}
