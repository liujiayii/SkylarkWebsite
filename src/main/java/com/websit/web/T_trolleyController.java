 package com.websit.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.T_order;
import com.websit.entity.T_product;
import com.websit.entity.T_shopping;
import com.websit.entity.T_trolley;
import com.websit.service.IT_productService;
import com.websit.service.IT_shoppingService;
import com.websit.service.IT_trolleyService;
import com.websit.until.JsonUtil;
import com.websit.until.OrderCodeFactory;
import com.websit.until.Security;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import  com.websit.entityvo.*;
import  com.websit.entity.*;
/**
 * <p>
 * 购物车表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Controller
@RequestMapping("/t_trolley")
public class T_trolleyController {
	@Autowired
	public IT_trolleyService T_trolleyService;
	@Autowired
	public com.websit.service.IT_orderService IT_orderService;
	@Autowired
	private IT_productService productService;
	@Autowired
	public  IT_shoppingService  T_shoppingService;

	/**
	 * 添加购物车
	 * @param t_trolley
	 * @return
	 */
	@RequestMapping("/addt_trolley")
	@ResponseBody
	public String  add(T_trolley t_trolley,Integer is_des) {
		if(is_des!=null) {
		t_trolley.setUser_id((((Security.decode(t_trolley.getUser_id())))));
		t_trolley.setProduct_id((((Security.decode(t_trolley.getProduct_id())))));
		}
		//DesUtil.decode("yunquekj", T_order.toString());
				String msg = "系统异常，请稍后再试";
				Integer cood = -1;
				// 获取当前库存
				try {
				if(t_trolley.getNumber()==null) {
					t_trolley.setNumber(1);
				}
		
				    boolean fig=false;
					int number = IT_orderService.Queryinginventory(t_trolley.getProduct_id().toString());
					
					//
					T_product product = IT_orderService.Querysteda(t_trolley.getProduct_id().toString());
				
					 int numbers=T_trolleyService.number(t_trolley.getProduct_id().toString());
					if (number<=0) {
						cood = -1;
						msg = "库存数量不足，请修改购买数量";
						return JsonUtil.getResponseJson(cood, msg, null, null);
					} else if (product.getState() == 2) {
						cood = -1;
						msg = "商品已下架";
						return JsonUtil.getResponseJson(cood, msg, null, null);
					}
					else if(T_trolleyService.shppingnum(t_trolley.getProduct_id().toString(),t_trolley.getUser_id().toString())==0) {
						fig = T_trolleyService.insert(t_trolley);
					}else if (number <numbers) {
						
							cood = -1;
							msg = "库存数量不足，请修改购买数量";
							return JsonUtil.getResponseJson(cood, msg, null, null);
					}
					else  if(T_trolleyService.shppingnum(t_trolley.getProduct_id().toString(),t_trolley.getUser_id().toString())>0)
					{
						fig = T_trolleyService.updatemnum(numbers,t_trolley.getProduct_id().toString(),t_trolley.getUser_id().toString());
					}
				   
			
						if (fig) {
                            
							cood = 1;
							msg = "添加购物车成功";
						}
				     System.err.println(msg);

					return JsonUtil.getResponseJson(cood, msg, null, null);
				} catch (Exception e) {
					return JsonUtil.getResponseJson(cood, msg, null, null);
				}

	}
    /**
     * 删除购物车
     * @param trolley_id
     * @return
     */
	@RequestMapping("/delt_trolley")
	@ResponseBody
	public String  delt_trolley(Integer [] trolley_id) {
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		try {
		boolean fig=false;
			   //Integer [] trolley_id= {1,2};
			  for(int i=0;i<trolley_id.length;i++) {
			    fig=T_trolleyService.deleteById(trolley_id[i]);
			  }
			
				if (fig) {

					cood = 1;
					msg = "删除购物城成功";
				}else {
					cood = -1;
					msg = "删除购物城失败";
				}
				
			

			return JsonUtil.getResponseJson(cood, msg, null, null);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
	}
	 /**
     * 查询购物车的数据
     * @param trolley_id
     * @return
     */
	@RequestMapping("/lt_trolleylst")
	@ResponseBody
	public   String lt_trolleylst(String  user_id,RowBounds RowBounds,Integer page,Integer limit,Integer is_des) {
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		Integer numbers;
		if(is_des!=null) {
		user_id=(Security.decode(user_id));
		}
	
		
		try { 
			List <lt_trolleylst> lt_trolleylst=T_trolleyService.lt_trolleylst(user_id,new RowBounds(page,limit));
			        
			for(int i=0;i<lt_trolleylst.size();i++) {
			        	 Double  num=new Double(lt_trolleylst.get(i).getNumber());
			        	
			        	 double danjia=lt_trolleylst.get(i).getPrice().doubleValue();
			        	 Double  zongjia=num*danjia;
			        
			        	 double mum=IT_orderService.selectpase(lt_trolleylst.get(i).getId().toString(),zongjia);//查询优惠价格
			        	 Double mums=mum;
			        	 
			        	 lt_trolleylst.get(i).setYouhuijine(mums.toString());
			        	 numbers = IT_orderService.Queryinginventory(lt_trolleylst.get(i).getId().toString());;
			        	 lt_trolleylst.get(i).setNumbers(numbers);
			        	 
			         }
			Map<String, Object> columnMap=new HashMap<String,Object>(); 
			columnMap.put("user_id", user_id);
			int num2=T_trolleyService.selectByMap(columnMap).size();
			
				if (lt_trolleylst.size()>0) {

					cood = 1;
					msg = "查询购物车成功";
				}else {
					cood = 1;
					msg = "查询购物车成功";
				}
				
				return JsonUtil.getResponseJson(cood, msg, num2, lt_trolleylst);
		} catch (Exception e) {
		
			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
	}
	/**
	 * 加减少物品数量
	 */
	
	@RequestMapping("/uptate")
	@ResponseBody
	public   String updatetrolleylst(Integer  num,Integer id,String user_id,  Integer is_des) {
		if(is_des!=null) {
			user_id=(Security.decode(user_id));
			}
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		boolean fig=false;
	try {
		    if(num==0) {
		    	msg = "购物车数量不能为0";
				 cood = -1;
		    }else {
			int number = IT_orderService.Queryinginventory(id.toString());
			if(number<num) {
				cood = -1;
				msg = "库存数量不足，请修改购买数量";
			}else {
                   fig=T_trolleyService.updatemnum2(num, id,user_id);
               	if (fig) {

					cood = 1;
					msg = "修改成功";
				}else {
					cood = -1;
					msg = "修改失败";
				}
			}
			
			   

			
			
				
			
		    }
			return JsonUtil.getResponseJson(cood, msg, null, null);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
	
	}
	
	/**
	 * 购物车购买
	 */
	@RequestMapping("/gouwuchegoumai")
	@ResponseBody
	public  String  gouwuchegoumai(String []str,String order_mode,String user_id) {
		String [] str1= str;

		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		boolean fig=false;
		T_trolley T_trolley=new T_trolley();
		//订单编号
	    String  order_no=OrderCodeFactory.getOrderCode(8L);
	    double zongjia=0; Integer number=0;//总价，数量
	    double ddzongjia=0;
		for(int i=0;i<str1.length;i++) {
			T_trolley=T_trolleyService.selectById(str1[i]);
	
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
			 fig=T_trolleyService.deleteById(T_trolley.getTrolley_id());
				/*
				 *  减去库存
				 */
			
			int ter=IT_orderService.updatenumbergoumai(T_trolley.getNumber(), T_trolley.getProduct_id().toString());
				
		}   
		Date order_time = new Date();
		T_order  T_order=new T_order();
	
		T_order.setUser_id(user_id);
		T_order.setOrder_no(order_no);
		T_order.setOrder_state("0");
		T_order.setOrder_mode(order_mode);
		T_order.setOrder_number(number.toString());
		T_order.setOrder_money(ddzongjia);
		T_order.setOrder_time(order_time);
		/**
		 * 查询运费
		 */
		Integer  yongfei=IT_orderService.yunfei(zongjia);
		
		T_order.setYunfei(yongfei.toString());
		 fig=IT_orderService.insert(T_order);		
		if(fig) {
			cood = 1;
			msg = "商品购买成功";
		}else {
			cood = -1;
			msg = "购买失败";
		}
	     
		
		
		return JsonUtil.getResponseJson(cood, msg, null, null);
	}
	/**
	 * 购物车购买
	 */
	@RequestMapping("/chakucun")
	@ResponseBody
	public  String  gouwuchegoumai(String trolley_id) {
		String[] str = trolley_id.split(","); 
		
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		boolean fig=true;
		try {
			
		
		for(int i=0;i<str.length;i++) {
			T_trolley T_trolley=new T_trolley();
			T_trolley=T_trolleyService.selectById(str[i]);
			
			Integer numbers = IT_orderService.Queryinginventory(T_trolley.getProduct_id().toString());
			
			
			if(numbers<T_trolley.getNumber()) {
				String  name=T_trolleyService.querproductname(T_trolley.getProduct_id().toString());
				
				fig=false;
				cood = -1;
			
				msg = "商品"+name+"库存不足，请联系客服";
				
				break;
				
				
			}else{
				cood = 1;
				msg = "库存足够";
				
			}
			
			return JsonUtil.getResponseJson(cood, msg, null, trolley_id);
		}   
		
	
		
		
		
			
		
	     
		} catch (Exception e) {
			fig=false;
			msg = "库存不足";
			return JsonUtil.getResponseJson(cood, msg, null, trolley_id);
		}
		
		return JsonUtil.getResponseJson(cood, msg, null, trolley_id);
	}
	/**
	 * 查询库存
	 */
	@RequestMapping("/quernumber")
	@ResponseBody
	public  String  quernumnemre(String trolley_id) {
		String[] str = trolley_id.split(","); 
		T_trolley T_trolley=new T_trolley();

		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		boolean fig=true;
	try {
			
		List<T_trolley> trolley=new ArrayList();
		for(int i=0;i<str.length;i++) {
			
			T_trolley=T_trolleyService.selectById(str[i]);
	
			trolley.add(T_trolley);
	
				
		}
			if(fig)	{
				cood = 1;
				msg = "查询成功";
				
			}else{
				cood = 1;
				msg = "库存足够";
				
			}
		
			return JsonUtil.getResponseJson(cood, msg, null, T_trolley);
		  
		
	
		
		
		
			
		
	     
		} catch (Exception e) {
			fig=false;
			msg = "库存不足";
			return JsonUtil.getResponseJson(cood, msg, null, trolley_id);
		}
		
		
	}
	
}
