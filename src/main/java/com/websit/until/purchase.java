package com.websit.until;

import java.util.Date;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.websit.entity.T_goods;
import com.websit.entity.T_order;
import com.websit.entity.T_product;
import com.websit.entity.T_product_specification;
import com.websit.entity.T_shopping;
import com.websit.entity.T_trolley;
import com.websit.service.IT_goodsService;
import com.websit.service.IT_salesService;
import com.websit.service.IT_shoppingService;
import com.websit.service.IT_trolleyService;
@Controller
public class purchase{
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
	
	private static purchase logUtil;
	//重点三：初始化
    @PostConstruct 
public void init() {       
	 logUtil= this; 

} 
public  static String purchasew (String trolley_id, String id, Integer order_number, String order_mode, String user_id,

		String remarks, Integer is_des, String specifications) {// 商品id，数量,地址id

	String msg = "系统异常，请稍后再试";
	Integer cood = -1;
	boolean fig = false;

	String order_no = OrderCodeFactory.getOrderCode(8L);
	/**
	 * 如果加密的数据解密
	 */
	Date cause_time = new Date();

	if (is_des != null) {
		user_id = Security.decode(user_id);
		specifications = Security.decode(specifications);
		if (id != null) {
			id = Security.decode(id);

		}
	}
	T_goods T_goods = logUtil.goodsService.selectById(order_mode);
//	System.out.println(specifications + " 9999999999999999999999999999999999999");
	try {
		if (user_id == null || user_id.equals(" ")) {
			msg = "请重新登录";
			return JsonUtil.getResponseJson(cood, msg, null, null);
		} else if (order_mode == null) {
			msg = "请填写收货地址";
			return JsonUtil.getResponseJson(cood, msg, null, null);
		}

		else if (trolley_id == null || trolley_id.length() == 0) {

			T_product_specification T_product_specification = logUtil.IT_orderService.specification(id.toString(),
					specifications);
			if (T_product_specification == null) {
				return JsonUtil.getResponseJson(cood, "此商品无法购买", null, null);
			}
			System.out.println(T_product_specification);
			Integer numbers = logUtil.IT_orderService.Queryinginventory(id.toString(), T_product_specification.getId());// 查询商品信息

			T_product product = logUtil.IT_orderService.Querysteda(id.toString());// 查询商品的信息
			if (order_number > numbers || order_number == 0) {
				cood = -1;
				msg = "库存数量不足，请修改购买数量";
				return JsonUtil.getResponseJson(cood, msg, null, order_no);
			} else if (product.getState() == 2) {
				cood = -1;
				msg = "商品已下架";
				return JsonUtil.getResponseJson(cood, msg, null, order_no);
			} else {

				Double jiage = T_product_specification.getPrice().doubleValue() * order_number;
				int mum = logUtil.IT_orderService.selectpase(id.toString(), jiage);// 查询优惠价格
				double jine = jiage - mum;
				/**
				 * 查询运费
				 */
				Integer yongfei = logUtil.IT_orderService.yunfei(jiage);
				double order_payable = jine + yongfei;

				T_order T_order = com.websit.until.order.T_order(user_id, order_no, order_mode,
						order_number.toString(), jine, cause_time, remarks, yongfei.toString(), T_goods,
						order_payable);
				fig = logUtil.IT_orderService.insert(T_order);

				T_shopping T_shopping = com.websit.until.order.shopping(order_no, order_number, jine, mum,
						T_product_specification.getPrice().doubleValue(), id.toString(),
						T_product_specification.getSpecificationName());

				fig =logUtil. T_shoppingService.insert(T_shopping);
				/*
				 * 减去库存
				 */
				logUtil.IT_orderService.updatenumbergoumai(order_number, id.toString(), T_product_specification.getId());
				if (fig) {
					cood = 1;
					msg = "商品购买成功";
					return JsonUtil.getResponseJson(cood, msg, null, order_no);
				}
				return JsonUtil.getResponseJson(cood, msg, null, order_no);
			}
		} else {
			String[] str = trolley_id.split(",");
			String[] str1 = str;
			double zongjia = 0;
			Integer number = 0;// 总价，数量
			double ddzongjia = 0;
			double total = 0;

			for (int i = 0; i < str1.length; i++) {

				T_trolley T_trolley = new T_trolley();

				if (is_des != null) {
					T_trolley = logUtil.T_trolleyService.selectById(Security.decode(str1[i]));
				} else {
					T_trolley = logUtil.T_trolleyService.selectById(str1[i]);
				}

//				System.out.println(T_trolley);
				T_product product = new T_product();

				product = logUtil.T_trolleyService.T_produc(T_trolley.getProduct_id().toString());// 查询商品信息
				Integer numbers = logUtil.IT_orderService.Queryinginventory(T_trolley.getProduct_id().toString(),
						Long.valueOf(T_trolley.getT_product_specification_id()));
				if (numbers < T_trolley.getNumber()) {
					cood = -1;
					msg = "库存数量不足，请修改购买数量";
					return JsonUtil.getResponseJson(cood, msg, null, order_no);
				} else if (product.getState() == 2) {
					cood = -1;
					msg = "商品已下架";
					return JsonUtil.getResponseJson(cood, msg, null, order_no);
				} else {
					zongjia = T_trolley.getTrolley_price() * T_trolley.getNumber();
					int mum = logUtil.IT_orderService.selectpase(T_trolley.getProduct_id().toString().toString(), zongjia);// 查询优惠价格
					double jine = (zongjia - mum);

					T_shopping T_shopping = com.websit.until.order.shopping(order_no, T_trolley.getNumber(), jine,
							mum, T_trolley.getTrolley_price(), T_trolley.getProduct_id().toString(),
							T_trolley.getTrolley_specifications());// 将所有值给对象

					fig = logUtil.T_shoppingService.insert(T_shopping);
					number = T_trolley.getNumber() + number;
					ddzongjia = ddzongjia + zongjia - mum;
					total = total + zongjia;
					fig = logUtil.T_trolleyService.deleteById(T_trolley.getTrolley_id());
					/*
					 * 减去库存
					 */

					logUtil.IT_orderService.updatenumbergoumai(T_trolley.getNumber(), T_trolley.getProduct_id().toString(),
							Long.valueOf(T_trolley.getT_product_specification_id()));
				}
			}
			/**
			 * 查询运费
			 */
			Integer yongfei =logUtil. IT_orderService.yunfei(total);
			double order_payable = total + yongfei;
			T_order T_order = com.websit.until.order.T_order(user_id, order_no, order_mode, number.toString(),
					total, cause_time, remarks, yongfei.toString(), T_goods, order_payable);
			fig = logUtil.IT_orderService.insert(T_order);
		}

		if (fig) {
			cood = 1;
			msg = "商品购买成功";
		} else {
			cood = -1;
			msg = "商品购买失败";
		}

		return JsonUtil.getResponseJson(cood, msg, null, order_no);

	} catch (Exception e) {
		return JsonUtil.getResponseJson(cood, msg, null, null);
	}


	

	
}


}