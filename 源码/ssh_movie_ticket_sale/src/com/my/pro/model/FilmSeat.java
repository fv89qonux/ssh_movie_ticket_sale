package com.my.pro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="film_seat")
public class FilmSeat {
	private int id;
	private Film film;//与电影表关联
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
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
    @ManyToOne
    @JoinColumn(name="film_id")
    public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
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
    
	
  
    
  

}
