package com.websit.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.websit.entity.T_goods;
import com.websit.entity.T_order;
import com.websit.entity.T_product;
import com.websit.entity.T_sales;
import com.websit.entity.T_shopping;
import com.websit.entity.T_trolley;
import com.websit.entityvo.T_orderVo;
import com.websit.entityvo.jiaobiao;
import com.websit.entityvo.order_list;

import com.websit.service.IT_goodsService;
import com.websit.service.IT_productService;
import com.websit.service.IT_salesService;
import com.websit.service.IT_shoppingService;
import com.websit.service.IT_trolleyService;
import com.websit.until.JsonUtil;
import com.websit.until.OrderCodeFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.websit.until.DesUtil;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Controller
@RequestMapping("/t_order")
public class T_orderController {
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
	public IT_productService T_productService;
	Date cause_time = new Date();
	/**
	 * 引入加密类
	 */
	DesUtil DesUtil = new DesUtil();

	@RequestMapping("/Generateorder")
	@ResponseBody
	public String Generateorder(String trolley_id,Integer id,Integer  order_number,String order_mode,String user_id,String remarks  ) {//商品id，数量,地址id
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		boolean fig=false;
		try {
			
		
		String  order_no=OrderCodeFactory.getOrderCode(8L);
		System.out.println(trolley_id+"trolley_id+++++++++++++++++++++++++++");
		
		
		if(user_id==null||user_id.equals(" ")) {
			msg="请重新登录";
			return JsonUtil.getResponseJson(cood, msg, null, null);
		}else if(order_mode==null){
			msg="请填写收货地址";
			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
           
		 else if (trolley_id==null||trolley_id.length()==0){
			 Integer numbers = IT_orderService.Queryinginventory(id.toString());//查询商品信息
			 T_product product = IT_orderService.Querysteda(id.toString());//查询商品的信息
				if (order_number > numbers||order_number==0) {
					cood = -1;
					msg = "库存数量不足，请修改购买数量";
					return JsonUtil.getResponseJson(cood, msg, null, order_no);
				} else if (product.getState() == 2) {
				    cood = -1;
					msg = "商品已下架";
					return JsonUtil.getResponseJson(cood, msg, null, order_no);
				} 	else { 
			
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
		T_order.setRemarks(remarks);
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
			
				}
		}else {
			String[] str = trolley_id.split(","); 
			  String [] str1= str;
			  double zongjia=0; Integer number=0;//总价，数量
			  double ddzongjia=0;
			  double total=0;
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
			zongjia= T_product.getPrice().doubleValue()*T_trolley.getNumber();
			int mum=IT_orderService.selectpase(T_trolley.getProduct_id().toString().toString(),zongjia);//查询优惠价格		
			T_shopping.setZongjia(zongjia-mum);
			T_shopping.setYouhuijine(mum);
			fig=T_shoppingService.insert(T_shopping);
			number=T_trolley.getNumber()+number;
			ddzongjia=ddzongjia+zongjia-mum;
			total=total+zongjia;
			 fig=T_trolleyService.deleteById(T_trolley.getTrolley_id());
				/*
				 *  减去库存
				 */
			
				int ter=IT_orderService.updatenumbergoumai(T_trolley.getNumber(), T_trolley.getProduct_id().toString());
			}	T_order  T_order=new T_order();
			
				T_order.setUser_id(user_id);
				T_order.setOrder_no(order_no);
				T_order.setOrder_state("0");
				T_order.setOrder_mode(order_mode);
				T_order.setOrder_number(number.toString());
				T_order.setOrder_money(total);
				T_order.setOrder_time(cause_time);
				T_order.setRemarks(remarks);
				/**
				 * 查询运费
				 */
				Integer  yongfei=IT_orderService.yunfei(zongjia);
				
				T_order.setYunfei(yongfei.toString());
				fig=IT_orderService.insert(T_order);		
		}
		
	     if(fig) {
	    	 cood=1;
	    	 msg="商品购买成功";
	     }else {
	    	 cood=-1;
	    	 msg="商品购买成功";
	     }
		return JsonUtil.getResponseJson(cood, msg, null, order_no);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
		
}/**
	 * 订单取消,发货，签收，
	 */
	@RequestMapping("/ordercan")
	@ResponseBody
	public String ordercancelled(String order_id,String order_state,String cause_explain,String cause_type,String sales_cause,String order_shouhuo_id) {//主键,订单状态,退货原因,退货类型,退货说明
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;			
		System.out.println(order_id+"rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
				int fig=0;
				String  sales_no=OrderCodeFactory.getOrderCode(8L);
				if(order_state.equals("0")) {
					 fig=IT_orderService.ordercancelled(order_id,order_state);
				}else if(order_state.equals("1")) {
					 //fig=IT_orderService.ordercancelled(order_id,order_state);
				}else if(order_state.equals("2")) {
					IT_orderService.updatewuliudanhao(order_id,order_shouhuo_id);
					
					
					 fig=IT_orderService.ordercancelled(order_id,order_state);
					 
				}else if(order_state.equals("3")) {
					 fig=IT_orderService.ordercancelled(order_id,order_state);
				}else if(order_state.equals("4")) {
					 fig=IT_orderService.ordercancelled(order_id,order_state);
				}else if(order_state.equals("5")) {
					
				
					T_sales T_sales=new T_sales();
					T_sales.setCause_explain(cause_explain);
					T_sales.setCause_type(cause_type);
					T_sales.setOrder_id(order_id);
					T_sales.setSales_cause(sales_cause);
					T_sales.setCause_time(cause_time);
					T_sales.setSales_no(sales_no);
					T_sales.setStele("0");;
					System.out.println(T_sales+"+++++++++++++++++++++++++++++++++++++++++++++++");
					T_salesService.insert(T_sales);
					 fig=IT_orderService.ordercancelled(order_id,order_state);
					 
				}else if(order_state.equals("8")) {
					 fig=IT_orderService.ordercancelled(order_id,"5");
				}else {
					 fig=IT_orderService.ordercancelled(order_id,order_state);
				}
				if(fig>0) {
					cood = 1;
					msg = "操作成功";
				}
				else {
					cood = -1;
					msg = "操作失败";
				}
	
		return JsonUtil.getResponseJson(cood, msg, null, sales_no);
	
	}
	/**
	 * user_id 用户id
	 * 订单列表
	 * order_state 订单状态
	 */
	
	@RequestMapping("/orderlist")
	@ResponseBody
	public String orderlist(String id,String user_id,String order_state,RowBounds RowBounds,Integer page,Integer limit) {//
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		System.out.println("user_id"+user_id+"order_state"+order_state+"page"+page+"limit"+limit);
        if(user_id==""||user_id=="undefined"||page==null||limit==null) {
        	 cood=152369;
        	msg="用户数据不正确，请重新登录";
        }
        else if(user_id==null||user_id.equals(" ")) {
			msg="请重新登录";
			return JsonUtil.getResponseJson(cood, msg, null, null);
		}else {
		List <order_list> orderlist=IT_orderService.order_list(user_id,order_state,new RowBounds(page,limit),id);
		for(int i=0;i<orderlist.size();i++ ) {
		
			orderlist.get(i).setT_goods(goodsService.selectById(orderlist.get(i).getOrder_mode()));
			
			
			orderlist.get(i).setShping(IT_orderService.shopinglist(orderlist.get(i).getOrder_no()));
		}
		
			
		Map<String, Object> columnMap=new HashMap<String,Object>(); 
		columnMap.put("user_id", user_id);
		if(order_state!=null) {
		columnMap.put("order_state", order_state);
		}
		int num2=IT_orderService.selectByMap(columnMap).size();
				if(orderlist.size()>0) {
					cood = 1;
					msg = "查询成功";
				}
				else {
					cood = 1;
					msg = "查询成功";
					
				}
		
	
		return JsonUtil.getResponseJson(cood, msg, num2, orderlist);
		}
        return JsonUtil.getResponseJson(cood, msg, null, null);
	}

	
	
	/**
	 * @Title: selectAllSecond
	 * @description 查询个人没有评价的商品列表
	 * @param @return    
	 * @return List<T_reviewVo>    
	 * @author linghongyu
	 * @createDate 2019年3月24日
	 */
	@RequestMapping("/selectAllSecond")
	@ResponseBody
	public String selectAllSecond(long user_id) {
		try {
			List<T_orderVo> some =IT_orderService.selectAllSecond(user_id);
			if (some.size()>=0) {
				return JsonUtil.getResponseJson(1, "查询成功", null, some);
			} else {
				return JsonUtil.getResponseJson(2, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
		
	}
	
	/**
	 * user_id 用户id
	 *   web后台订单列表
	 * order_state 订单状态
	 */
	@RequestMapping("/orderweblist")
	@ResponseBody
	public String orderweblist(String order_state,RowBounds RowBounds,Integer page,Integer limit,String date ) {//
		page=page-1;
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		try {
			
		
			int num2=IT_orderService.selectCount(null);
		List <order_list> orderlist=IT_orderService.order_list1(order_state,new RowBounds(page,limit),date);
		for(int i=0;i<orderlist.size();i++ ) {
			orderlist.get(i).setT_goods(goodsService.selectById(orderlist.get(i).getOrder_mode()));
			System.out.println(goodsService.selectById(orderlist.get(i).getOrder_mode())+"9999999999999999999999999");
			orderlist.get(i).setShping(IT_orderService.shopinglist(orderlist.get(i).getOrder_no()));
		}
	
			
				if(orderlist.size()>0) {
					cood = 1;
					msg = "查询成功";
				}
				else {
					cood = 1;
					msg = "查询成功";
					
				}
		
		
		return JsonUtil.getResponseJson(cood, msg, num2, orderlist);
		
	} catch (Exception e) {
		return JsonUtil.getResponseJson(cood, msg, null, null);
	}
	
	}
	/**
	 * user_id 用户id
	 * 查询优惠和运费
	 * order_state 订单状态
	 */
	@RequestMapping("/qeryunfeiyouhui")
	@ResponseBody
	public String qeryunfeiyouhui(String trolley_id) {
		String[] str = trolley_id.split(","); 
		  String [] str1= str;
		 T_trolley T_trolley=new T_trolley();
		  
		  double zongjia=0; Integer number=0;//总价，数量
		  double ddzongjia=0;
		  double total=0;
		for(int i=0;i<str1.length;i++) {
			T_trolley=T_trolleyService.selectById(str1[i]);
			int mum=IT_orderService.selectpase(T_trolley.getProduct_id().toString(),zongjia);//查询优惠价格
			number=T_trolley.getNumber()+number;
			
			total=total+zongjia;
			ddzongjia=mum+ddzongjia;
		}
		T_order  T_order=new T_order();
		
		Integer  yongfei=IT_orderService.yunfei(total);
		
		return JsonUtil.getResponseJson(1, "查询成功", yongfei,ddzongjia );
		
		
	}
	/**
	 * user_id 用户id
	 * 查询库存
	 * order_state 订单状态
	 */
	@RequestMapping("/qerkuc")
	@ResponseBody
	public String qekuc(String id) {
		Integer numbers = IT_orderService.Queryinginventory(id.toString());
		 System.out.println(numbers+"666666666666666666666666666666666666666666666");
		return JsonUtil.getResponseJson(1, "查询成功", null, numbers);
		
		
	}
	/**
	 * user_id 用户id
	 * 查询角标数字
	 * order_state 订单状态
	 */
	@RequestMapping("/qercxjb")
	@ResponseBody
	public String qekucjiaobiao(String user_id) {
		System.out.println(user_id+"999999999999999999999999");  
		jiaobiao jiaobiao=IT_orderService.jiaobiao(user_id);
		int cunne=IT_orderService.selectCount(null);	
		return JsonUtil.getResponseJson(1, "查询成功", null, jiaobiao);
		
		
	}
	@RequestMapping("/queryh")
	@ResponseBody
	public String qeryunfeiyouhui(Double zongjia,String id) {
		
		
			int mum=IT_orderService.selectpase(id.toString(),zongjia);//查询优惠价格
	
		
		Integer  yongfei=IT_orderService.yunfei(zongjia);;
	
		 
		return JsonUtil.getResponseJson(1, "查询成功",mum ,yongfei );
		
		
	}
	
	/**
	 *支付成功app回调状态
	 */
	@RequestMapping("/uporderpayment")
	@ResponseBody
	public   String   updatete(String order_id,String order_payment) {
		System.out.println(order_id+order_payment+"00000000000000000000000000000000000000000");
		
	int	 fig=IT_orderService.ordercancelled(order_id,"1");
	IT_orderService.updateorderpayment(order_id,order_payment);
	if(fig>0) {
		return JsonUtil.getResponseJson(1, "查询成功",null ,null );
	  }
	   return JsonUtil.getResponseJson(1, "查询成功",null ,null );
	}
	
	
	

}
