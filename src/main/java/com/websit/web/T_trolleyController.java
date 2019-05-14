 package com.websit.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public  IT_shoppingService  T_shoppingService;

	/**
	 * 添加购物车
	 * @param t_trolley
	 * @return
	 */
	
	@RequestMapping(value = "/addt_trolley", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String  add(T_trolley t_trolley,Integer is_des) {
		if(is_des!=null) {
		t_trolley.setUser_id((((Security.decode(t_trolley.getUser_id())))));
		t_trolley.setProduct_id((((Security.decode(t_trolley.getProduct_id())))));
		t_trolley.setTrolley_specifications((((Security.decode(t_trolley.getTrolley_specifications())))));
		}
	
				String msg = "系统异常，请稍后再试";
				Integer cood = -1;
				// 获取当前库存
				try {
				if(t_trolley.getNumber()==null) {
					t_trolley.setNumber(1);
				}
		
				    boolean fig=false;
				    T_product_specification T_product_specification=IT_orderService.specification(t_trolley.getProduct_id().toString(),t_trolley.getTrolley_specifications());
				    if(T_product_specification==null) {
						return JsonUtil.getResponseJson(cood, "此商品无法购买", null, null);
					}
				   // System.out.println(T_product_specification+"6666666666666666666666666");
					int number = IT_orderService.Queryinginventory(t_trolley.getProduct_id().toString(),T_product_specification.getId());
					BigDecimal account=T_product_specification.getPrice();  //将类型转换为double
				
					t_trolley.setTrolley_price(account.doubleValue());//将值赋值给对象
					T_product product = IT_orderService.Querysteda(t_trolley.getProduct_id().toString());
					t_trolley.setT_product_specification_id(T_product_specification.getId().toString());//获取规格id
					 int numbers=(t_trolley.getNumber());
					if (number<=0) {
						cood = -1;
						msg = "库存数量不足，请修改购买数量";
						return JsonUtil.getResponseJson(cood, msg, null, null);
					} else if (product.getState() == 2) {
						cood = -1;
						msg = "商品已下架";
						return JsonUtil.getResponseJson(cood, msg, null, null);
					}
					else if(!T_trolleyService.shppingnum(t_trolley.getProduct_id().toString(),t_trolley.getUser_id().toString(),t_trolley.getT_product_specification_id())) {
						fig = T_trolleyService.insert(t_trolley);
					}else if (number <numbers) {
						
							cood = -1;
							msg = "库存数量不足，请修改购买数量";
							return JsonUtil.getResponseJson(cood, msg, null, null);
					}
					else  
					{
						fig = T_trolleyService.updatemnum(numbers,t_trolley.getProduct_id().toString(),t_trolley.getUser_id().toString(),t_trolley.getT_product_specification_id());
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
	public   String lt_trolleylst(String  user_id,Long specifications,RowBounds RowBounds,Integer page,Integer limit,Integer is_des) {
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		Integer numbers;
		Double  zongjia=0.0;
		if(is_des!=null) {
		user_id=(Security.decode(user_id));
		}
	
		
		try { 
			List <lt_trolleylst> lt_trolleylst=T_trolleyService.lt_trolleylst(user_id,new RowBounds(page,limit));
			        
			for(int i=0;i<lt_trolleylst.size();i++) {
			        	
			        	
			        	 double danjia=lt_trolleylst.get(i).getTrolley_price()*lt_trolleylst.get(i).getNumber();;
			        	zongjia=danjia+zongjia;
			        
			        	double mum=IT_orderService.selectpase(lt_trolleylst.get(i).getId().toString(),zongjia);//查询优惠价格
			        	Double mums=mum;
			        	 
			        	 lt_trolleylst.get(i).setYouhuijine(mums.toString());
			        	 numbers = IT_orderService.Queryinginventory(lt_trolleylst.get(i).getId().toString(),Long.valueOf(lt_trolleylst.get(i).getT_product_specification_id()));;
			        	lt_trolleylst.get(i).setNumbers(numbers);//查询总数量
			        	 
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
	public   String updatetrolleylst(Integer  num,Integer id,String user_id,  Integer is_des,String T_trolley_id) {
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
		    	
		    	T_trolley t_trolley=T_trolleyService.selectById(T_trolley_id);
		    	//System.out.println(t_trolley);
		    	int number = IT_orderService.Queryinginventory(t_trolley.getProduct_id().toString(),Long.valueOf(t_trolley.getT_product_specification_id()));
			if(number<num) {
				cood = -1;
				msg = "库存数量不足，请修改购买数量";
			}else {
                   fig=T_trolleyService.updatemnum2(num, id,user_id,T_trolley_id);
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
	

	
}
