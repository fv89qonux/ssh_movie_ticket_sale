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
<form action="comment_exUpdate.do" method="post" class="definewidth m20" id="hh">
<table class="table table-bordered table-hover definewidth m10">
     <tr>
        <td width="10%" class="tableleft">评论ID</td>
        <td><input type="text" name="id" id="id" value="${comment.id}" disabled="disabled"/>
        <input type="hidden" name="id" id="id" value="${comment.id}"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">评论影片名</td>
        <td><input type="text" name="name" id="name" value="${comment.film.name}" />
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">评论内容</td>
        <td><input type="text" name="content" id="content" value="${comment.content}"/>
        </td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">评论时间</td>
        <td><input type="text" name="createTime" id="createTime" value="<fmt:formatDate value="${comment.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
        </td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">评论人</td>
        <td><input type="text" name="realName" id="realName" value="${comment.user.realName}" />
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">回复内容</td>
        <td><textarea type="text" name="reply" rows="4" cols="20" id="reply" value="${comment.reply}">${comment.reply}</textarea>
        </td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="button" class="btn btn-primary" id="save" type="button">回复</button> &nbsp;&nbsp;
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