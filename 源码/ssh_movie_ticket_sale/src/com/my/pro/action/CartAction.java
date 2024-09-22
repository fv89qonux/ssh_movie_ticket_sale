package com.my.pro.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

import com.my.pro.dto.Cart;
import com.my.pro.dto.CartItem;
import com.my.pro.model.Film;
import com.my.pro.model.FilmSeat;
import com.my.pro.service.FilmSeatService;
import com.my.pro.service.FilmService;

@Controller("cartAction")
@Scope("prototype")
public class CartAction extends ActionSupport {
	// 接收pid
	private Integer pid;
	// 接收数量count
	private Integer count;
	
	private String z;
	
	public String getZ() {
		return z;
	}

	public void setZ(String z) {
		this.z = z;
	}

	private int z1;//是否有人坐 0：无 1：有
	private int z2;//是否有人坐 0：无 1：有
	private int z3;//是否有人坐 0：无 1：有
	private int z4;//是否有人坐 0：无 1：有
	private int z5;//是否有人坐 0：无 1：有
	private int z6;//是否有人坐 0：无 1：有
	private int z7;//是否有人坐 0：无 1：有
	private int z8;//是否有人坐 0：无 1：有
	private int z9;//是否有人坐 0：无 1：有
	private int z10;//是否有人坐 0：无 1：有
	private int z11;//是否有人坐 0：无 1：有
	private int z12;//是否有人坐 0：无 1：有
	private int z13;//是否有人坐 0：无 1：有
	private int z14;//是否有人坐 0：无 1：有
	private int z15;//是否有人坐 0：无 1：有
	private int z16;//是否有人坐 0：无 1：有
	private int z17;//是否有人坐 0：无 1：有
	private int z18;//是否有人坐 0：无 1：有
	private int z19;//是否有人坐 0：无 1：有
	private int z20;//是否有人坐 0：无 1：有
	private int z21;//是否有人坐 0：无 1：有
	private int z22;//是否有人坐 0：无 1：有
	private int z23;//是否有人坐 0：无 1：有
	private int z24;//是否有人坐 0：无 1：有
	private int z25;//是否有人坐 0：无 1：有
	private int z26;//是否有人坐 0：无 1：有
	private int z27;//是否有人坐 0：无 1：有
	private int z28;//是否有人坐 0：无 1：有
	private int z29;//是否有人坐 0：无 1：有
	private int z30;//是否有人坐 0：无 1：有
	
	public int getZ1() {
		return z1;
	}

	public void setZ1(int z1) {
		this.z1 = z1;
	}

	public int getZ2() {
		return z2;
	}

	public void setZ2(int z2) {
		this.z2 = z2;
	}

	public int getZ3() {
		return z3;
	}

	public void setZ3(int z3) {
		this.z3 = z3;
	}

	public int getZ4() {
		return z4;
	}

	public void setZ4(int z4) {
		this.z4 = z4;
	}

	public int getZ5() {
		return z5;
	}

	public void setZ5(int z5) {
		this.z5 = z5;
	}

	public int getZ6() {
		return z6;
	}

	public void setZ6(int z6) {
		this.z6 = z6;
	}

	public int getZ7() {
		return z7;
	}

	public void setZ7(int z7) {
		this.z7 = z7;
	}

	public int getZ8() {
		return z8;
	}

	public void setZ8(int z8) {
		this.z8 = z8;
	}

	public int getZ9() {
		return z9;
	}

	public void setZ9(int z9) {
		this.z9 = z9;
	}

	public int getZ10() {
		return z10;
	}

	public void setZ10(int z10) {
		this.z10 = z10;
	}

	public int getZ11() {
		return z11;
	}

	public void setZ11(int z11) {
		this.z11 = z11;
	}

	public int getZ12() {
		return z12;
	}

	public void setZ12(int z12) {
		this.z12 = z12;
	}

	public int getZ13() {
		return z13;
	}

	public void setZ13(int z13) {
		this.z13 = z13;
	}

	public int getZ14() {
		return z14;
	}

	public void setZ14(int z14) {
		this.z14 = z14;
	}

	public int getZ15() {
		return z15;
	}

	public void setZ15(int z15) {
		this.z15 = z15;
	}

	public int getZ16() {
		return z16;
	}

	public void setZ16(int z16) {
		this.z16 = z16;
	}

	public int getZ17() {
		return z17;
	}

	public void setZ17(int z17) {
		this.z17 = z17;
	}

	public int getZ18() {
		return z18;
	}

	public void setZ18(int z18) {
		this.z18 = z18;
	}

	public int getZ19() {
		return z19;
	}

	public void setZ19(int z19) {
		this.z19 = z19;
	}

	public int getZ20() {
		return z20;
	}

	public void setZ20(int z20) {
		this.z20 = z20;
	}

