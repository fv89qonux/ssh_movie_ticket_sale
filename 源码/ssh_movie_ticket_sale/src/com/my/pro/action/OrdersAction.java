package com.my.pro.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.io.File;
import java.text.SimpleDateFormat;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.my.pro.utils.Pager;
import com.opensymphony.xwork2.ModelDriven;
import java.util.*;
import com.my.pro.model.*;
import com.my.pro.dto.Cart;
import com.my.pro.dto.CartItem;
import com.my.pro.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分34秒
 */

@Controller("orderAction")
@Scope("prototype")
public class OrdersAction extends ActionSupport implements ModelDriven<Orders>{
	
	private static final long serialVersionUID = 1L;

	//==========model==============
	  private Orders orders;
		@Override
		public Orders getModel() {
			if(orders==null) orders = new Orders();
			return orders;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private FilmSeatService  filmSeatService;
//	@Autowired
//	private FilmService filmService;
	
	//依赖注入 end  dao/service/===
	
	//-------------------------华丽分割线---------------------------------------------
	
	//============自定义参数start=============
	private String startTime; //页面传入的开始时间
	private String endTime; //页面传入的结束时间
	
	 
	//============自定义参数end=============
	
	//-------------------------华丽分割线---------------------------------------------
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	//============文件上传start=======================================================
	private File file;
	//提交过来的file的名字
    private String fileFileName;
    //提交过来的file的MIME类型
    private String fileContentType;
    public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	 //============文件上传end=========================================================
			
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============公=======共=======方=======法==========区=========start============//
	// 生成订单的执行的方法:
	// 生成订单的执行的方法:
			public String saveOrder() {
				// 调用Service完成数据库插入的操作:
				// Order order = new Order();
				// 设置订单的总金额:订单的总金额应该是购物车中总金额:																																	
				// 购物车在session中,从session总获得购物车信息.
				Cart cart = (Cart) ServletActionContext.getRequest().getSession()
						.getAttribute("cart");
				if (cart == null) {
					this.addActionMessage("亲!您还没有购物!");
					return "msg";
				}
				 Calendar calendar = Calendar.getInstance();
				 //订单号
				 orders.setUid(""+calendar.getTime().getTime());
				 orders.setTotal(cart.getTotal());
				// 设置订单的状态
				 orders.setStatus(0); // 0:未付款.
				 orders.setIsDelete(0);
				// 设置订单时间
				 orders.setOrderTime(new Date());
				// 设置订单关联的客户:
				User sessionUser = (User) ServletActionContext.getRequest().getSession()
						.getAttribute("user");
				if (sessionUser == null) {
					this.addActionMessage("亲!您还没有登录!");
					return "msg";
				}
				orders.setUser(sessionUser);
				orders.setIsRemark(0);
				for (CartItem cartItem : cart.getCartItems()) {
					// 订单项的信息从购物项获得的.
					orders.setFilmSeat(cartItem.getFilmSeat());
					orders.setSeat(cartItem.getSeat());
					FilmSeat filmSeat=new FilmSeat();
					filmSeat.setFilm(cartItem.getFilmSeat().getFilm());
					filmSeat.setId(cartItem.getFilmSeat().getId());
					filmSeat.setZ1(cartItem.getFilmSeat().getZ1());
					filmSeat.setZ2(cartItem.getFilmSeat().getZ2());
					filmSeat.setZ3(cartItem.getFilmSeat().getZ3());
					filmSeat.setZ4(cartItem.getFilmSeat().getZ4());
					filmSeat.setZ5(cartItem.getFilmSeat().getZ5());
					filmSeat.setZ6(cartItem.getFilmSeat().getZ6());
					filmSeat.setZ7(cartItem.getFilmSeat().getZ7());
					filmSeat.setZ8(cartItem.getFilmSeat().getZ8());
					filmSeat.setZ9(cartItem.getFilmSeat().getZ9());
					filmSeat.setZ10(cartItem.getFilmSeat().getZ10());
					filmSeat.setZ11(cartItem.getFilmSeat().getZ11());
					filmSeat.setZ12(cartItem.getFilmSeat().getZ12());
					filmSeat.setZ13(cartItem.getFilmSeat().getZ13());
					filmSeat.setZ14(cartItem.getFilmSeat().getZ14());
					filmSeat.setZ15(cartItem.getFilmSeat().getZ15());
					filmSeat.setZ16(cartItem.getFilmSeat().getZ16());
					filmSeat.setZ17(cartItem.getFilmSeat().getZ17());
					filmSeat.setZ18(cartItem.getFilmSeat().getZ18());
					filmSeat.setZ19(cartItem.getFilmSeat().getZ19());
					filmSeat.setZ20(cartItem.getFilmSeat().getZ20());
					filmSeat.setZ21(cartItem.getFilmSeat().getZ21());
					filmSeat.setZ22(cartItem.getFilmSeat().getZ22());
					filmSeat.setZ23(cartItem.getFilmSeat().getZ23());
					filmSeat.setZ24(cartItem.getFilmSeat().getZ24());
					filmSeat.setZ25(cartItem.getFilmSeat().getZ25());
					filmSeat.setZ26(cartItem.getFilmSeat().getZ26());
					filmSeat.setZ27(cartItem.getFilmSeat().getZ27());
					filmSeat.setZ28(cartItem.getFilmSeat().getZ28());
					filmSeat.setZ29(cartItem.getFilmSeat().getZ29());
					filmSeat.setZ30(cartItem.getFilmSeat().getZ30());
					filmSeatService.update(filmSeat);
				}
				ordersService.save(orders);
				List<OrderItem> orderItemList=new ArrayList<>();
				for (CartItem cartItem : cart.getCartItems()) {
					// 订单项的信息从购物项获得的.
					OrderItem orderItem = new OrderItem();
					orderItem.setCount(cartItem.getCount());
					orderItem.setSubtotal(cartItem.getSubtotal());
					orderItem.setFilm(cartItem.getFilm());
					orderItem.setOrders(orders);
					orderItem.setFilmSeat(cartItem.getFilmSeat()); 
					orderItem.setSeat(cartItem.getSeat());
					orderItemService.save(orderItem);
//					order.getOrderItems().add(orderItem);
					orderItemList.add(orderItem);
				}
				// 清空购物车:
				cart.clearCart();
				// 页面需要回显订单信息:
				// 使用模型驱动了 所有可以不使用值栈保存了
				ActionContext.getContext().put("order", orders);
				ActionContext.getContext().put("orderItemList", orderItemList);
//				ActionContext.getContext().put("url", "/order_findByUserId.do");
				return "saveOrder";
			}
		
//	    		// 点击付款生成订单的执行的方法:
			public String saveOrder1() {
				Cart cart = (Cart) ServletActionContext.getRequest().getSession()
						.getAttribute("cart");
			    Orders o =ordersService.getById(orders.getId());
				ActionContext.getContext().put("order", o);
				String hql = "from OrderItem oi  where oi.orders.id = :id and oi.orders.isDelete=0";
					Map<String,Object> alias = new HashMap<String,Object>();
					 alias.put("id", orders.getId());
		     	List<OrderItem> orderItemList=orderItemService.getByHQL(hql,alias);
		     	for (CartItem cartItem : cart.getCartItems()) {
					// 订单项的信息从购物项获得的.
					OrderItem orderItem = new OrderItem();
					orderItem.setCount(cartItem.getCount());
					orderItem.setSubtotal(cartItem.getSubtotal());
					orderItem.setFilm(cartItem.getFilm());
					orderItem.setFilmSeat(cartItem.getFilmSeat());
					orderItem.setOrders(orders);
					orderItemService.save(orderItem);
//					order.getOrderItems().add(orderItem);
					orderItemList.add(orderItem);
				}
				ActionContext.getContext().put("orderItemList", orderItemList);
				return "saveOrder";
			}
//		
			/**
			 *前台用户查看订单
			 * @return
			 */
			public String findByUserId() {
				// 获得用户的id.
				User existUser = (User) ServletActionContext.getRequest().getSession()
						.getAttribute("user");
				if(existUser == null) {
					ActionContext.getContext().put("url", "/login_index.do?role=1");
					return "redirect";
				}
				// 获得用户的id
				Integer userId = existUser.getId();
				// 根据用户的id查询订单:
				Pager<Orders> pagers = ordersService.findByUserId(userId);
				Pager<OrderItem> orderItemList=orderItemService.findByUserId(userId);
//				List<OrderItem>  orderItemsList=orderItemList.getDatas();
//				 Map<String,Object> alias = new HashMap<String,Object>();
//					StringBuffer sb = new StringBuffer();
//					    sb = sb.append("from Comment where 1=1  and isDelete=0");
//						 sb.append(" and user.id  = :userId");
//						 sb.append(" and film.id  = :filmId");
//						 alias.put("filmId",  orderItemList.getDatas().get(0).getFilm().getId());
//						 alias.put("userId", userId);
//				    	sb = sb.append(" order by id desc");
//				List<Comment> cList=commentService.getByHQL(sb.toString(), alias);
//				ActionContext.getContext().put("isReply", cList.get(0).getIsReply());
//				  String hql = "from Comment where user.id  = :userId and film.id  = :filmId  and isDelete=0 order by id desc";
//		   	      Map<String,Object> alias = new HashMap<String,Object>();
//		  		   alias.put("userId", userId );
//		  			for (OrderItem orderItem : orderItemsList) {
//		  				 alias.put("filmId", orderItem.getFilm().getId() );
//				  		   List<Comment> cList = commentService.getByHQL(hql, alias);
//				  		  if(cList.size()>0){
//				  			   ActionContext.getContext().put("isReply", cList.get(0).getIsReply());
//				  		   }else{
//				  			  ActionContext.getContext().put("isReply", 0);
//				  		   }
//					}
				// 将PageBean数据带到页面上.
				ActionContext.getContext().put("pagers", pagers);
				ActionContext.getContext().put("orderItemList", orderItemList);
				return "findByUid";
			}
		
		
			// 修改订单的状态:付款
			public String payOrder(){
				Orders currOrder = ordersService.getById(orders.getId());
				currOrder.setStatus(1);
				ordersService.update(currOrder);
				ActionContext.getContext().put("url", "/order_findByUserId.do");
				return "redirect";
			}
		
			// 修改订单的状态:取消订单
			public String cancelOrder1(){
			    Orders currOrder =ordersService.getById(orders.getId());
				currOrder.setStatus(3);
				ordersService.update(currOrder);
				ActionContext.getContext().put("url", "/order_findByUserId.do");
				return "redirect";
			}
	
	/**
	 * 列表分页查询
	 * @throws Exception 
	 */
	public String order() throws Exception{
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Orders where 1=1 and isDelete=0 ");
		if(startTime != null && !"".equals(startTime)){
			sb.append(" and orderTime >= :startTime");
		}
		if(endTime != null && !"".equals(endTime)){
			sb.append(" and orderTime < :endTime");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(startTime != null && !"".equals(startTime)){
			alias.put("startTime", sdf.parse(startTime+" 00:00:00"));
		}
		if(endTime != null && !"".equals(endTime)){
			alias.put("endTime", sdf.parse(endTime+" 23:59:59"));
		}
		sb = sb.append(" order by id desc");
		Pager<Orders> pagers =ordersService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("order", orders);
		return SUCCESS;
    }
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String add(){
		return SUCCESS;
	}
	
	/**
	 * 执行添加
	 * @return
	 */
	public String exAdd(){
		ordersService.save(orders);
		ActionContext.getContext().put("url", "/orders_orders.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		Orders n = ordersService.getById(orders.getId());
		ActionContext.getContext().put("order", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		Orders n = ordersService.getById(orders.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 */
	public String exUpdate(){
		ordersService.update(orders);
		ActionContext.getContext().put("url", "/orders_orders.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
//		ordersService.delete(orders.getId());
		Orders n = ordersService.getById(orders.getId());//逻辑删除
		n.setIsDelete(1);
		ordersService.update(n);
		ActionContext.getContext().put("url", "/order_order.do");
		return "redirect";
	}
	
	
	/**
	 *  修改订单的状态:取消订单
	 * @return
	 */
	public String cancelOrder2(){
		Orders n = ordersService.getById(orders.getId());
		n.setStatus(3);
		ordersService.update(n);
		ActionContext.getContext().put("url", "/order_order.do");
		return "redirect";
	}

	/**
	 *  修改订单的状态:已经审核
	 * @return
	 */
	public String confirm(){
		Orders n = ordersService.getById(orders.getId());
		n.setStatus(2);
		ordersService.update(n);
		ActionContext.getContext().put("url", "/order_order.do");
		return "redirect";
	}
	
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
