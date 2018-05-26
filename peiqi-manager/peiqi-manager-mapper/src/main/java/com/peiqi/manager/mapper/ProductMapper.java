package com.peiqi.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peiqi.commons.pojo.pruduct.Product;


public interface ProductMapper {

	List<Product> findAllProduct();

	List<Product> findHotAll();

	List<Product> findNewAll();

	List<Product> findProductByCid(@Param("cid") Integer cid);

	List<Product> findProductByCsid(@Param("csid") Integer csid);

	Product findProductByPid(@Param("pid") Integer pid);

}