	public int getZ21() {
		return z21;
	}

	public void setZ21(int z21) {
		this.z21 = z21;
	}

	public int getZ22() {
		return z22;
	}

	public void setZ22(int z22) {
		this.z22 = z22;
	}

	public int getZ23() {
		return z23;
	}

	public void setZ23(int z23) {
		this.z23 = z23;
	}

	public int getZ24() {
		return z24;
	}

	public void setZ24(int z24) {
		this.z24 = z24;
	}

	public int getZ25() {
		return z25;
	}

	public void setZ25(int z25) {
		this.z25 = z25;
	}

	public int getZ26() {
		return z26;
	}

	public void setZ26(int z26) {
		this.z26 = z26;
	}

	public int getZ27() {
		return z27;
	}

	public void setZ27(int z27) {
		this.z27 = z27;
	}

	public int getZ28() {
		return z28;
	}

	public void setZ28(int z28) {
		this.z28 = z28;
	}

	public int getZ29() {
		return z29;
	}

	public void setZ29(int z29) {
		this.z29 = z29;
	}

	public int getZ30() {
		return z30;
	}

	public void setZ30(int z30) {
		this.z30 = z30;
	}

	@Autowired
	private FilmService  filmService;
	
	@Autowired
	private FilmSeatService  filmSeatService;


	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	// 将购物项添加到购物车:执行的方法
	public String addCart() {
		// 封装一个CartItem对象.
		CartItem cartItem = new CartItem();
		// 设置数量:
		cartItem.setCount(count);
		// 根据pid进行查询商品:
		Film film = filmService.getById(pid);
		  String hql = "from FilmSeat where film.id  = :filmId order by id desc";
   	      Map<String,Object> alias = new HashMap<String,Object>();
  		   alias.put("filmId", film.getId());
		FilmSeat filmSeat=filmSeatService.getOneByHql(hql, alias);
        JSONObject jsonObject = JSONObject.fromObject(z);//
        String z1=jsonObject.getString("z1");
        String z2=jsonObject.getString("z2");
        String z3=jsonObject.getString("z3");
        String z4=jsonObject.getString("z4");
        String z5=jsonObject.getString("z5");
        String z6=jsonObject.getString("z6");
        String z7=jsonObject.getString("z7");
        String z8=jsonObject.getString("z8");
        String z9=jsonObject.getString("z9");
        String z10=jsonObject.getString("z10");
        String z11=jsonObject.getString("z11");
        String z12=jsonObject.getString("z12");
        String z13=jsonObject.getString("z13");
        String z14=jsonObject.getString("z4");
        String z15=jsonObject.getString("z15");
        String z16=jsonObject.getString("z16");
        String z17=jsonObject.getString("z17");
        String z18=jsonObject.getString("z18");
        String z19=jsonObject.getString("z19");
        String z20=jsonObject.getString("z20"); 
        String z21=jsonObject.getString("z21");
        String z22=jsonObject.getString("z22");
        String z23=jsonObject.getString("z23");
        String z24=jsonObject.getString("z24");
        String z25=jsonObject.getString("z25");
        String z26=jsonObject.getString("z26");
        String z27=jsonObject.getString("z27");
        String z28=jsonObject.getString("z28");
        String z29=jsonObject.getString("z29");
        String z30=jsonObject.getString("z30");
        String seat="";
        if (Integer.parseInt(z1)==1) {
        	seat+="第一排1号"+",";
		}
        if (Integer.parseInt(z2)==1) {
        	seat+="第一排2号"+",";
		}
        if (Integer.parseInt(z3)==1) {
        	seat+="第一排3号"+",";
		}
        if (Integer.parseInt(z4)==1) {
        	seat+="第一排4号"+",";
		}
        if (Integer.parseInt(z5)==1) {
        	seat+="第一排5号"+",";
		}
        if (Integer.parseInt(z6)==1) {
        	seat+="第一排6号"+",";
		}
        if (Integer.parseInt(z7)==1) {
        	seat+="第二排1号"+",";
		}
        if (Integer.parseInt(z8)==1) {
        	seat+="第二排2号"+",";
		}
        if (Integer.parseInt(z9)==1) {
        	seat+="第二排3号"+",";
		}
        if (Integer.parseInt(z10)==1) {
        	seat+="第二排4号"+",";
		}
        if (Integer.parseInt(z11)==1) {
        	seat+="第二排5号"+",";
		}
        if (Integer.parseInt(z12)==1) {
        	seat+="第二排6号"+",";
		}
        if (Integer.parseInt(z13)==1) {
        	seat+="第三排1号"+",";
		}
        if (Integer.parseInt(z14)==1) {
        	seat+="第三排2号"+",";
		}
        if (Integer.parseInt(z15)==1) {
        	seat+="第三排3号"+",";
		}
        if (Integer.parseInt(z16)==1) {
        	seat+="第三排4号"+",";
		}
        if (Integer.parseInt(z17)==1) {
        	seat+="第三排5号"+",";
		}
        if (Integer.parseInt(z18)==1) {
        	seat+="第三排6号"+",";
		}
        if (Integer.parseInt(z19)==1) {
        	seat+="第四排1号"+",";
		}
        if (Integer.parseInt(z20)==1) {
        	seat+="第四排2号"+",";
		}
        if (Integer.parseInt(z21)==1) {
        	seat+="第四排3号"+",";
		}
        if (Integer.parseInt(z22)==1) {
        	seat+="第四排4号"+",";
		}
        if (Integer.parseInt(z23)==1) {
        	seat+="第四排5号"+",";
		}
        if (Integer.parseInt(z24)==1) {
        	seat+="第四排6号"+",";
		}
        if (Integer.parseInt(z25)==1) {
        	seat+="第五排1号"+",";
		}
        if (Integer.parseInt(z26)==1) {
        	seat+="第五排2号"+",";
		}
        if (Integer.parseInt(z27)==1) {
        	seat+="第五排3号"+",";
		}
        if (Integer.parseInt(z28)==1) {
        	seat+="第五排4号"+",";
		}
        if (Integer.parseInt(z29)==1) {
        	seat+="第五排5号"+",";
		}
        if (Integer.parseInt(z30)==1) {
        	seat+="第五排6号";
		}
       
        if (filmSeat.getZ1()==0) {
        	filmSeat.setZ1(Integer.parseInt(z1));
		}else{
			filmSeat.setZ1(1);
		}
        if (filmSeat.getZ2()==0) {
        	filmSeat.setZ2(Integer.parseInt(z2));
		}else{
			filmSeat.setZ2(1);
		}
        if (filmSeat.getZ3()==0) {
        	filmSeat.setZ3(Integer.parseInt(z3));
		}else{
			filmSeat.setZ3(1);
		}
        if (filmSeat.getZ4()==0) {
        	filmSeat.setZ4(Integer.parseInt(z4));
		}else{
			filmSeat.setZ4(1);
		}
        if (filmSeat.getZ5()==0) {
        	filmSeat.setZ5(Integer.parseInt(z5));
		}else{
			filmSeat.setZ5(1);
		}
        if (filmSeat.getZ6()==0) {
        	filmSeat.setZ6(Integer.parseInt(z6));
		}else{
			filmSeat.setZ6(1);
		}
        if (filmSeat.getZ7()==0) {
        	filmSeat.setZ7(Integer.parseInt(z7));
		}else{
			filmSeat.setZ7(1);
		}
        if (filmSeat.getZ8()==0) {
        	filmSeat.setZ8(Integer.parseInt(z8));
		}else{
			filmSeat.setZ8(1);
		}
        if (filmSeat.getZ9()==0) {
        	filmSeat.setZ9(Integer.parseInt(z9));
		}else{
			filmSeat.setZ9(1);
		}
        if (filmSeat.getZ10()==0) {
        	filmSeat.setZ10(Integer.parseInt(z10));
		}else{
			filmSeat.setZ10(1);
		}
        if (filmSeat.getZ11()==0) {
        	filmSeat.setZ11(Integer.parseInt(z11));
		}else{
			filmSeat.setZ11(1);
		}
        if (filmSeat.getZ12()==0) {
        	filmSeat.setZ12(Integer.parseInt(z12));
		}else{
			filmSeat.setZ12(1);
		}
        if (filmSeat.getZ13()==0) {
        	filmSeat.setZ13(Integer.parseInt(z13));
		}else{
			filmSeat.setZ13(1);
		}
        if (filmSeat.getZ14()==0) {
        	filmSeat.setZ14(Integer.parseInt(z14));
		}else{
			filmSeat.setZ14(1);
		}
        if (filmSeat.getZ15()==0) {
        	filmSeat.setZ15(Integer.parseInt(z15));
		}else{
			filmSeat.setZ15(1);
		}
        if (filmSeat.getZ16()==0) {
        	filmSeat.setZ16(Integer.parseInt(z16));
		}else{
			filmSeat.setZ16(1);
		}
        if (filmSeat.getZ17()==0) {
        	filmSeat.setZ17(Integer.parseInt(z17));
		}else{
			filmSeat.setZ17(1);
		}
        if (filmSeat.getZ18()==0) {
        	filmSeat.setZ8(Integer.parseInt(z8));
		}else{
			filmSeat.setZ18(1);
		}
        if (filmSeat.getZ19()==0) {
        	filmSeat.setZ19(Integer.parseInt(z19));
		}else{
			filmSeat.setZ19(1);
		}
        if (filmSeat.getZ20()==0) {
        	filmSeat.setZ20(Integer.parseInt(z20));
		}else{
			filmSeat.setZ20(1);
		}
        if (filmSeat.getZ21()==0) {
        	filmSeat.setZ21(Integer.parseInt(z21));
		}else{
			filmSeat.setZ21(1);
		}
        if (filmSeat.getZ22()==0) {
        	filmSeat.setZ22(Integer.parseInt(z22));
		}else{
			filmSeat.setZ22(1);
		}
        if (filmSeat.getZ23()==0) {
        	filmSeat.setZ23(Integer.parseInt(z23));
		}else{
			filmSeat.setZ23(1);
		}
        if (filmSeat.getZ24()==0) {
        	filmSeat.setZ24(Integer.parseInt(z24));
		}else{
			filmSeat.setZ24(1);
		}
        if (filmSeat.getZ25()==0) {
        	filmSeat.setZ25(Integer.parseInt(z25));
		}else{
			filmSeat.setZ25(1);
		}
        if (filmSeat.getZ26()==0) {
        	filmSeat.setZ26(Integer.parseInt(z26));
		}else{
			filmSeat.setZ6(1);
		}
        if (filmSeat.getZ27()==0) {
        	filmSeat.setZ27(Integer.parseInt(z27));
		}else{
			filmSeat.setZ27(1);
		}
        if (filmSeat.getZ28()==0) {
        	filmSeat.setZ28(Integer.parseInt(z28));
		}else{
			filmSeat.setZ28(1);
		}
        if (filmSeat.getZ29()==0) {
        	filmSeat.setZ29(Integer.parseInt(z29));
		}else{
			filmSeat.setZ29(1);
		}
        if (filmSeat.getZ30()==0) {
        	filmSeat.setZ30(Integer.parseInt(z30));
		}else{
			filmSeat.setZ30(1);
		}
		filmSeat.setZ2(Integer.parseInt(z2));
		filmSeat.setZ3(Integer.parseInt(z3));
		filmSeat.setZ4(Integer.parseInt(z4));
		filmSeat.setZ5(Integer.parseInt(z5));
		filmSeat.setZ6(Integer.parseInt(z6));
		filmSeat.setZ7(Integer.parseInt(z7));
		filmSeat.setZ8(Integer.parseInt(z8));
		filmSeat.setZ9(Integer.parseInt(z9));
		filmSeat.setZ10(Integer.parseInt(z10));
		filmSeat.setZ11(Integer.parseInt(z11));
		filmSeat.setZ12(Integer.parseInt(z12));
		filmSeat.setZ13(Integer.parseInt(z13));
		filmSeat.setZ14(Integer.parseInt(z14));
		filmSeat.setZ15(Integer.parseInt(z15));
		filmSeat.setZ16(Integer.parseInt(z16));
		filmSeat.setZ17(Integer.parseInt(z17));
		filmSeat.setZ18(Integer.parseInt(z18));
		filmSeat.setZ19(Integer.parseInt(z19));
		filmSeat.setZ20(Integer.parseInt(z20));
		filmSeat.setZ21(Integer.parseInt(z21));
		filmSeat.setZ22(Integer.parseInt(z22));
		filmSeat.setZ23(Integer.parseInt(z23));
		filmSeat.setZ24(Integer.parseInt(z24));
		filmSeat.setZ25(Integer.parseInt(z25));
		filmSeat.setZ26(Integer.parseInt(z26));
		filmSeat.setZ27(Integer.parseInt(z27));
		filmSeat.setZ28(Integer.parseInt(z28));
		filmSeat.setZ29(Integer.parseInt(z29));
		filmSeat.setZ30(Integer.parseInt(z30));
//		filmSeatService.update(filmSeat);
		cartItem.setFilmSeat(filmSeat);
		cartItem.setSeat(seat);
		// 设置商品:
		cartItem.setFilm(film);
		// 将购物项添加到购物车.
		// 购物车应该存在session中.
		Cart cart = getCart();
		cart.addCart(cartItem);

		return "addCart";
	}

	// 清空购物车的执行的方法:
	public String clearCart(){
		// 获得购物车对象.
		Cart cart = getCart();
		// 调用购物车中清空方法.
		cart.clearCart();
		return "clearCart";
	}
	
	// 从购物车中移除购物项的方法:
	public String removeCart(){
		// 获得购物车对象
		Cart cart = getCart();
		// 调用购物车中移除的方法:
		cart.removeCart(pid);
		// 返回页面:
		return "removeCart";
	}
	
	// 我的购物车:执行的方法
	public String myCart(){
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			this.addActionMessage("亲!您还没有购物!");
			return "myCart";
		}else{
		   return "myCart";
		}
	}
	
	/**
	 * 获得购物车的方法:从session中获得购物车.
	 * @return
	 */
	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession()
					.setAttribute("cart", cart);
		}
		return cart;
	}
}
