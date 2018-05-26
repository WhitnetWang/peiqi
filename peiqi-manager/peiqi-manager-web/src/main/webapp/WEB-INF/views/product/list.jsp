<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://static.peiqi.com/css/Style.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="http://static.peiqi.com/js/public.js"></script>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/adminProduct_toAddPage.action";
	}
</script>
</HEAD>
<body>
	<br>
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="添加"
							class="button_add" onclick="#">&#28155;&#21152;</button>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								
								<td align="center" width="7%">序号</td>
								<td align="center" width="10%">商品名称</td>
								<td align="center" width="10%">商品图片</td>
								<td align="center" width="17%">商品价格</td>
								<td align="center" width="17%">是否热门</td>
								<td width="7%" align="center">编辑</td>
								<td width="7%" align="center">删除</td>
							</tr>
							<c:forEach items="${pageInfo.list }" var="p" varStatus="s">
								
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${s.index }
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${p.pname }
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">
										<img width="40" height="40" alt="商品图片" src="http://static.peiqi.com/${p.image }">
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${p.shop_price }
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">
										<c:if test="${p.is_hot == 1 }">
											是
										</c:if>
										<c:if test="${p.is_hot != 1 }">
											否
										</c:if>
									</td>
									<td align="center" style="HEIGHT: 22px"><a
										href="#">
											<img
											src="http://static.peiqi.com/images/i_edit.gif"
											border="0" style="CURSOR: hand"></a>
									</td>

									<td align="center" style="HEIGHT: 22px"><a
										href="#">
											<img
											src="http://static.peiqi.com/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a>
									</td>
								</tr>
							
							</c:forEach>
								
								<tr>
									<td colspan="7" align="center">
										第${pageInfo.pageNum }/${pageInfo.pages }页
										<c:if test="${pageInfo.pageNum != 1 }">
											<a href="${pageContext.request.contextPath }/product/findAllProduct.action?page=1">首页</a>
											<a href="${pageContext.request.contextPath }/product/findAllProduct.action?page=${pageInfo.pageNum - 1}">上一页</a>
										</c:if>
										
										<c:forEach begin="1" end="${pageInfo.pages }" var="i">
											<c:if test="${pageInfo.pageNum == i }">
												[${i }]
											</c:if>
											<c:if test="${pageInfo.pageNum != i }">
												[<a href="${pageContext.request.contextPath }/product/findAllProduct.action?page=${i}">${i }</a>]
											</c:if>
										</c:forEach>
										
										<c:if test="${pageInfo.pageNum == pageInfo.pages }">
											<a href="${pageContext.request.contextPath }/product/findAllProduct.action?page=${pageInfo.pageNum + 1}">下一页</a>
											<a href="${pageContext.request.contextPath }/product/findAllProduct.action?page=${pageInfo.pages}">尾页</a>
										</c:if>
									
									</td>
								</tr>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
</body>
</HTML>

