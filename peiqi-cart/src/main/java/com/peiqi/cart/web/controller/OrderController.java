package com.peiqi.cart.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peiqi.cart.service.RedisService;
import com.peiqi.cart.utils.PaymentUtil;
import com.peiqi.commons.interfaces.RpcCategoryService;
import com.peiqi.commons.interfaces.RpcOrderService;
import com.peiqi.commons.pojo.cart.Cart;
import com.peiqi.commons.pojo.cart.CartItem;
import com.peiqi.commons.pojo.category.Category;
import com.peiqi.commons.pojo.order.Order;
import com.peiqi.commons.pojo.order.OrderItem;
import com.peiqi.commons.pojo.user.User;
import com.peiqi.commons.utils.UUIDUtils;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/")
public class OrderController {

	@Autowired
	private RedisService redisService;

	@Autowired
	private RpcOrderService rpcOrderService;
	
	@Autowired
	private RpcCategoryService rpcCategoryService;

	@RequestMapping("/saveOrder.action")
	public String saveOrder(HttpServletRequest request, HttpServletResponse response) {
		
		List<Category> categories = rpcCategoryService.findAll();
		request.setAttribute("categories", categories);

		String userKey = null;
		String cartKey = null;

		Cookie[] cookies = request.getCookies();

		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("PEIQI_USER_TOKEN")) {
					userKey = cookie.getValue();
				}

				if (cookie.getName().equals("PEIQI_CART_TOKEN")) {
					cartKey = cookie.getValue();
				}
			}
		}

		if (userKey == null) {

			try {
				response.sendRedirect("http://sso.peiqi.com/login.html");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		String userValue = this.redisService.get(userKey);

		JSONObject object = JSONObject.fromObject(userValue);

		User user = (User) JSONObject.toBean(object, User.class);
		
		if(null == user) {
			try {
				response.sendRedirect("http://sso.peiqi.com/login.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		ServletContext servletContext = request.getSession().getServletContext();

		System.out.println(cartKey);

		if (null != cartKey) {

			// String cartValue = redisService.get(cartKey);

			Cart cart = (Cart) servletContext.getAttribute(cartKey);

			if (null != cart) {

				// JSONObject jsonObject = JSONObject.fromObject(cartValue);

				// Cart cart = (Cart) JSONObject.toBean(jsonObject, Cart.class);

				Order order = new Order();

				// 设置订单
				order.setOid(UUIDUtils.getUUID());
				order.setState(1); // 1未付款 2已付款但未发货 3已发货但为确认收货 4交易完成
				order.setOrdertime(new Date());
				// 设置总计
				order.setTotal(cart.getTotal());
				order.setUid(user.getUid());

				List<CartItem> cartItems = cart.getCartItems();

				System.out.println(cartItems);

				// 遍历购物项
				for (CartItem cartItem : cartItems) {
					// 创建对应的订单项
					OrderItem orderItem = new OrderItem();
					orderItem.setCount(cartItem.getCount());
					orderItem.setProduct(cartItem.getProduct());
					orderItem.setSubtotal(cartItem.getSubTotal());
					// 订单项 关联 订单
					orderItem.setOrder(order);
					// 订单 关联 订单项
					order.getOrderItems().add(orderItem);

					System.out.println(rpcOrderService);

					System.out.println("------" + order);

					request.setAttribute("order", order);
				}

				rpcOrderService.saveOrder(order);
			} else {

			}

		} else {

		}

		return "order";
	}

	@RequestMapping("pay.action")
	public String pay(Order order, @RequestParam("pd_FrpId") String FrpId, HttpServletRequest request,
			HttpServletResponse response) {
		// 先出根据oid查询订单
		Order o = rpcOrderService.queryOrderById(order.getOid());
		// 设置订单
		
		o.setAddr(order.getAddr());
		o.setName(order.getName());
		o.setPhone(order.getPhone());
		o.setState(2);
		
		rpcOrderService.updateOrder(o);
	
		/*
		 * 配置支付参数
		 */
		String p0_Cmd = "Buy";
		String p1_MerId = "10001126856"; // 其实就是支付帐号  10001126856
		String p2_Order = o.getOid(); // 订单编号
		String p3_Amt = "0.01"; // 支付金额
		String p4_Cur = "CNY"; // 支付币种
		String p5_Pid = ""; // 商品名称
		String p6_Pcat = ""; // 商品种类
		String p7_Pdesc = ""; // 商品描述
		String p8_Url = "http://127.0.0.1:8084/callback.action"; // 回调方法的url
		String p9_SAF = ""; // 送货地址
		String pa_MP = ""; // 商户的扩展信息
		String pd_FrpId = FrpId; // 用哪家银行
		String pr_NeedResponse = "1"; // 应答机制

		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 密钥  69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl

		// 通过md5加密计算hmac
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

		// 拼接url
		StringBuilder url = new StringBuilder("https://www.yeepay.com/app-merchant-proxy/node?");
		url.append("p0_Cmd=").append(p0_Cmd).append("&");
		url.append("p1_MerId=").append(p1_MerId).append("&");
		url.append("p2_Order=").append(p2_Order).append("&");
		url.append("p3_Amt=").append(p3_Amt).append("&");
		url.append("p4_Cur=").append(p4_Cur).append("&");
		url.append("p5_Pid=").append(p5_Pid).append("&");
		url.append("p6_Pcat=").append(p6_Pcat).append("&");
		url.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		url.append("p8_Url=").append(p8_Url).append("&");
		url.append("p9_SAF=").append(p9_SAF).append("&");
		url.append("pa_MP=").append(pa_MP).append("&");
		url.append("pa_MP=").append(pa_MP).append("&");
		url.append("pa_MP=").append(pa_MP).append("&");
		url.append("pd_FrpId=").append(pd_FrpId).append("&");
		url.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		url.append("hmac=").append(hmac);
		
		
		/*try {
			response.sendRedirect(url.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		request.setAttribute("message", "支付成功!");
		
		return "msg";
		
	}

}
