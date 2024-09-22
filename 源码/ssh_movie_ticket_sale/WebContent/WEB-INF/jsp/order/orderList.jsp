<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)${ctx}cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>订单页面</title>
<link href="${ctx}/resource/web/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/web/css/cart.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/web/css/product.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/resource/web/css/tips.css" type="text/css"/>
<script src="${ctx}/resource/web/js/jquery-1.8.3.js"></script>
<script>
//弹出框
var orderId=null;
function showDialog(id){
	orderId=id;
	$('#tip_newComment').show();
}
//取消弹出框
function cancel(){
	 var comment= $("#comment").val('');
	$('#tip_newComment').hide();
}

//提交评论
function addComment(){
	var content = $("#content").val();
	var filmId = $("#filmId").val();
	$.ajax({
         url: ctx+'/comment_exAdd.do',
		type: 'POST',
		dataType: 'json',
	    data: {content:content,orderId:orderId,filmId:filmId},
		async: false,
		success : function(data) {
			if(data.result == 1){
				  alert("评论成功,谢谢下次光临");
// 					$("#a").attr("disabled", "true");
                    $("#ttt").attr("disabled","true");
				  cancel();
				 window.location.href='${ctx}/order_findByUserId.do';
				}else{
				}
		},
			error : function() {
				alert("error");
			}
	});
}
</script>

</head>
<body>

	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="/ssh_movie_ticket_sale/login_index.do?role=1"> 
					<img src="${ctx}/resource/web/image/r___________renleipic_01/61.jpg"  style="width: 189px; height: 50px;"alt="KTV"/></a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
<%-- 				<img src="${ctx}/resource/web/image/header.jpg" --%>
<!-- 					width="320" height="50" alt="正品保障" title="正品保障" /> -->
			</div>
		</div>

	 <%@ include file="/common/menu.jsp" %>

	</div>

	<div class="container cart">

		<div class="span24">

			<div class="step step1">
				<ul>

					<li class="current"></li>
					<li style="margin-left: 170px;color: red;font-size: 26px;">我的订单</li>
				</ul>
			</div>


			<table>
				<tbody>
				 <c:forEach items="${pagers.datas}" var="order" varStatus="l">
				   <input type="hidden" name="orderId"  id="orderId" value="${order.id}"/>
						<tr>
							<th colspan="6">订单编号:${order.uid}"&nbsp;&nbsp;&nbsp;&nbsp;订单金额:<font
								color="red">￥${order.total}
							</font>
							&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">
							       <c:if test="${order.status==0 }">
<%-- 									<a href="${ctx}/order_payOrder.do?id=${order.id}">付款</a> --%>
                                     <a href="${ctx}/order_saveOrder1.do?id=${order.id}">付款</a> 
									&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="${ctx}/order_cancelOrder1.do?id=${order.id}">取消订单</a> 
									</c:if>
								  <c:if test="${order.status==1 }">
									已付款
									
					              </c:if>
								  <c:if test="${order.status==2 }">
								      	交易成功
								</c:if>
							    <c:if test="${order.status==3 }">
									订单已取消
								</c:if>
<%-- 								 <c:if test="${order.status==4 }"> --%>
<!-- 									订单已取消 -->
<%-- 		  						</c:if> --%>
							</font>
							      &nbsp;&nbsp;  订单时间：<font color="red"><fmt:formatDate value="${order.orderTime}" pattern="yyyy-MM-dd HH:mm:ss"/></font>
							 <c:if test="${order.status==2 }">
							  <c:if test="${order.isRemark==0 }">
									 <a style="cursor: pointer;" onclick="showDialog('${order.id}')" id="ttt"><span style="color:red; margin-left:170px;" >点击评论</span></a>
						    	</c:if>
							 </c:if>
							</th>
						</tr>
						<tr>
							<th>图片</th>
							<th>商品</th>
							<th>座位号</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>	
						
                            <c:forEach items="${orderItemList.datas}" var="orderItem" varStatus="l">
                            <c:if test="${orderItem.orders.id==order.id }">
							<tr>
							  <input type="hidden" name="filmId"  id="filmId" value="${orderItem.film.id}"/>
								<td width="60"><img
									src="${ctx}/${orderItem.film.image }"/>
								</td>
								<td>${orderItem.film.name }</td>
								<td>
								    ${orderItem.seat}
