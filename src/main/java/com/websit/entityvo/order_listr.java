package com.websit.entityvo;

import java.util.List;

import com.websit.entity.T_sales;

public class order_listr extends T_sales{
List <shopinglist> shopinglist;

public List<shopinglist> getShopinglist() {
	return shopinglist;
}

public void setShopinglist(List<shopinglist> shopinglist) {
	this.shopinglist = shopinglist;
}
}
