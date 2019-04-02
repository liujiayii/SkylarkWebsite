package com.websit.entityvo;

import java.util.List;

import com.websit.entity.*;

public class order_list extends T_order{

    /**
     * 商品名称
     */
    private String name;
    /**
     * 图片
     */
    private String image;
    /*
     *        商品总价
     */
    private double zongjia;
    
    //**商品信息
    /**
     * 商品订单
     */
    private String order_product_id; 
    public String getOrder_product_id() {
		return order_product_id;
	}
	public void setOrder_product_id(String order_product_id) {
		this.order_product_id = order_product_id;
	}

	/*
     * 收货地址
     */
    private T_goods T_goods;
    public T_goods getT_goods() {
		return T_goods;
	}
	public void setT_goods(T_goods t_goods) {
		T_goods = t_goods;
	}
	public List<shopinglist> getShping() {
		return shping;
	}
	public void setShping(List<shopinglist> shping) {
		this.shping = shping;
	}

	List<shopinglist>   shping;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getZongjia() {
		return zongjia;
	}
	public void setZongjia(double zongjia) {
		this.zongjia = zongjia;
	}
	
	@Override
	public String toString() {
		return "order_list [name=" + name + ", image=" + image + ", zongjia=" + zongjia + ", T_goods=" + T_goods
				+ ", shping=" + shping + "]";
	}
  

}
