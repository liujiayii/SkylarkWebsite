package com.websit.entityvo;

import com.websit.entity.T_product;

/**
 * 购物车列表
 * @author xxx
 *
 */
public class lt_trolleylst  extends  T_product {
	/*
	 * 购物车id
	 */
	private  String trolley_id;
	/**
	 * 购物车数量
	 */
	private  String number;
	/**
	 * 优惠金额
	 */
	private  String youhuijine;
	/* * 优惠金额
	 */
	private  Integer numbers;
	
	
	public Integer getNumbers() {
		return numbers;
	}
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}
	public String getYouhuijine() {
		return youhuijine;
	}
	public void setYouhuijine(String youhuijine) {
		this.youhuijine = youhuijine;
	}
	public String getTrolley_id() {
		return trolley_id;
	}
	public void setTrolley_id(String trolley_id) {
		this.trolley_id = trolley_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "lt_trolleylst [trolley_id=" + trolley_id + ", number=" + number + ", youhuijine=" + youhuijine
				+ ", numbers=" + numbers + "]";
	}

	
   
}