<%-- 								<c:if test="${orderItem.filmSeat.z1==1}"> --%>
<!-- 								一排1号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z2==1}"> --%>
<!-- 								一排2号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z3==1}"> --%>
<!-- 								一排3号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z4==1}"> --%>
<!-- 								一排4号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z5==1}"> --%>
<!-- 								一排5号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z6==1}"> --%>
<!-- 								一排6号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z7==1}"> --%>
<!-- 								二排1号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z8==1}"> --%>
<!-- 								二排2号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z9==1}"> --%>
<!-- 								二排3号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z10==1}"> --%>
<!-- 								二排4号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z11==1}"> --%>
<!-- 								二排5号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z12==1}"> --%>
<!-- 								二排6号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z13==1}"> --%>
<!-- 								三排1号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z14==1}"> --%>
<!-- 								三排2号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z15==1}"> --%>
<!-- 								三排3号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z16==1}"> --%>
<!-- 								三排4号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z17==1}"> --%>
<!-- 								三排5号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z18==1}"> --%>
<!-- 								三排6号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z19==1}"> --%>
<!-- 								四排1号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z20==1}"> --%>
<!-- 								四排2号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z21==1}"> --%>
<!-- 								四排3号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z22==1}"> --%>
<!-- 								四排4号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z23==1}"> --%>
<!-- 								四排5号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z24==1}"> --%>
<!-- 								四排6号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z25==1}"> --%>
<!-- 								五排1号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z26==1}"> --%>
<!-- 								五排2号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z27==1}"> --%>
<!-- 								五排3号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z28==1}"> --%>
<!-- 								五排4号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z29==1}"> --%>
<!-- 								五排5号 -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${orderItem.filmSeat.z30==1}"> --%>
<!-- 								五排6号 -->
<%-- 								</c:if> --%>
							</td>
								<td>${orderItem.film.price }</td>
								<td class="quantity" width="60">
										${orderItem.count}</td>
								<td width="140"><span class="subtotal">￥
											${orderItem.subtotal }
								</span></td>
							</tr>
							 </c:if>
							</c:forEach>
                   </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- 弹框-新增评论-->
	<div class="tip_fix" id="tip_newComment">
		<div class="tip_frame">
			<div class="btn btn_close"></div>
			<div class="tip_box">
				<div class="tip_title">新增评论</div>
				<div class="tip_cnt_row">
					<div class="tip_cnt_l">
						<span class="tip_item_title">评论内容:</span> 
						<textarea rows="3" cols="20"
							class="tip_input1" id="content" name="content" style="width: 658px;height: 130px;"></textarea>
					</div>
				</div>
				<div class="tip_cnt_btn">
					<div class="btn1 btn_yes"  onclick="addComment()">确定</div>
					<div class="btn1 btn_no"  onclick="cancel()">取消</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="panel-foot text-center" style="margin: 0 auto; width: 350px" >
      <pg:pager  url="${ctx}/order_findByUserId.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
			<pg:param name="name" value="${product.name}"/>
		<pg:last>  
			共${pagers.total}记录,共${pageNumber}页,  
		</pg:last>  
			当前第${curPage}页 
  
        <pg:first>  
    		<a href="${pageUrl}">首页</a>  
		</pg:first>  
		<pg:prev>  
    		<a href="${pageUrl}">上一页</a>  
		</pg:prev>  
      
       	<pg:pages>  
        	<c:choose>  
            	<c:when test="${curPage eq pageNumber}">  
                	<font color="red">[${pageNumber }]</font>  
            	</c:when>  
            	<c:otherwise>  
               		<a href="${pageUrl}">${pageNumber}</a>  
            	</c:otherwise>  
        	</c:choose>  
    	</pg:pages>
             
        <pg:next>  
    		<a href="${pageUrl}">下一页</a>  
		</pg:next>  
		<pg:last>  
			<c:choose>  
            	<c:when test="${curPage eq pageNumber}">  
                	<font color="red">尾页</font>  
            	</c:when>  
            	<c:otherwise>  
               		<a href="${pageUrl}">尾页</a>  
            	</c:otherwise>  
        	</c:choose> 
    		  
		</pg:last>
	</pg:pager>
    </div>
	
	<div class="container footer">
<!-- 		<div class="span24"> -->
<!-- 			<div class="footerAd"> -->
<%-- 				<img src="${ctx}/resource/web/image\r___________renleipic_01/footer.jpg" alt="我们的优势" --%>
<!-- 					title="我们的优势" height="52" width="950"> -->
<!-- 			</div> -->
<!-- 		</div> -->
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
</body>
</html>