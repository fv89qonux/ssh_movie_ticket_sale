<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!-- 评价界面 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <title>后台管理系统</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/manage/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/manage/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/manage/css/style.css" />
      <link rel="stylesheet" href="${ctx}/resource/manage/css/jquery.datetimepicker.css"   >
    <script type="text/javascript" src="${ctx}/resource/manage/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/ckform.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/common.js"></script>
    <script src="${ctx}/resource/manage/js/jquery.datetimepicker.js"></script>
</head>
  <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }
        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
       td{text-align:center;}
    </style>
<body>
<form class="form-inline definewidth m20" action="order_order.do" method="post">  
  订单时间：
    <input type="text" name="startTime" id="startTime"class="abc input-default" placeholder="" value="${startTime}">-- 
     <input type="text" name="endTime" id="endTime"class="abc input-default" placeholder="" value="${endTime}"> 
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
</form>
<table class="table table-bordered table-hover definewidth m10" align="center">
    <thead>
    <tr>
        <th>订单ID</th>
        <th>订单编号</th>
        <th>订单时间</th>
        <th>用户名</th>
        <th>电话</th>
        <th>座位号</th>
        <th>订单金额</th>
        <th>订单状态</th>
        <th>操作</th>
    </tr>
    </thead>
     <c:forEach items="${pagers.datas}" var="order" varStatus="l">
      <tr>
            <td align="center">${order.id}</td>
            <td>${order.uid}</td>
            <td><fmt:formatDate value="${order.orderTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${order.user.realName}</td>
            <td>${order.user.phone}</td>
            <td>
					${order.seat}			
							</td>
            <td>￥${order.total}</td>
           <td>
           <c:if test="${order.status==0}">
                                          未付款     &nbsp;&nbsp;
           <a class="label label-warning" href="${ctx}/order_cancelOrder2.do?id=${order.id}">取消订单</a>
           </c:if>
           <c:if test="${order.status==1}">
                                           已付款    &nbsp;&nbsp;
            <a class="label label-warning" href="${ctx}/order_confirm.do?id=${order.id}">&nbsp; &nbsp;审&nbsp;核 &nbsp;&nbsp;</a>                                 
            </c:if>
           <c:if test="${order.status==2}"	>
                                       交易成功
            </c:if>
            <c:if test="${order.status==3}">
                                              订单已取消
            </c:if>
           </td>
           <td>
                 <a id="update" href="${ctx}/order_view.do?id=${order.id}">详情</a>
                 &nbsp;&nbsp;
                 <a id="update" href="${ctx}/order_delete.do?id=${order.id}" onclick= "if(confirm( '是否删除！ ')==false)return   false; ">删除</a>
               
            </td>
        </tr>
     </c:forEach>
 </table>
 <div class="panel-foot text-center">
      <pg:pager  url="${ctx}/order_order.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
		<pg:param name="Uid" value="${order.uid}"/>
		<pg:param name="startTime" value="${startTime}"/>
		<pg:param name="endTime" value="${endTime}"/>
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
</body>
<script>
    $(function () {
		$('#add').click(function(){
			window.location.href="${ctx}/order_add.do";
		 });
    });
    //未通过审批
    $(function () {
		$('#unAgreeOrder').click(function(){
			window.location.href="${ctx}/order_unAgreeOrder.do";
		 });
    });
  //未完成交易
    $(function () {
		$('#unFinishOrder').click(function(){
			window.location.href="${ctx}/order_unFinishOrder.do";
		 });
    });
  //加载日期插件
    $('#startTime').datetimepicker({
    	timepicker:false,
    	format:'Y-m-d',
    	formatDate:'Y-m-d',
    	lang:'ch',
    });
    //加载日期插件
    $('#endTime').datetimepicker({
    	timepicker:false,
    	format:'Y-m-d',
    	formatDate:'Y-m-d',
    	lang:'ch',
    });
</script>