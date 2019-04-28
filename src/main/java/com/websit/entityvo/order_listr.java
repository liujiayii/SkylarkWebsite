package com.websit.entityvo;

import java.util.List;

import com.websit.entity.T_sales;

public class order_listr extends T_sales{
	/**
	 * 用户的电话
	 */
	private String phone;
	/**
	 * 昵称
	 */
	private String nickname;

@Override
	public String toString() {
		return "order_listr [phone=" + phone + ", nickname=" + nickname + ", shopinglist=" + shopinglist + "]";
	}

public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

List <shopinglist> shopinglist;

public List<shopinglist> getShopinglist() {
	return shopinglist;
}

public void setShopinglist(List<shopinglist> shopinglist) {
	this.shopinglist = shopinglist;
}
}
