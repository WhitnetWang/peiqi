package com.peiqi.commons.interfaces;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.peiqi.commons.pojo.pruduct.Product;

public interface RpcProductService {
	
	public List<Product> findHotAll();
	
	public List<Product> findNewAll();

	public PageInfo<Product> findProductByCid(Integer cid, Integer page);

	public PageInfo<Product> findProductByCsid(Integer csid, Integer page);

	public Product findProductByPid(Integer pid);
}
