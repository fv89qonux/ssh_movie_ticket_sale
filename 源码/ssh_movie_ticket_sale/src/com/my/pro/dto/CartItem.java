package com.my.pro.dto;

import com.my.pro.model.Film;
import com.my.pro.model.FilmSeat;

/**
 * 购物项对象
 * 
 *
 */
public class CartItem {
	private Film film;	// 购物项中商品信息
	private int count;			// 购买某种商品数量
	private double subtotal;	// 购买某种商品小计
	private FilmSeat filmSeat;
	private String seat;
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	// 小计自动计算的.
	public double getSubtotal() {
		return count * film.getPrice();
	}
	/*public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	*/
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
