<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="http://static.peiqi.com/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="http://static.peiqi.com/js/jquery.cookie.js"></script>
<script type="text/javascript">
	$(function(){
		var value = $.cookie("PEIQI_USER_TOKEN");
		
		if(value == undefined){
			var html =  "<li id='headerLogin' class='headerLogin' style='display: list-item;'>" + 
							"<a href='http://sso.peiqi.com/login.html'>登录</a>|" + 
						"</li>" + 
						"<li id='headerRegister' class='headerRegister' style='display: list-item;'>" + 
							"<a href='http://sso.peiqi.com/regist.html'>注册</a>|" + 
						"</li>" + 
						"<li>" + 
						"<a>|会员中心</a>|</li><li><a>购物指南</a>|</li><li><a>关于我们|</a></li>";
						
			$("#u").html(html);
			return;
		}
		
		$.ajax({
			url : "http://sso.peiqi.com/queryUserByToken.action",
			data : "key=" +  value,
			success : function(data){
				
				var json = eval("(" + data + ")");
				
				if(json.state == 200){
					$("#u").html("<li id='headerLogin' class='headerLogin' style='display: list-item;'>" + json.name + "|</li>"
						 + 
						"<li id='headerLogin' class='headerLogin' style='display: list-item;'>" + 
							"<a href='${pageContext.request.contextPath }/order_myOrders.action?page=1'>我的订单</a>|" + 
						"</li>"
						+
						"<li id='headerLogin' class='headerLogin' style='display: list-item;'>" + 
							"<a href='${pageContext.request.contextPath }/user_quit.action'>[退出]</a>|" + 
						"</li>" + "<li><a>会员中心</a>|</li><li><a>购物指南</a>|</li><li><a>关于我们</a></li>");
				}else{
					$("#topNav clearfix ul").html("<li id='headerLogin' class='headerLogin' style='display: list-item;'>" + 
							"<a href='http://sso.peiqi.com/login.html'>登录</a>|" + 
						"</li>" + 
						"<li id='headerRegister' class='headerRegister' style='display: list-item;'>" + 
							"<a href='http://sso.peiqi.com/regist.html'>注册</a>|" + 
						"</li>" + "<li><a>会员中心</a>|</li><li><a>购物指南</a>|</li><li><a>关于我们</a></li>");
				}			
			}
		});		
	});
</script>
<div class="container header">
	<div class="span5">
		<div>
			<a href="http://www.peiqi.com">
				<img width="150px" height="60px" src="http://static.peiqi.com/images/peiqi.png" alt="佩奇商城"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
	<img src="http://static.peiqi.com/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
</div>	</div>
	<div class="span10 last">
		<div class="topNav clearfix">
			<ul id="u">
			</ul>
		</div>
		<div class="cart">
			<a  href="${pageContext.request.contextPath }/cart_toCartPage.action">购物车</a>
		</div>
			<div class="phone">
				客服热线:
				<strong>96008/53277764</strong>
			</div>
	</div>
	<div class="span24">
		<ul class="mainNav">
				<li>
					<a href="http://www.peiqi.com">首页</a>
					|
				</li>
			<c:forEach items="${categories }" var="category">
				<li>
					<a href="${pageContext.request.contextPath }/findProductByCid.action?cid=${category.cid}&page=1">${category.cname }</a>
					|
				</li>
			</c:forEach>	
		</ul>
	</div>


</div>	