package com.peiqi.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peiqi.commons.pojo.pruduct.Product;
import com.peiqi.manager.mapper.ProductMapper;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	public PageInfo<Product> findAllProduct(Integer page) {
		
		PageHelper.startPage(page, 20);
		
		List<Product> products = productMapper.findAllProduct();
		
		return new PageInfo<>(products);
	}

}
