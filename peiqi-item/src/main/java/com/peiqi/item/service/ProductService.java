package com.peiqi.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.peiqi.commons.interfaces.RpcProductService;
import com.peiqi.commons.pojo.pruduct.Product;

@Service
public class ProductService {
	
	@Autowired
	private RpcProductService rpcProductService;
	
	public List<Product> findHotAll() {
		List<Product> hAll = rpcProductService.findHotAll();
		return hAll;
	}

	public List<Product> findNewAll() {
		List<Product> newAll = rpcProductService.findNewAll();
		return newAll;
	}

	public PageInfo<Product> findProductByCid(Integer cid, Integer page) {
		
		return rpcProductService.findProductByCid(cid,page);
	}

	public PageInfo<Product> findProductByCsid(Integer csid, Integer page) {
		return rpcProductService.findProductByCsid(csid,page);
	}

	public Product findProductByPid(Integer pid) {
		return rpcProductService.findProductByPid(pid);
	}
	
}
