<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)${ctx}cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>购物车</title>

<link href="${ctx}/resource/web/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resource/web/css/cart.css" rel="stylesheet" type="text/css"/>


</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="${ctx}">
				<img src="${ctx}/resource/web//image/r___________renleipic_01/61.jpg"  style="width: 189px; height: 50px;"alt="KTV"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
<%-- 					<img src="${ctx}/resource/web//image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"> --%>
</div>	</div>
	<%@ include file="/common/menu.jsp" %>
	
</div>	<div class="container cart">
<c:if test="${cart != null}">
		<div class="span24">
			<div class="step step1">
				购物车信息
			</div>
				<table>
					<tbody>
					<tr>
						<th>图片</th>
						<th>商品</th>
					    <th>座位号</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
					 <c:forEach items="${cart.cartItems}" var="cartItem" >
						<tr>
							<td width="60">
								<img src="${ctx}/${cartItem.film.image}"/>
							</td>
							<td>
								<a>${cartItem.film.name}</a>
							</td>
<!-- 							<td> -->
<%-- 								<c:if test="${cartItem.filmSeat.z1==1}"> --%>
<!-- 								一排1号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z2==1}"> --%>
<!-- 								一排2号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z3==1}"> --%>
<!-- 								一排3号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z4==1}"> --%>
<!-- 								一排4号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z5==1}"> --%>
<!-- 								一排5号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z6==1}"> --%>
<!-- 								一排6号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z7==1}"> --%>
<!-- 								二排1号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z8==1}"> --%>
<!-- 								二排2号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z9==1}"> --%>
<!-- 								二排3号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z10==1}"> --%>
<!-- 								二排4号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z11==1}"> --%>
<!-- 								二排5号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z12==1}"> --%>
<!-- 								二排6号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z13==1}"> --%>
<!-- 								三排1号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z14==1}"> --%>
<!-- 								三排2号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z15==1}"> --%>
<!-- 								三排3号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z16==1}"> --%>
<!-- 								三排4号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z17==1}"> --%>
<!-- 								三排5号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z18==1}"> --%>
<!-- 								三排6号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z19==1}"> --%>
<!-- 								四排1号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z20==1}"> --%>
<!-- 								四排2号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z21==1}"> --%>
<!-- 								四排3号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z22==1}"> --%>
<!-- 								四排4号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z23==1}"> --%>
<!-- 								四排5号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z24==1}"> --%>
<!-- 								四排6号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z25==1}"> --%>
<!-- 								五排1号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z26==1}"> --%>
<!-- 								五排2号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z27==1}"> --%>
<!-- 								五排3号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z28==1}"> --%>
<!-- 								五排4号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z29==1}"> --%>
<!-- 								五排5号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${cartItem.filmSeat.z30==1}"> --%>
<!-- 								五排6号 -->
<%-- 								</c:if> --%>
<!-- 							</td> -->
                            <td>${cartItem.seat}</td>
							<td>
								￥${cartItem.film.price}
							</td>
							<td class="quantity" width="60">
								${cartItem.count}
							</td>
							<td width="140">
								<span class="subtotal">￥${cartItem.subtotal}</span>
							</td>
							<td>
								<a href="${ctx}/cart_removeCart.do?pid=${cartItem.film.id}"class="delete" onclick= "if(confirm( '是否删除！ ')==false)return   false; ">删除</a>
							</td>
						</tr>
                   </c:forEach>
					</tbody>
				</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
<!-- 				<div class="total"> -->
<!-- 					<em id="promotion"></em> -->
<!-- 							<em> -->
<!-- 								登录后确认是否享有优惠 -->
<!-- 							</em> -->
<%-- 					赠送积分: <em id="effectivePoint">${cart.total}</em> --%>
<%-- 					商品金额: <strong id="effectivePrice">￥${cart.total}元</strong> --%>
<!-- 				</div> -->
				<div class="bottom">
					<a href="${ctx}/cart_clearCart.do" id="clear" class="clear" onclick= "if(confirm( '是否要清空！ ')==false)return   false; ">清空购物车</a>
					<a href="${ctx}/order_saveOrder.do" id="submit" class="submit">提交订单</a>
				</div>
				
		</div>
		</c:if>
      <c:if test="${cart == null}">
			<div class="span24">
				<div class="step step1">
					<span><h2>亲!您还没有购物!请先去购物!</h2></span>
				</div>
			</div>
     </c:if>
	 </div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${ctx}/resource/web/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
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
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">2020-2021  影院购票系统</div>
	</div>
</div>
</body></html>