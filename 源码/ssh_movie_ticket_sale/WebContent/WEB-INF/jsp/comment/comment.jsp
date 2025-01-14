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
    <script type="text/javascript" src="${ctx}/resource/manage/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/ckform.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/common.js"></script>
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
 
<table class="table table-bordered table-hover definewidth m10" align="center">
    <thead>
    <tr>
        <th>评论ID</th>
        <th>评论影片名</th>
        <th>评论内容</th>
        <th>评论时间</th>
        <th>评论人</th>
        <th>回复内容</th>
        <th>回复时间</th>
        <th>操作</th>
    </tr>
    </thead>
     <c:forEach items="${pagers.datas}" var="comment" varStatus="l">
      <tr >
            <td align="center">${comment.id}</td>
            <td>${comment.film.name}</td>
            <td>${comment.content}</td>
            <td><fmt:formatDate value="${comment.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${comment.user.realName}</td>
            <td>${comment.reply}</td>
            <td><fmt:formatDate value="${comment.replyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
             <td>
              <c:if test="${comment.isReply==0 }">
				 <a id="update" href="${ctx}/comment_update.do?id=${comment.id}">回复</a>
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      </c:if>
                   <a id="update" href="${ctx}/comment_delete.do?id=${comment.id}" onclick= "if(confirm( '是否删除！ ')==false)return   false; ">删除</a>
            </td>
        </tr>
     </c:forEach>
 </table>
 <div class="panel-foot text-center">
      <pg:pager  url="${ctx}/comment_comment.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
<%-- 		<pg:param name="adminName" value="${admin.adminName}"/> --%>
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
			window.location.href="${ctx}/comment_add.do";
		 });
    });
</script>