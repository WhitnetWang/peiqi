package com.peiqi.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peiqi.commons.pojo.category.Category;


public interface CategoryMapper {

	List<Category> findAllCategory();

	Category findCategoryByCid(@Param("cid") Integer cid);

	void updateCategory(Category category);

	void deleteCategory(@Param("cid") Integer cid);

	void addCategory(@Param("cname") String cname);

}
