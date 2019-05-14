package com.websit.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.T_order;
import com.websit.entity.T_sales;
import com.websit.entity.T_shopping;
import com.websit.service.IT_goodsService;
import com.websit.service.IT_productService;
import com.websit.service.IT_salesService;
import com.websit.service.IT_shoppingService;
import com.websit.service.IT_trolleyService;
import com.websit.until.JsonUtil;
import com.websit.until.OrderCodeFactory;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Controller
@RequestMapping("/shopping")
public class T_shoppingController {
	@Autowired
	public com.websit.service.IT_orderService IT_orderService;
	@Autowired
	public IT_shoppingService T_shoppingService;
	@Autowired
	public IT_salesService T_salesService;
	@Autowired
	private IT_goodsService goodsService;
	@Autowired
	public IT_trolleyService T_trolleyService;
	@Autowired
	public IT_productService T_productService;
	/**
	 * 商品发货
	 * @param order_id
	 * @param productid
	 * @return
	 */
	@RequestMapping("/logistics")
	@ResponseBody
	public String logistics(String shoping_logistics,Long shoping_id) {
		String msg="";
		try {
			T_shopping T_shopping=T_shoppingService.selectById(shoping_id);
			Map<String, Object> columnMap = new HashMap<String, Object>();
			columnMap.put("order_no", T_shopping.getOrder_id());
		
			List<T_order> T_order=IT_orderService.selectByMap(columnMap);
			
			Map<String, Object> column = new HashMap<String, Object>();
			column.put("order_id", T_shopping.getOrder_id());
			column.put("state","1");
			int fig=T_shoppingService.selectByMap(column).size();
		   if(fig<=1) {
			   for(int i=0;i<T_order.size();i++) {
				   T_order.get(i).setOrder_state("2");
				   boolean tr= IT_orderService.updateById(T_order.get(i));
				  // System.out.println();
			   }
			   
		   }
		
		   fig=T_shoppingService.logistics(shoping_logistics, shoping_id,"2");
		 
		 if(fig>0) {
			 msg="发货成功";
		 }else {
			 msg="发货异常";
		 }
		
		 return JsonUtil.getResponseJson(1, msg, null, null);
	} catch (Exception e) {
		return JsonUtil.getResponseJson(-1, "出问题了，整个人都感觉不好了", null, null);		}
	}
	/**
	 * 确认收货
	 * @param order_id
	 * @param productid
	 * @return
	 */
	@RequestMapping("/Confirmreceipt")
	@ResponseBody
	public String Confirmreceipt(Long shoping_id) {
		String msg="";
		try {
			T_shopping T_shopping=T_shoppingService.selectById(shoping_id);
			Map<String, Object> columnMap = new HashMap<String, Object>();
			columnMap.put("order_no", T_shopping.getOrder_id());
		
			List<T_order> T_order=IT_orderService.selectByMap(columnMap);
			
			Map<String, Object> column = new HashMap<String, Object>();
			column.put("order_id", T_shopping.getOrder_id());
			column.put("state","1");
			Map<String, Object> column1 = new HashMap<String, Object>();
			column1.put("order_id", T_shopping.getOrder_id());
			column1.put("state","2");
			int fig=T_shoppingService.selectByMap(column).size()+T_shoppingService.selectByMap(column1).size();
		   if(fig<=1) {
			   for(int i=0;i<T_order.size();i++) {
				   T_order.get(i).setOrder_state("2");
				   boolean tr= IT_orderService.updateById(T_order.get(i));
				 //  System.out.println();
			   }
			   
		   }
		
		   fig=T_shoppingService.logistics(T_shopping.getShoping_logistics(), shoping_id,"3");
		 
		 if(fig>0) {
			 msg="确认收货成功";
		 }else {
			 msg="发货异常";
		 }
		
		 return JsonUtil.getResponseJson(1, msg, null, null);
	} catch (Exception e) {
		return JsonUtil.getResponseJson(-1, "出问题了，整个人都感觉不好了", null, null);		}
	}
	/**
	 * 商品发货
	 * @param order_id
	 * @param productid
	 * @return
	 */
	@RequestMapping("/sales")
	@ResponseBody
	public String sales (Long shoping_id,String cause_explain, String cause_type,String sales_cause) {
		String msg="";
		try {
			T_shopping T_shopping=T_shoppingService.selectById(shoping_id);
			if(T_shopping.getState().equals("5")) {
				msg="退货正在审核，请耐心等待";
			}else {
			Map<String, Object> columnMap = new HashMap<String, Object>();
			columnMap.put("order_no", T_shopping.getOrder_id());
			
			List<T_order> T_order=IT_orderService.selectByMap(columnMap);
			
			Map<String, Object> column = new HashMap<String, Object>();
			column.put("order_id", T_shopping.getOrder_id());
			column.put("state","3");
			Map<String, Object> column2 = new HashMap<String, Object>();
			column.put("order_id", T_shopping.getOrder_id());
			column.put("state","1");
			Map<String, Object> column1 = new HashMap<String, Object>();
			column1.put("order_id", T_shopping.getOrder_id());
			column1.put("state","2");
			int fig=T_shoppingService.selectByMap(column).size()+T_shoppingService.selectByMap(column1).size()+T_shoppingService.selectByMap(column2).size();
			 String sales_no = OrderCodeFactory.getOrderCode(8L);// 生产订单编号
			Date cause_time = new Date();
			T_sales T_sales = new T_sales();
			T_sales.setCause_explain(cause_explain);
			T_sales.setCause_type(cause_type);
			T_sales.setOrder_id(T_order.get(0).getOrder_id().toString());
			T_sales.setSales_cause(sales_cause);
			T_sales.setCause_time(cause_time);
			T_sales.setSales_no(sales_no);
			T_sales.setStele("0");
			T_sales.setUser_id(T_order.get(0).getUser_id());
			T_sales.setSales_stes(T_order.get(0).getOrder_state());
			T_sales.setSales_nunber(T_shopping.getNumber().toString());
			T_sales.setSales_amount(T_shopping.getZongjia().toString());
			boolean	ig=T_salesService.insert(T_sales);
			
			
			if(fig<=1) {
			   
			   for(int i=0;i<T_order.size();i++) {
				  
				   T_order.get(i).setOrder_state("5");
				   boolean tr= IT_orderService.updateById(T_order.get(i));
				  // System.out.println();
				   
					
			   }
			   
		   }
			T_shopping.setState("5");
			boolean fig1=T_shoppingService.updateById(T_shopping);
		  // fig=T_shoppingService.logistics(T_shopping.getShoping_logistics(), shoping_id,"5");
		 
		 if(fig>0&&fig1) {
			 msg="申请退货审核成功";
		 }else {
			 msg="发货异常";
		 }
      }
		 return JsonUtil.getResponseJson(1, msg, null, null);
	} catch (Exception e) {
		return JsonUtil.getResponseJson(-1, "出问题了，整个人都感觉不好了", null, null);		
		}
	}
	
	
}
