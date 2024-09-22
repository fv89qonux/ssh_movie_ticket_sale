<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!-- 评价界面 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/resource/manage/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/manage/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/manage/css/style.css" />
    <script type="text/javascript" src="${ctx}/resource/manage/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/jquery.sorted.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/ckform.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/common.js"></script>
	<title>管理后台登陆</title>
  <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
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

.table th,
.table td {
  padding: 8px;
  line-height: 20px;
  text-align: left;
  vertical-align: top;
  border-top: 1px solid #dddddd;
}
    </style>

</head>
<body>
<form action="order_exUpdate.do" method="post" class="definewidth m20" id="hh">
<table class="table table-bordered table-hover definewidth m10">
     <tr>
        <td width="10%" class="tableleft">订单ID</td>
        <td><input type="text" name="id" id="id" value="${order.id}" disabled="disabled"/>
        <input type="hidden" name="id" id="id" value="${order.id}"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">订单编号</td>
        <td><input type="text" name="uid" id="uid" value="${order.uid}" disabled="disabled"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">订单时间</td>
        <td><input type="text" name="orderTime" id="orderTime" value="${order.orderTime}" disabled="disabled"/>
        </td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">用户名</td>
        <td><input type="text" name="realName" id="realName" value="${order.user.realName}" disabled="disabled"/>
        </td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">电话</td>
        <td><input type="text" name="phone" id="phone" value="${order.user.phone}" disabled="disabled"/>
        </td>
    </tr>
    <tr>
       <td width="10%" class="tableleft">座位号</td>
           <td>
							${order.seat}	
							</td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">订单金额</td>
        <td><input type="text" name="total" id="total" value="${order.total}"/>
        </td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">订单状态</td>
        <td>
      <c:if test="${order.status==0}">
                                     未付款  
      </c:if>
     <c:if test="${order.status==1}">
                                    已付款   
      </c:if>
       <c:if test="${order.status==2}">
                                 交易成功
      </c:if>
      <c:if test="${order.status==3}">
                                  订单已取消
      </c:if>
      </td>
     </tr>
</table>
</form>
</body>
<script>
    $(function () { 
    	$("#save").click(function(){
    		$("#hh").submit();
    	});
    	

    });
</script>