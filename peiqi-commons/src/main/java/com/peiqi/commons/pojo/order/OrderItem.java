package com.peiqi.commons.pojo.order;

import java.io.Serializable;

import com.peiqi.commons.pojo.pruduct.Product;

public class OrderItem implements Serializable{
	private static final long serialVersionUID = -6774815792642744698L;
	
	private Integer itemid;
	private Integer count;
	private Double subtotal;
	private Order order;
	private Product product;

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
