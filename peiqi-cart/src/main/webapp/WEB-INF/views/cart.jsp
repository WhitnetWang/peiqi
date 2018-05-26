<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>购物车</title>

<link href="http://static.peiqi.com/css/common.css" rel="stylesheet" type="text/css"/>
<link href="http://static.peiqi.com/css/cart.css" rel="stylesheet" type="text/css"/>
<link rel="icon" type="image/jpeg" href="http://static.peiqi.com/images/peiqi.png">

</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="container cart">
	<c:if test="${cart != null }">
	
		<div class="span24">
			<div class="step step1">
				
			</div>
				<table>
					<tbody><tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
						<c:forEach items="${cart.cartItems }" var="cartItem">
							<tr>
								<td width="60">
									<input type="hidden" name="id" value="22"/>
									<img src="http://static.peiqi.com/${ cartItem.product.image}"/>
								</td>
								<td>
									<a target="_blank">${cartItem.product.pname }</a>
								</td>
								<td>
									￥${cartItem.product.shop_price }
								</td>
								<td class="quantity" width="60">
									${cartItem.count }
								</td>
								<td width="140">
									<span class="subtotal">￥${cartItem.subTotal }</span>
								</td>
								<td>
									<a href="${pageContext.request.contextPath }/cart_remove.action?pid=${cartItem.product.pid}" class="delete">删除</a>
								</td>
							</tr>
						</c:forEach>
				</tbody>
				</table>
				
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				
				<div class="total">
					<em id="promotion"></em>
					赠送积分: <em id="effectivePoint">${cart.total }</em>
					佩奇特价: <strong id="effectivePrice">￥0.01元</strong>
				</div>
				<div class="bottom">
					<a href="" id="clear" class="clear">清空购物车</a>
					<a href="${pageContext.request.contextPath }/saveOrder.action" id="submit" class="submit">提交订单</a>
				</div>
		</div>
	</c:if>
	<c:if test="${cart == null }">
		亲!您的购物车为空
	</c:if>
		
	</div>
	
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="http://static.peiqi.com/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势"/>
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
				<li>
						<a>关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>招贤纳士</a>
						|
					</li>
					<li>
						<a>法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2018 佩奇网 版权所有</div>
	</div>
</div>
</body></html>