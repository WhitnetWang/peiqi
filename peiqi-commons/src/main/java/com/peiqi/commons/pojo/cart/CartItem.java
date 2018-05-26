package com.peiqi.commons.pojo.cart;

import java.io.Serializable;

import com.peiqi.commons.pojo.pruduct.Product;

/*
 * 购物车项
 */
public class CartItem implements Serializable{
	private static final long serialVersionUID = -1929632294699727134L;
	
	private Product product;
	private Integer count;
	private Double subTotal;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubTotal() {
		return product.getShop_price() * count;
	}

}
