package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;

import com.websit.entity.T_order;
import com.websit.entity.T_product;
import com.websit.entity.T_shopping;
import com.websit.service.IT_goodsService;
import com.websit.service.IT_salesService;
import com.websit.service.IT_shoppingService;
import com.websit.service.IT_trolleyService;
import com.websit.until.JsonUtil;
import com.websit.until.OrderCodeFactory;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import  com.websit.entity.T_trolley;;
/**
 * <p>
 * 商品订单表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-23
 */
@Controller
@RequestMapping("/t_shopping")
public class T_shoppingController {
	@Autowired
	public com.websit.service.IT_orderService IT_orderService;
	@Autowired
	public  IT_shoppingService  T_shoppingService;
	@Autowired
	public IT_salesService T_salesService;
	@Autowired
	private IT_goodsService goodsService;
	@Autowired
	public IT_trolleyService T_trolleyService;
	Date cause_time = new Date();
	@RequestMapping("/t_shopping")
    public   String  Commoditypurchase(String []str,Integer id,Integer  order_number,String order_mode,String user_id ) {
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		boolean fig=false;
		if(user_id==null||user_id.equals(" ")) {
			msg="请重新登录";
			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
		String  order_no=OrderCodeFactory.getOrderCode(8L);
		Integer numbers = IT_orderService.Queryinginventory(id.toString());//查询商品信息
		T_product product = IT_orderService.Querysteda(id.toString());//查询商品的信息
		if (order_number > numbers) {
			cood = -1;
			msg = "库存数量不足，请修改购买数量";
		} else if (product.getState() == 2) {
		    cood = -1;
			msg = "商品已下架";
			
		}  else if (str.length==0){
			
		T_order  T_order=new T_order();
		Double jiage=product.getPrice().doubleValue()*order_number;
		int mum=IT_orderService.selectpase(id.toString(),jiage);//查询优惠价格
		double jine=jiage-mum;
		T_order.setUser_id(user_id);
		T_order.setOrder_no(order_no);
		T_order.setOrder_state("0");
		T_order.setOrder_mode(order_mode);
		T_order.setOrder_number(order_number.toString());
		T_order.setOrder_money(jine);
		T_order.setOrder_time(cause_time);
		/**
		 * 查询运费
		 */
		Integer  yongfei=IT_orderService.yunfei(jiage);
		System.out.println("yunfei"+yongfei);
		T_order.setOrder_id(id);
		T_order.setYunfei(yongfei.toString());
		
		fig=IT_orderService.insert(T_order);
		T_shopping T_shopping=new T_shopping();
		T_shopping.setDanjia(product.getPrice().doubleValue());
		T_shopping.setNumber(order_number);
		T_shopping.setOrder_id(order_no);
		T_shopping.setProduct_id(id.toString());
		T_shopping.setZongjia(jine);
		T_shopping.setYouhuijine(mum);
		fig=T_shoppingService.insert(T_shopping);
		/*
		 *  减去库存
		 */
		IT_orderService.updatenumbergoumai(order_number, id.toString());	
			
			
		}else {
			  String [] str1= str;
			  double zongjia=0; Integer number=0;//总价，数量
			  double ddzongjia=0;
			  T_trolley T_trolley=new T_trolley();
			  for(int i=0;i<str1.length;i++) {
			T_trolley=T_trolleyService.selectById(str1[i]);
			System.out.println(T_trolley);
			T_product T_product=new T_product();
			T_product=T_trolleyService.T_produc(T_trolley.getProduct_id().toString());
			T_shopping T_shopping=new T_shopping();
			T_shopping.setDanjia(T_product.getPrice().doubleValue());
			T_shopping.setNumber(T_trolley.getNumber());//商品数量
			T_shopping.setProduct_id(T_trolley.getProduct_id().toString());
			T_shopping.setOrder_id(order_no);
			}

				T_order  T_order=new T_order();
			
				T_order.setUser_id(user_id);
				T_order.setOrder_no(order_no);
				T_order.setOrder_state("0");
				T_order.setOrder_mode(order_mode);
				T_order.setOrder_number(number.toString());
				T_order.setOrder_money(ddzongjia);
				T_order.setOrder_time(cause_time);
				/**
				 * 查询运费
				 */
				Integer  yongfei=IT_orderService.yunfei(zongjia);
				
				T_order.setYunfei(yongfei.toString());
				fig=IT_orderService.insert(T_order);		
		}
		System.err.println(user_id+"00000000000000000000000000000000000000000000000000");
	
		
		
		return JsonUtil.getResponseJson(cood, msg, null, order_no);
		
}
}
