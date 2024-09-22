package com.my.pro.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders{
	private int id;
    private String Uid; //订单编号
    private Date orderTime;//订单时间
    private double total;//订单金额
    private int status; //订单状态0:未付款 1：已付款 2:交易完成（已审核） 3：取消订单
    private User user;//与下定单的用户管理
	private int  isDelete; //0:不删除 1：删除
    private int isRemark;
    private FilmSeat  filmSeat;
    private String seat;
    
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public String getUid() {
		return Uid;
	}
	public void setUid(String uid) {
		Uid = uid;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    @ManyToOne
    @JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public int getIsRemark() {
		return isRemark;
	}
	public void setIsRemark(int isRemark) {
		this.isRemark = isRemark;
	}
	
	@ManyToOne
    @JoinColumn(name="film_seat_id")
	public FilmSeat getFilmSeat() {
		return filmSeat;
	}
	public void setFilmSeat(FilmSeat filmSeat) {
		this.filmSeat = filmSeat;
	}
	
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}

	
  
    
}