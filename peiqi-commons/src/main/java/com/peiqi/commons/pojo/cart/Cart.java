package com.peiqi.commons.pojo.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.peiqi.commons.pojo.pruduct.Product;

/*
 * 购物车
 */
public class Cart implements Serializable {

	private static final long serialVersionUID = 7442490230821090404L;
	// 存在购物车
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	// 总计
	private double total;

	/*public void setCartItems(List<CartItem> cartItems) {
		for (CartItem cartItem : cartItems) {
			map.put(cartItem.getProduct().getPid(), cartItem);
		}
	}*/
	
	public void setCartItems(List<CartItem> cartItems) {
		
	}
	
	public List<CartItem> getCartItems() {
		Collection<CartItem> values = map.values();
		
		List<CartItem> list = new ArrayList<>();
		
		Object[] array = values.toArray();
		
		for (Object object : array) {
			list.add((CartItem) object);
		}

		return list;
	}

	public Double getTotal() {
		return total;
	}

	// 添加购物车
	public void add(CartItem cartItem) {
		// 得到商品
		Product product = cartItem.getProduct();

		if (map.containsKey(product.getPid())) {// 存在

			CartItem item = map.get(product.getPid());
			item.setCount(item.getCount() + cartItem.getCount());

		} else {// 不存在
			map.put(cartItem.getProduct().getPid(), cartItem);
		}

		this.total += cartItem.getSubTotal();
	}

	// 清空购物车
	public void clear() {
		map.clear();
		this.total = 0;
	}

	// 移除购物车
	public void remove(Integer pid) {
		CartItem cartItem = map.remove(pid);
		this.total -= cartItem.getSubTotal();
	}
}