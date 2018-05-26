package com.peiqi.commons.interfaces;

import java.util.List;

import com.peiqi.commons.pojo.category.CategorySecond;

public interface RpcSecondCategoryService {

	List<CategorySecond> findByCid(Integer cid);
	
}
