package com.websit.until;

import java.util.Date;

import com.websit.entity.T_goods;
import com.websit.entity.T_order;
import com.websit.entity.T_shopping;

public class order {
   public  T_order T_order(String user_id,String order_no,String order_mode,String order_number,double jine,Date cause_time,String remarks,String yongfei,T_goods T_goods) {
		T_order T_order = new T_order();
	    T_order.setUser_id(user_id);
		T_order.setOrder_no(order_no);
		T_order.setOrder_state("0");
		T_order.setOrder_mode(order_mode);
		T_order.setOrder_number(order_number.toString());
		T_order.setOrder_money(jine);
		T_order.setOrder_time(cause_time);
		T_order.setRemarks(remarks);
	
		T_order.setYunfei(yongfei);
		T_order.setGoods_Province(T_goods.getGoods_sheng());
		T_order.setGoods_name(T_goods.getGoods_name());
		T_order.setGoods_address(T_goods.getGoods_address());
		T_order.setGoods_city(T_goods.getGoods_shi());
		T_order.setGoods_CountyArea(T_goods.getGoods_xian());
		T_order.setGoods_tel(T_goods.getGoods_tel());
	   return T_order;
	   
   }
   public  T_shopping shopping(String order_no,Integer order_number,double jine,int mum,double Danjia,String id,String shoping_specifications) {
		T_shopping T_shopping = new T_shopping();
		T_shopping.setDanjia(Danjia);
		T_shopping.setNumber(order_number);
		T_shopping.setOrder_id(order_no);
		T_shopping.setProduct_id(id.toString());
		T_shopping.setZongjia(jine);
		T_shopping.setYouhuijine(mum);
		T_shopping.setShoping_specifications(shoping_specifications);
	   
	   return T_shopping;
	   
   }
   public  String sales() {
	   
	   
	   
	   return null;
	   
   }
   
}
