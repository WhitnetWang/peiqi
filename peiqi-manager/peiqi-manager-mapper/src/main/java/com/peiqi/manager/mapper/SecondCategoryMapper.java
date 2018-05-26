package com.peiqi.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peiqi.commons.pojo.category.CategorySecond;


public interface SecondCategoryMapper {

	List<CategorySecond> findAllSecondCategory();

	CategorySecond findSecondCategoryByCsid(@Param("csid") Integer csid);

	void updateSecondCategory(CategorySecond categorySecond);

	void deleteSecondCategory(@Param("csid") Integer csid);

	List<CategorySecond> findByCid(@Param("cid") Integer cid);
	
}
