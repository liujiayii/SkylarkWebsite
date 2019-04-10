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
			
		}  else {
			
			
			
		}
			
	
		return JsonUtil.getResponseJson(cood, msg, null, null);
}
}
