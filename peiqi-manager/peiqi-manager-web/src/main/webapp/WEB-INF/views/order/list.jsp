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
	//创建异步对象
	function createXMLHttpRequest(){
		try {
			return new XMLHttpRequest();//大多数浏览器
		} catch (e) {
			try {
				return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
			} catch (e) {
				try {
					return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本	
				} catch (e) {
					alert("该浏览器不支持创建该对象");
					throw e;
				}
			}
		}
	}
	
	function show(oid){
		
		var button = document.getElementById(oid);
		
		if(button.value == "订单详情"){
			//得到异步对象
			var xhr = createXMLHttpRequest();
			//打开连接
			xhr.open("post","${pageContext.request.contextPath}/adminOrder_show.action",true);
			//设置请求头
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//发送
			xhr.send("oid=" + oid);
			//设置监听
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					document.getElementById("div" + oid).innerHTML = xhr.responseText;
				}
			};
			button.value = "关闭";
		}else{
			document.getElementById("div" + oid).innerHTML = "";
			button.value = "订单详情";
		}
		
	}
	
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/user/list.jsp"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>订单列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

								<td align="center" width="20%">订单编号</td>
								<td align="center" width="5%">地址</td>
								<td align="center" width="5%">联系人</td>
								<td align="center" width="5%">电话</td>
								<td align="center" width="6%">订单状态</td>
								<td align="center" width="5%">总计</td>
								<td align="center" width="*">操作</td>
							</tr>
							<c:forEach items="${ pageInfo.list}" var="o" varStatus="s">
								
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${o.oid }
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${o.addr }
									</td>
									<td align="center" style="HEIGHT: 22px">
										${o.name }
									</td>
									<td align="center" style="HEIGHT: 22px">
										${o.phone }
									</td>
									<td align="center" style="HEIGHT: 22px">
										<c:if test="${o.state == 1 }">
											未付款
										</c:if>
										<c:if test="${o.state == 2 }">
											已付款,<a href="${pageContext.request.contextPath }/order/updateState.action?oid=${o.oid}"><font color="red">发货</font></a>
										</c:if>
										<c:if test="${o.state == 3 }">
											未确认收货
										</c:if>
										<c:if test="${o.state == 4 }">
											交易完成
										</c:if>
									</td>
									<td align="center" style="HEIGHT: 22px">
										${o.total }
									</td>
									<td align="center" style="HEIGHT: 22px">
										<input id="<s:property value="#o.oid" />" type="button" value="订单详情" onclick="show('${o.oid}')"/>
										<div id="div<s:property value='#o.oid'/>">
										</div>
									</td>
								</tr>
							
							</c:forEach>
								
								<tr>
									<td colspan="7" align="center">
										
										第${pageInfo.pageNum }/${pageInfo.pages }页
										<c:if test="${pageInfo.pageNum != 1 }">
											<a href="${pageContext.request.contextPath }/order/findAllOrder.action?page=1">首页</a>
											<a href="${pageContext.request.contextPath }/order/findAllOrder.action?page=${pageInfo.pageNum - 1}">上一页</a>
										</c:if>
										
										<c:forEach begin="1" end="${ pageInfo.pages}" var="i">
											<c:if test="${pageInfo.pageNum == i }">
												[${i }]
											</c:if>
											<c:if test="${pageInfo.pageNum != i }">
												[<a href="${pageContext.request.contextPath }/order/findAllOrder.action?page=${i}">${i }</a>]
											</c:if>
										</c:forEach>
										
										<c:if test="${pageInfo.pageNum != pageInfo.pages }">
											<a href="${pageContext.request.contextPath }/order/findAllOrder.action?page=${pageInfo.pageNum + 1}">下一页</a>
											<a href="${pageContext.request.contextPath }/order/findAllOrder.action?page=${pageInfo.pages}">尾页</a>
										</c:if>
									
									</td>
								</tr>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

