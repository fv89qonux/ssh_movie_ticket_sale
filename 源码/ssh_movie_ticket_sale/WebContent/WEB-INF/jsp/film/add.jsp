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
    <link rel="stylesheet" href="${ctx}/resource/manage1/common/css/jquery.datetimepicker.css"   >
    <script type="text/javascript" src="${ctx}/resource/manage/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/jquery.sorted.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/ckform.js"></script>
    <script type="text/javascript" src="${ctx}/resource/manage/js/common.js"></script>
      <script src="${ctx}/resource/manage1/js/WebCalendar.js"></script> 
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
<form action="film_exAdd.do" method="post" class="definewidth m20" id="hh" enctype="multipart/form-data">
<table class="table table-bordered table-hover definewidth m10">
     <tr>
        <td width="10%" class="tableleft">影片名称</td>
        <td><input type="text" name="name" id="name" value="${film.name}"/></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">影片描述</td>
        <td><textarea type="text" name="remark" rows="4" cols="20" id="remark" value="${film.remark}"></textarea></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">影片价格</td>
        <td><input type="text" name="price" id="price" value="${film.price}"/></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">影片图片</td>
        <td><input type="file" name="file" id="" value="${film.image}"/></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">开始时间</td>
        <td>
        <a href="javascript:void(0);" id="Calendar" onclick="SelectDateById('startTime','yyyy-MM-dd hh:mm')" title="请点击这里选取日期。">
        <input type="text" name="startTime" id="startTime" value="${startTime}"/></a>
        </td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">结束时间</td>
      <td>
        <a href="javascript:void(0);" id="Calendar" onclick="SelectDateById('endTime','yyyy-MM-dd hh:mm')" title="请点击这里选取日期。">
        <input type="text" name="endTime" id="endTime" value="${endTime}"/></a>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">是否推荐</td>
          <td> <input type="radio" name="isRecommend" value="1"/>&nbsp;&nbsp;&nbsp;&nbsp;是&nbsp;&nbsp;&nbsp;
          <input type="radio" name="isRecommend" value="0"/>&nbsp;&nbsp;&nbsp;&nbsp;否&nbsp;&nbsp;&nbsp;
          </td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="button" class="btn btn-primary" id="save" type="button">保存</button> &nbsp;&nbsp;
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
