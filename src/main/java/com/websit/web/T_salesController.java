package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.T_order;
import com.websit.entity.T_sales;
import com.websit.entityvo.th_list;
import com.websit.service.IT_alipay_refundService;
import com.websit.service.IT_salesService;
import com.websit.until.JsonUtil;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 退货表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Controller
@RequestMapping("/t_sales")
public class T_salesController {
	@Autowired
	public IT_salesService T_salesService;
	@Autowired
	public com.websit.service.IT_orderService IT_orderService;
	@Autowired
	public IT_alipay_refundService alipay_refundService;
	@RequestMapping("/upodate")
	@ResponseBody
	public String updatestale(Integer sales_id,String stale,String order_id,String upstale) {//主键，更新的状态，订单主键，订单状态
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		boolean fig=false;
		boolean fig1=false;
		T_sales T_sales=T_salesService.selectById(sales_id);
		T_order T_order=IT_orderService.selectById(order_id);
	 if(T_sales.getCause_type().equals("0")) {
		System.err.println(T_sales);//退货状态0,审核中，1审核通过，2，审核失败  3.等待发货4、已收货，并退款
		if(T_sales.getCause_type().equals("0")) {
		if(stale.equals("1")) {
			if(T_order.getOrder_payment().equals("0")) {//支付宝web
			//调用退款方法
			//fig1=alipay_refundService.refund("9566","200",null);
			fig1=alipay_refundService.refund(T_order.getOrder_no().toString(),T_order.getOrder_money().toString(),null);
			}else if(T_order.getOrder_payment().equals("1")) {//支付宝app
				
			}
                else if(T_order.getOrder_payment().equals("2")) {//微信web
				
			}
                else if(T_order.getOrder_payment().equals("3")) {//微信app
    				
    			}
			
			
			if(fig1) {
			IT_orderService.ordercancelled(order_id, "6");
			fig=T_salesService.updatestale(stale,sales_id);
			}
		}else{
			IT_orderService.ordercancelled(order_id, "7");
			if(upstale.equals(5)) {
			fig=T_salesService.updatestale(stale,sales_id);
			}
		}
       }
	 }else { 
		 
		 if (upstale.equals("8")){
			 if(T_order.getOrder_payment().equals("0")) {//支付宝web
					//调用退款方法
					//fig1=alipay_refundService.refund("9566","200",null);
					fig1=alipay_refundService.refund(T_order.getOrder_no().toString(),T_order.getOrder_money().toString(),null);
					}else if(T_order.getOrder_payment().equals("1")) {//支付宝app
						
					}
		                else if(T_order.getOrder_payment().equals("2")) {//微信web
						
					}
		                else if(T_order.getOrder_payment().equals("3")) {//微信app
		    				
		    		}
					if(fig1) {
			           IT_orderService.ordercancelled(order_id, "6");
			           fig=T_salesService.updatestale("1",sales_id);
					}
			
		 }else if(upstale.equals("5")) {
			 IT_orderService.ordercancelled(order_id, "8");
				fig=T_salesService.updatestale(stale,sales_id);
			}else {
		     IT_orderService.ordercancelled(order_id, "7");
		 	if(upstale.equals("5")) {
				fig=T_salesService.updatestale(stale,sales_id);
				}
		 
	 }
		    
	 }
		if(fig) {
			cood = 1;
			msg = "操作成功";
		}else {
			cood = -1;
			msg = "操作失败";
		}
		
	 
		return JsonUtil.getResponseJson(cood, msg, null, null);
	 
	}
	/**
	 * 退货审核列表
	 */
	@RequestMapping("/thlist")
	@ResponseBody
	
	public  String  thshlist(String date,RowBounds RowBounds,Integer page,Integer limit) {
		String msg = "系统异常，请稍后再试";
		List<th_list> ter=null;
		int  cent=0;
		Integer cood = 1;
		page=(page-1)*limit;
		try {
			//cent=1T_salesService;
	    cent=T_salesService.selectCount(null);
	    
		ter=T_salesService.th_list(date, new RowBounds(page,limit));
		 if (ter.size()>0) {
			 msg="查询成功"; 
			 cood=1;
		 }else {
			 msg="查询成功"; 
			 cood=1; 
		 }
		} catch (Exception e) {
			 msg="查询失敗"; 
			 cood=-1;
		}
		
		
		return JsonUtil.getResponseJson(cood, msg, cent, ter);
	}
	
	
	
}
