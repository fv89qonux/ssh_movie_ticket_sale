package com.my.pro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.swing.JPopupMenu.Separator;

@Entity
@Table(name="order_item")
public class OrderItem {
	private int id;
	private int count;//个数
	private Double subtotal;//小计
	private Film film; //跟电影关联
	private Orders orders;//跟订单表关联
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
    @ManyToOne
    @JoinColumn(name="film_id")
    public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	
    @ManyToOne
	@JoinColumn(name="orders_id")
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
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
