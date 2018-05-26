<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>佩奇商城</title>
<link href="http://static.peiqi.com/css/common.css" rel="stylesheet" type="text/css"/>
<link href="http://static.peiqi.com/css/product.css" rel="stylesheet" type="text/css"/>
<link rel="icon" type="image/jpeg" href="http://static.peiqi.com/images/peiqi.png">
</head>
<body>
	<%@ include file="menu.jsp" %>
<div class="container productList">
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
			
				<div id="result" class="result table clearfix">
						<ul>
							<c:forEach items="${pageInfo.list }" var="p">
								
								<li>
									<a href="${pageContext.request.contextPath }/findProductByPid.action?pid=${p.pid}">
											<img src="http://static.peiqi.com/${p.image }" width="170" height="170" style="display: inline-block;" /> 
										<span style='color:green'>${p.pname }
										</span> 
										<span class="price"> 商城价： ￥${p.shop_price }/份 </span> 
									</a>
								</li>
							</c:forEach>
						</ul>
				</div>
	<div class="pagination">
		
		<c:if test="${cid != null }">
			
			<span>第${pageInfo.pageNum }/${pageInfo.pages }页</span>
			
			
			<c:if test="${pageInfo.pageNum != 1 }">
				<a class="firstPage" href="${pageContext.request.contextPath }/findProductByCid.action?page=1&cid=${cid}">&nbsp;</a>
				<a class="previousPage" href="${pageContext.request.contextPath }/findProductByCid.action?page=${pageInfo.pageNum - 1}&cid=${cid}">&nbsp;</a>
			</c:if>
			
			
			
			<c:forEach begin="1" end="${pageInfo.pages }" var="i">
				<c:if test="${pageInfo.pageNum == i}">
					<span class="currentPage">${i }</span>
				</c:if>
				<c:if test="${pageInfo.pageNum != i}">
					<a href="${pageContext.request.contextPath }/findProductByCid.action?page=${i }&cid=${cid}">${i }</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${pageInfo.pageNum != pageInfo.pages }">
				<a class="nextPage" href="${pageContext.request.contextPath }/findProductByCid.action?page=${pageInfo.pageNum + 1 }&cid=${cid}">&nbsp;</a>
				<a class="lastPage" href="${pageContext.request.contextPath }/findProductByCid.action?page=${pageInfo.pages }&cid=${cid}">&nbsp;</a>
			</c:if>
		</c:if>
		
		
			
		
		<c:if test="${cid == null }">
				<span>第${pageInfo.pageNum }/${pageInfo.pages }页</span>
			
			<c:if test="${pageInfo.pageNum != 1 }">
				<a class="firstPage" href="${pageContext.request.contextPath }/findProductByCsid.action?page=1&csid=${csid}">&nbsp;</a>
				<a class="previousPage" href="${pageContext.request.contextPath }/findProductByCsid.action?page=${pageInfo.pageNum - 1}&csid=${csid}">&nbsp;</a>
			</c:if>
			
			<c:forEach begin="1" end="${pageInfo.pages }" var="i">
				<c:if test="${pageInfo.pageNum == i }">
					<span class="currentPage">${i }</span>
				</c:if>
				<c:if test="${pageInfo.pageNum != i }">
					<a href="${pageContext.request.contextPath }/findProductByCsid.action?page=${i }&csid=${csid}">${i }</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${pageInfo.pageNum != pageInfo.pages }">
				<a class="nextPage" href="${pageContext.request.contextPath }/findProductByCsid.action?page=${pageInfo.pageNum + 1 }&csid=${csid}">&nbsp;</a>
				<a class="lastPage" href="${pageContext.request.contextPath }/findProductByCsid.action?page=${pageInfo.pages }&csid=${csid}">&nbsp;</a>
			</c:if>
		
		</c:if>
		
	</div>
	
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="http://static.peiqi.com/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势"/>
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a >诚聘英才</a>
						|
					</li>
					<li>
						<a >法律声明</a>
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
						<a >官网</a>
						|
					</li>
					<li>
						<a >论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2018 佩奇网 版权所有</div>
	</div>
</div>
</body></html>