<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglibs.jsp"%>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
		<c:if test="${session.loginName==null }">
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ctx}/login_login.do?role=1">用户登录</a>|</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ctx}/login_register.do">用户注册</a>|
			</li>
			
    </c:if>
    <li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ctx}/login_login.do?role=2" target="_blank">后台管理登录</a>|
			</li>
           <c:if test="${session.loginName!=null }">
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
                    你好：${session.loginName}
				|</li>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ctx}/user_findUserInfo.do">个人信息</a>
			|</li>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ctx}/order_findByUserId.do">我的订单</a>
			|</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ctx}/login_tuichu.do?role=1">退出</a>
			</li>
   </c:if>
		
		</ul>
	</div>
	<div class="cart">
		<a href="${ctx}/cart_myCart.do">购物车</a>
	</div>
	<div class="phone">
		客服热线: <strong>96008/53277764</strong>
	</div>
</div>
<div class="span24">
	<ul class="mainNav">
		<li><a href="${ctx}/login_index.do?role=1">首页</a> |</li>
		  <c:forEach items="${session.pager.datas}" var="category" varStatus="l">
		<%-- 	<li><a href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a> |</li> --%>
			<li><a style="margin: 0px 52px" href="${ctx}/product_findByCid.do?cid=${category.id}" />${category.cname}</a>|</li>
		  </c:forEach>

	</ul>
</div>