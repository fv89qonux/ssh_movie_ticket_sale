<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<title>电影院</title>
<link href="${ctx}/resource/web/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resource/web/css/product.css" rel="stylesheet" type="text/css"/>
<style>

/* .demo{width:700px; margin:40px auto 0 auto; min-height:450px;} */
@media screen and (max-width: 360px) {.demo {width:340px}}

.front{width: 300px;margin: 5px 32px 45px 32px;background-color: #f0f0f0;	color: #666;text-align: center;padding: 3px;border-radius: 5px;}
.booking-details {float: right;position: relative;width:200px;height: 450px; }
.booking-details h3 {margin: 5px 5px 0 0;font-size: 16px;}
.booking-details p{line-height:26px; font-size:16px; color:#999}
.booking-details p span{color:#666}
div.seatCharts-cell {color: #182C4E;height: 25px;width: 40px;line-height: 25px;margin: 3px;float: left;text-align: center;outline: none;font-size: 13px;}
div.seatCharts-seat {color: #fff;cursor: pointer;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;}
div.seatCharts-row {height: 35px;}
div.seatCharts-seat.available {background-color: #B9DEA0;}
div.seatCharts-seat.focused {background-color: #76B474;border: none;}
div.seatCharts-seat.selected {background-color: #E6CAC4;}
div.seatCharts-seat.unavailable {background-color: #472B34;cursor: not-allowed;}
div.seatCharts-container {/* border-right: 1px dotted #adadad;float: left; */padding: 20px;margin:0 auto;width: 400px;}
div.seatCharts-legend {padding-left: 0px;position: absolute;bottom: 16px;}
ul.seatCharts-legendList {padding-left: 0px;}
.seatCharts-legendItem{float:left; width:90px;margin-top: 10px;line-height: 2;}
span.seatCharts-legendDescription {margin-left: 5px;line-height: 30px;}
.checkout-button {display: block;width:80px; height:24px; line-height:20px;margin: 10px auto;border:1px solid #999;font-size: 14px; cursor:pointer}
#selected-seats {max-height: 150px;overflow-y: auto;overflow-x: none;width: 200px;}
#selected-seats li{float:left; width:72px; height:26px; line-height:26px; border:1px solid #d3d3d3; background:#f7f7f7; margin:6px; font-size:14px; font-weight:bold; text-align:center}
.modal{position: absolute;top:0;left:0;height:100%;width:100%;z-index:999;display: none;}
.modal-dialog{background-color: #000;opacity:0.2;height:100%;width:100%;}
.modal-header{border-bottom:1px dotted #000;padding:10px;}
.modal-content{position: absolute;top:50%;left:50%;margin-left: -220px;margin-top: -170px;    background-color: #fff; padding: 20px; border-radius: 8px;}
.close{float: right;border:none;background-color: #fff;cursor:pointer;}
.modal-title{font-size: 18px; text-align: center;}
.btn{float:right;border-radius:3px;padding:6px 12px;background-color: #B9DEA0;}
</style>
<script>
	function saveCart(){

		checkSeat();
		document.getElementById("cartForm").submit();
	}
</script>

</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a>
				<img src="${ctx}/resource/web/image/r___________renleipic_01/61.jpg"  style="width: 189px; height: 50px;"alt="KTV"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
<%-- 					<img src="${ctx}/resource/web/image\r___________renleipic_01/header.jpg" alt="正品保障" title="正品保障" height="50" width="320"> --%>
</div>	</div>
	
		<%@ include file="/common/menu.jsp" %>

</div><div class="container productContent">
		
		<div class="span18 last">
			
			<div class="productImage">
					<a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="http://image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg" rel="gallery">
						<div class="zoomPad"><img style="opacity: 1;" title="" class="medium" src="${ctx}/${product.image}"><div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup"></div><div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;" class="zoomWindow"><div style="width: 368px;" class="zoomWrapper"><div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div><div style="width: 0%; height: 0px;" class="zoomWrapperImage"><img src="%E5%B0%9A%E9%83%BD%E6%AF%94%E6%8B%89%E5%A5%B3%E8%A3%852013%E5%A4%8F%E8%A3%85%E6%96%B0%E6%AC%BE%E8%95%BE%E4%B8%9D%E8%BF%9E%E8%A1%A3%E8%A3%99%20%E9%9F%A9%E7%89%88%E4%BF%AE%E8%BA%AB%E9%9B%AA%E7%BA%BA%E6%89%93%E5%BA%95%E8%A3%99%E5%AD%90%20%E6%98%A5%E6%AC%BE%20-%20Powered%20By%20Mango%20Team_files/6d53c211-2325-41ed-8696-d8fbceb1c199-large.jpg" style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;"></div></div></div><div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div></div>
					</a>
				
			</div>
			<div class="name"><span style="font-size:25px">影片名称：${product.name}</span></div>
			<div class="sn" style="margin-top: 18px;">
				<div><span>编号：${product.id}</span></div>
			</div>
			<div class="info">
				<dl style="margin-top: 20px;">
					<dt style="font-size:14px;">价格:</dt>
					<dd>
						<strong>￥：${product.price} 元</strong>
<!-- 						参 考 价： -->
<!-- 							<del>￥1000000元</del> -->
					</dd>
				</dl>
					<dl style="margin-top: 50px;">
						<dt style="font-size:14px;">放映时间:</dt>
						<dd>
							<span style="font-weight:bold;font-size:13px">${product.startTime}--
				                ${product.endTime}</span>
				            
						</dd>
					</dl>
					<dl>
						<dt>    </dt>
						<dd>
							<span>    </span>
						</dd>
					</dl>
			</div>
			<form id="cartForm" action="${ctx}/cart_addCart.do" method="post" >
				<input type="hidden" name="pid" value="${product.id }"/>
				<input type="hidden" name="z" value=""/>
				<div class="action" style="margin-top: 18px;">
						<dl class="quantity">
							<dt>数量:</dt>
							<dd>
								<input id="count" name="count" value="0" maxlength="4" onpaste="return false;" type="text"/>
							</dd>
							<dd>
								件（先选择座位，自动算出数量）
							</dd>
						</dl>
						
					<div class="buy">
							<input id="addCart" class="addCart" value="加入购物车" type="button" onclick="saveCart()"/>
						    <input id="chooseSeat" class="addCart" value="选择座位" type="button" onclick="selectSeat()" style="margin-left: 30px"/>
					</div>
				</div>
			</form>
			<div id="bar" class="bar">
				<ul>
						<li id="introductionTab">
							<a href="#introduction">影片介绍</a>
						</li>
				</ul>
			</div>
				
				<div id="introduction" name="introduction" class="introduction">
					<div class="title">
						<strong>${product.remark}</strong>
					</div>
					<div>
						<img src="${ctx}/${product.image}">
					</div>
				</div>
				
				<div id="bar" class="bar">
				<ul>
						<li id="introductionTab">
							<a href="#introduction">影片评论</a>
						</li>
						
				</ul>
			</div>
				<div id="introduction" name="introduction" class="introduction">
			    <c:forEach items="${cList}" var="comment" varStatus="l">
						<p>评论内容：${comment.content}</p>
					    <p>评论时间：${comment.createTime}</p>
					    <p>评论人：${comment.user.realName}</p>
					    <c:if test="${comment.reply !=null }">
					     <p>回复内容：${comment.reply}</p>
					     <p>回复时间：${comment.replyTime}</p>
						 </c:if> 
				 </c:forEach>
				</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
<!-- 		<div class="footerAd"> -->
<%-- 					<img src="${ctx}/resource/web/image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950"> --%>
<!-- </div> -->
</div>
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
<!-- 模态框（Modal） -->
<div class="modal">
    <div class="modal-dialog">
    </div><!-- /.modal -->
    <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">请选择座位</h4>
            </div>
            <div class="modal-body">
				<div class="demo">
			   		<div id="seat-map">
						<div class="front">屏幕</div>					
					</div>
					<div class="booking-details" style="display:none;">
						<p>影片：<span>星际穿越</span></p>
						<p>时间：<span>11月14日 21:00</span></p>
						<p>座位：</p>
						<ul id="selected-seats"></ul>
						<p>票数：<span id="counter">0</span></p>
						<p>总计：<b>￥<span id="total">0</span></b></p>
								
						<button class="checkout-button">确定购买</button>
								
						<div id="legend"></div>
					</div>
					<div style="clear:both"></div>
			   </div>
			</div>
            <div class="modal-footer">
                <button type="button" class="btn close">确定</button>
            </div>
        </div><!-- /.modal-content -->
</div>
<script src="${ctx}/resource/manage/js/jquery-1.10.2.js"></script>
<script src="${ctx}/resource/web/js/bootstrap.min.js"></script>
<script src="${ctx}/resource/web/js/jquery.seat-charts.min.js"></script>
<script>


var price = 80; //票价
var args = new GetRequest();
var hasSellArray = [];
$(document).ready(function() {
	$("#chooseSeat").on("click",function(){
		$(".modal").css("display","block");
	})
	$(".close").on("click",function(){
		$(".modal").css("display","none");
	})
	var $cart = $('#selected-seats'), //座位区
	$counter = $('#counter'), //票数
	$total = $('#total'); //总计金额
	var sc = $('#seat-map').seatCharts({
		map: [  //座位图
			'aaaaaa',
			'aaaaaa',
			'aaaaaa',
			'aaaaaa',
			'aaaaaa'
		],
		naming : {
			top : false,
			getLabel : function (character, row, column) {
				return column;
			}
		},
		legend : { //定义图例
			node : $('#legend'),
			items : [
				[ 'a', 'available',   '可选座' ],
				[ 'a', 'unavailable', '已售出']
			]					
		},
		click: function () { //点击事件
			if (this.status() == 'available') { //可选座
				$('<li>'+(this.settings.row+1)+'排'+this.settings.label+'座</li>')
					.attr('id', 'cart-item-'+this.settings.id)
					.data('seatId', this.settings.id)
					.appendTo($cart);
				$("#count").val(parseInt($("#count").val())+1);
				$counter.text(sc.find('selected').length+1);
				$total.text(recalculateTotal(sc)+price);		
				return 'selected';
			} else if (this.status() == 'selected') { //已选中
					//更新数量
					$counter.text(sc.find('selected').length-1);
					//更新总计
					$total.text(recalculateTotal(sc)-price);
						
					//删除已预订座位
					$('#cart-item-'+this.settings.id).remove();
					$("#count").val(parseInt($("#count").val())-1);
					//可选座	
					return 'available';
			} else if (this.status() == 'unavailable') { //已售出
				return 'unavailable';
			} else {
				return this.style();
			}
		}
	});
	//已售出的座位
	//sc.get(['1_2', '4_4','4_5','6_6','6_7','8_5','8_6','8_7','8_8', '10_1', '10_2']).status('unavailable');
	$.ajax({
		url:'${ctx}/filmSeat_getFilmSeatById.do?filmId='+args['id'],
		data:{},
		method:'GET',
		aysnc:'false',
		success:function(data){
			for(var i=1;i<=30;i++){
				var key = 'z'+i;
				if(data.result[0][key]==1||data.result[0][key]=='1'){
					var seatNum = '';
					if(i%6==0){
						seatNum = parseInt(i/6)+'_6';
					}else{
						seatNum = (parseInt(i/6)+1)+'_'+i%6;
					}
					hasSellArray.push(seatNum);
				}
			}
			console.log(hasSellArray)
			sc.get(hasSellArray).status('unavailable');
		},
		error:function(){
			alert("初始化信息失败！")
		}
	})
});
//计算总金额
function recalculateTotal(sc) {
	var total = 0;
	sc.find('selected').each(function () {
		total += price;
	});
	return total;
}
//记录座位
function checkSeat(){
	var seatArray = {
			"z1":0,
            "z2":0,
            "z3":0,
            "z4":0,
            "z5":0,
            "z6":0,
            "z7":0,
            "z8":0,
            "z9":0,
            "z10":0,
            "z11":0,
            "z12":0,
            "z13":0,
            "z14":0,
            "z15":0,
            "z16":0,
            "z17":0,
            "z18":0,
            "z19":0,
            "z20":0,
            "z21":0,
            "z22":0,
            "z23":0,
            "z24":0,
            "z25":0,
            "z26":0,
            "z27":0,
            "z28":0,
            "z29":0,
            "z30":0,
	};
	$("#seat-map .seatCharts-seat").each(function(){
		if($(this).hasClass("selected")){
			//console.log($(this).prop("id"))
			var seat = $(this).prop("id");
			var s = seat.split("_");
			var seatNumKey = 'z'+(parseInt((s[0]-1)*6)+parseInt(s[1]));
			seatArray[seatNumKey] = 1;
			//console.log(seatNumKey)
		}
	})
	$("input[name=z]").val(JSON.stringify(seatArray))
	//console.log(JSON.stringify(seatArray));
}
function GetRequest() {   
	   var url = location.search; //获取url中"?"符后的字串   
	   var theRequest = new Object();   
	   if (url.indexOf("?") != -1) {   
	      var str = url.substr(1);   
	      strs = str.split("&");   
	      for(var i = 0; i < strs.length; i ++) {   
	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
	      }   
	   }   
	   return theRequest;   
	}  
</script>
</body>
</html>