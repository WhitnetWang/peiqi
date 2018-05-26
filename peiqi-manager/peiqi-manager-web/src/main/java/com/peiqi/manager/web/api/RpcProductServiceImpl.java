package com.peiqi.manager.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peiqi.commons.interfaces.RpcProductService;
import com.peiqi.commons.pojo.pruduct.Product;
import com.peiqi.manager.mapper.ProductMapper;

@Service("rpcProductServiceImpl")
public class RpcProductServiceImpl implements RpcProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<Product> findHotAll() {
		return productMapper.findHotAll();
	}

	@Override
	public List<Product> findNewAll() {
		return productMapper.findNewAll();
	}

	@Override
	public PageInfo<Product> findProductByCid(Integer cid, Integer page) {
		
		PageHelper.startPage(page, 20);
		
		List<Product> products = productMapper.findProductByCid(cid);
		
		return new PageInfo<>(products);
	}

	@Override
	public PageInfo<Product> findProductByCsid(Integer csid, Integer page) {
		
		PageHelper.startPage(page, 20);
		
		List<Product> products = productMapper.findProductByCsid(csid);
		
		return new PageInfo<>(products);
	}

	@Override
	public Product findProductByPid(Integer pid) {
		return productMapper.findProductByPid(pid);
	}

}
