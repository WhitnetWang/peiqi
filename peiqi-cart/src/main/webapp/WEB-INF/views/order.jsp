<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>订单页面</title>
<link href="http://static.peiqi.com/css/common.css" rel="stylesheet" type="text/css"/>
<link href="http://static.peiqi.com/css/cart.css" rel="stylesheet" type="text/css"/>
	<script>
		function payOrder(){
			alert(123);
			var form document.getElementById("orderForm");
			form.submit();
		}
	</script>
</head>
<body>

	<%@ include file="menu.jsp" %>

<div class="container cart">

		<div class="span24">
		
			<div class="step step1">
				<ul>
					
					<li  class="current"></li>
					<li  >生成订单成功</li>
				</ul>
			</div>
	
		
				<table>
					<tbody>
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
					</tr>
					<c:forEach items="${order.orderItems }" var="orderItem">
						
					
						
						<tr>
							<td width="60">
								<input type="hidden" name="id" value="22"/>
								<img src="http://static.peiqi.com/${orderItem.product.image}"/>
							</td>
							<td>
								<a target="_blank">${orderItem.product.pname }</a>
							</td>
							<td>
								${orderItem.product.shop_price }
							</td>
							<td class="quantity" width="60">
								<input type="text" name="count" value="${orderItem.count }" maxlength="4"/>
								<div>
									<span class="increase">&nbsp;</span>
									<span class="decrease">&nbsp;</span>
								</div>
							</td>
							<td width="140">
								<span class="subtotal">￥${orderItem.subtotal }</span>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
					佩奇特价: <strong id="effectivePrice">0.01元</strong>
				</div>
			<form id="orderForm" action="${pageContext.request.contextPath }/pay.action" method="post">
				<input type="hidden" name="oid" value="${order.oid }"/>
				<div class="span24">
					<p>
							收货地址：<input name="addr" type="text" value="" style="width:350px" />
								<br />
							收货人&nbsp;&nbsp;&nbsp;：<input name="name" type="text" value="" style="width:150px" />
								<br /> 
							联系方式：<input name="phone" type="text" value="" style="width:150px" />

						</p>
						<hr />
						<p>
							选择银行：<br/>
								<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
							<img src="http://static.peiqi.com/bank_img/icbc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
							<img src="http://static.peiqi.com/bank_img/bc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
							<img src="http://static.peiqi.com/bank_img/abc.bmp" align="middle"/>
							<br/>
								<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
							<img src="http://static.peiqi.com/bank_img/bcc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>平安银行
							<img src="http://static.peiqi.com/bank_img/pingan.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
							<img src="http://static.peiqi.com/bank_img/ccb.bmp" align="middle"/>
							<br/>
								<input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>光大银行
							<img src="http://static.peiqi.com/bank_img/guangda.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>招商银行
							<img src="http://static.peiqi.com/bank_img/cmb.bmp" align="middle"/>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-PEIQI"/>佩奇银行
							<img src="http://static.peiqi.com/bank_img/pq.bmp" align="middle"/>
						</p>
						<hr />
						<p style="text-align:right">
							<input type="image" src="http://static.peiqi.com/images/finalbutton.gif" style="width: 204;height: 51;border: 0"/>
						</p>
				</div>
			</form>
		</div>
		
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="http://static.peiqi.com/image/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950"/>
</div>
</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a href="#">关于我们</a>
						|
					</li>
					<li>
						<a href="#">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
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
						<a target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a>SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2018 佩奇网 版权所有</div>
	</div>
</div>
</body>
</html>