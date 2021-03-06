<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<title>网上商城</title>
<link href="http://static.peiqi.com/css/common.css" rel="stylesheet" type="text/css"/>
<link href="http://static.peiqi.com/css/product.css" rel="stylesheet" type="text/css"/>
<link rel="icon" type="image/jpeg" href="http://static.peiqi.com/images/peiqi.png">
</head>
<body>
	<%@ include file="menu.jsp" %>
<div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
				<c:forEach items="${categories }" var="c">
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath }/findProductByCsid.action?page=1&cid=${c.cid}">${c.cname }</a>
							</dt>
							<c:forEach items="${c.categorySeconds }" var="cs">
								<dd>
									<a href="${pageContext.request.contextPath }/findProductByCsid.action?page=1&csid=${cs.csid}">${cs.csname }</a>
								</dd>
							</c:forEach>
						</dl>
				</c:forEach>		
			</div>
			

		</div>
		<div class="span18 last">
			
			<div class="productImage">
					<a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="http://image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg" rel="gallery">
						<div class="zoomPad">
							<img style="opacity: 1;" title="" class="medium" src="http://static.peiqi.com/${product.image}"/>
							<div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup">
							</div>
							<div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;" class="zoomWindow">
								<div style="width: 368px;" class="zoomWrapper">
									<div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle">
									</div>
									<div style="width: 0%; height: 0px;" class="zoomWrapperImage">
										<img src="http://static.peiqi.com/${product.image}" style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;"/>
									</div>
								</div>
							</div>
							<div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div>
						</div>
					</a>
				
			</div>
			<div class="name">${product.pname }</div>
			<div class="sn">
				<div>编号：${product.pid }</div>
			</div>
			<div class="info">
				<dl>
					<dt>亿家价:</dt>
					<dd>
						<strong>￥：${product.shop_price }元/份</strong>
							参 考 价：
							<del>￥${product.market_price }元/份</del>
					</dd>
				</dl>
					<dl>
						<dt>促销:</dt>
						<dd>
								<a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时抢购</a>
						</dd>
					</dl>
			</div>
				<div class="action">
					<form action="http://cart.peiqi.com/addCart.action" method="post">
						<input type="hidden" name="pid" value="${product.pid }"/>
						<dl class="quantity">
							<dt>购买数量:</dt>
							<dd>
								<input id="quantity" name="count" value="1" maxlength="4" type="text"/>
							</dd>
							<dd>
								件
							</dd>
						</dl>
						<div class="buy">
								<input id="addCart" class="addCart" value="加入购物车" type="submit"/>
						</div>
					</form>
				</div>
			<div id="bar" class="bar">
				<ul>
						<li id="introductionTab">
							<a href="#introduction">商品介绍</a>
						</li>
				</ul>
			</div>
				
				<div id="introduction"  class="introduction">
					<div class="title">
						<strong>${product.pdesc }</strong>
					</div>
					<div>
						<img src="http://static.peiqi.com/${product.image }"/>
					</div>
				</div>
				
				
				
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