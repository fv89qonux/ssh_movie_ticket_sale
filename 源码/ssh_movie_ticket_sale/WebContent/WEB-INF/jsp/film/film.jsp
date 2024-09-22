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
 
<form class="form-inline definewidth m20" action="film_film.do" method="post">  
 影片名称：<input type="text" name="name" id="name"class="abc input-default" placeholder="" value="${film.name}">&nbsp;&nbsp;
<%--       <input type="radio" name="isRecommend" value="1" <c:if test="${film.isRecommend == 1 }"> checked="checked" </c:if>/>只看推荐 &nbsp;&nbsp; --%>
<%--       <input type="radio" name="isDiscount" value="1" <c:if test="${film.isDiscount == 1 }"> checked="checked" </c:if>/>只看优惠 &nbsp;&nbsp; --%>
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
    <button type="button" class="btn btn-success" id="add">新增影片</button>
</form>
<table class="table table-bordered table-hover definewidth m10" align="center">
    <thead>
    <!--   p private int id;
    private String filmType;//汽车型号
    private filmCategory filmCategory;//汽车品牌
    private String filmNumber;//车牌号
    private String filmOilType;//汽油型号
    private String dailyPrice;//单日租金
    private String  distance;//行驶里程
    private String filmImage;//图片
    private int isRecommend;//是否推荐：0:无推荐  1:是为推荐
    private int isDiscount;//是否优惠：0:无推荐 1：是为优惠
    private int  isDelete; //0:不删除 1：删除-->
    <tr>
        <th>影片编号ID</th>
        <th>电影名称</th>
        <th>影片价格</th>
        <th>影片图片</th>
        <th>播放时间</th>
        <th>是否推荐</th>
<!--         <th>状态</th> -->
        <th>操作</th>
    </tr>
    </thead>
     <c:forEach items="${pagers.datas}" var="film" varStatus="l">
      <tr >
            <td align="center">${film.id}</td>
            <td>${film.name}</td>
            <td>${film.price}</td>
            <td><img src="${ctx}/${film.image}" style="height: 30px;width: 50px"></td>
<%--             <td><fmt:formatDate value="${film.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>-- --%>
<%--                 <fmt:formatDate value="${film.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/> --%>
<!--             </td> -->
            <td>${film.startTime}--
                ${film.endTime}
            </td>
            <td>
               <c:if test="${film.isRecommend == 0 }">
                                          无推荐                         
               </c:if>
               <c:if test="${film.isRecommend == 1 }">
                                             是推荐
               </c:if>
            </td>
<!--             <td> -->
<%--                <c:if test="${film.isDelete == 0 }"> --%>
<!--                                               正常 -->
<%--                </c:if> --%>
<%--                <c:if test="${film.isDelete == 1 }"> --%>
<!--                                              删除 -->
<%--                </c:if> --%>
<!--             </td> -->
             <td>
                   <a id="update" href="${ctx}/film_update.do?id=${film.id}">修改</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   <a id="update" href="${ctx}/film_delete.do?id=${film.id}" onclick= "if(confirm( '是否删除！ ')==false)return   false; ">删除</a>
            </td>
        </tr>
     </c:forEach>
 </table>
 <div class="panel-foot text-center">
      <pg:pager  url="${ctx}/film_film.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
		<pg:param name="name" value="${name}"/>
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
			window.location.href="${ctx}/film_add.do";
		 });
    });

//     function del(id)
// 	{
// 		if(confirm("确定要删除吗？"))
// 		{
// 			url="${ctx}/userlogin/delnode?id="+id;
//     		$.ajax({
//     			//cache: true,
//     			type : "post",
//     			url : url,
//     			dataType :'json',
//     			async : false,
//     			error : function(request) {
//     				return false;
//     			},
//     			success : function(data) {
//     				console.log(data)
//     				if(data.status ==1){
// 						 alert(data.desc);
// 						 window.location.href="${ctx}/userlogin/Node";
// 					 }else{
// 						 alert(data.desc);
// 				 }
//     			}
//     		});		
// 		}
// 	}
</script>