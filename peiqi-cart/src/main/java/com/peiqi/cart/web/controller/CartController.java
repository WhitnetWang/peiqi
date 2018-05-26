package com.peiqi.cart.web.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peiqi.cart.service.RedisService;
import com.peiqi.commons.interfaces.RpcCategoryService;
import com.peiqi.commons.interfaces.RpcProductService;
import com.peiqi.commons.pojo.cart.Cart;
import com.peiqi.commons.pojo.cart.CartItem;
import com.peiqi.commons.pojo.category.Category;
import com.peiqi.commons.pojo.pruduct.Product;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/")
public class CartController {

	@Autowired
	private RedisService redisService;

	@Autowired
	private RpcProductService rpcProductService;

	@Autowired
	private RpcCategoryService rpcCategoryService;

	@RequestMapping("/addCart.action")
	public String addCart(Integer count, Integer pid, HttpServletRequest request) {

		List<Category> categories = rpcCategoryService.findAll();
		request.setAttribute("categories", categories);

		Cookie[] cookies = request.getCookies();

		String value = "";

		for (Cookie cookie : cookies) {
			String cartToken = cookie.getName();

			if (cartToken.equals("PEIQI_CART_TOKEN")) {
				value = cookie.getValue();
			}

		}

		// 先根据pid查询商品
		Product product = rpcProductService.findProductByPid(pid);
		// 创建一个购物项
		CartItem cartItem = new CartItem();
		// 设置购物项
		cartItem.setCount(count);
		cartItem.setProduct(product);

		// 从redis中得到购物车
		//String cartJson = redisService.get(value);
		
		ServletContext servletContext = request.getSession().getServletContext();
		
		System.out.println(value);
		
		Cart cart = (Cart) servletContext.getAttribute(value);

		if (cart != null) {
			System.out.println("cartJson != null");
			// 将购物车json穿转换成cart对象
			//JSONObject jsonObject = JSONObject.fromObject(cartJson);

			//Cart cart = (Cart) JSONObject.toBean(jsonObject, Cart.class);
			cart.add(cartItem);
			//System.out.println(JSONObject.fromObject(cart).toString());
			// 再将cart序列化成json
			this.redisService.set(value, JSONObject.fromObject(cart).toString(), 60 * 30);
			
			servletContext.setAttribute(value, cart);
			
			request.setAttribute("cart", cart);

		} else {
			System.out.println("cartJson == null");

			cart = new Cart();
			
			cart.add(cartItem);

			servletContext.setAttribute(value, cart);
			
			request.setAttribute("cart", cart);
		}

		return "cart";
	}
}
