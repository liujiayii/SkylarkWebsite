package com.websit.until;

import java.util.Date;

import com.websit.entity.T_goods;
import com.websit.entity.T_order;
import com.websit.entity.T_sales;
import com.websit.entity.T_shopping;

public class order {
   public static  T_order T_order(String user_id,String order_no,String order_mode,String order_number,double jine,Date cause_time,String remarks,String yongfei,T_goods T_goods,double order_payable) {
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
		T_order.setOrder_payable(order_payable);
	   return T_order;
	   
   }
   public static  T_shopping shopping(String order_no,Integer order_number,double jine,int mum,double Danjia,String id,String shoping_specifications) {
		T_shopping T_shopping = new T_shopping();
		T_shopping.setDanjia(Danjia);
		T_shopping.setNumber(order_number);
		T_shopping.setOrder_id(order_no);
		T_shopping.setProduct_id(id.toString());
		T_shopping.setZongjia(jine);
		T_shopping.setYouhuijine(mum);
		T_shopping.setShoping_specifications(shoping_specifications);
		T_shopping.setState("0");
	   
	   return T_shopping;
	   
   }
   public static T_sales sale(String cause_explain,String cause_type,String order_id,String sales_cause,Date cause_time,String sales_no,String user_id,String Order_state,String Order_number, Double Order_money ) {
	   T_sales T_sales = new T_sales();
	   /**
	    * 判断退款类型
	    */
	   if(cause_type.equals("仅退款")) {
		   T_sales.setCause_type("0");
	   }else if(cause_type.equals("退货退款")) {
		   T_sales.setCause_type("1");
	   }else {
		   T_sales.setCause_type(cause_type);
	   }
		T_sales.setCause_explain(cause_explain);
		
		T_sales.setOrder_id(order_id);
		T_sales.setSales_cause(sales_cause);
		T_sales.setCause_time(cause_time);
		T_sales.setSales_no(sales_no);
		T_sales.setStele("0");
		T_sales.setUser_id(user_id);
		T_sales.setSales_stes(Order_state);
		T_sales.setSales_nunber(Order_number);
		T_sales.setSales_amount(Order_money.toString());
	   
	   
	   return T_sales;
	   
   }
   /**
    * 解密
    */
   public   String  updes(String user_id,String specifications,String id) {
	return null;
	   
   }
   
}
