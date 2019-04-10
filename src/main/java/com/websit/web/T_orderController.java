package com.websit.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.websit.until.DesUtil;
import com.websit.until.JsonUtil;
import com.websit.until.OrderCodeFactory;
import com.websit.until.Security;
import com.websit.until.order;

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
/* @Slf4j */
public class T_orderController {
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
	public IT_productService T_productService;
	
	order order = new order();
	

	/**
	 * 引入加密类
	 */

	@RequestMapping("/Generateorder")
	@ResponseBody

	public String Generateorder(String trolley_id, String id, Integer order_number, String order_mode, String user_id,
			
			String remarks, Integer is_des) {// 商品id，数量,地址id
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		boolean fig = false;
		System.out.println(trolley_id);
		String order_no = OrderCodeFactory.getOrderCode(8L);
		/**
		 * 如果加密的数据解密
		 */
		Date cause_time = new Date();
	    System.out.println(cause_time);	
		if (is_des != null) {
			user_id = Security.decode(user_id);

			System.out.println(user_id);

			if (id != null) {
				id = (Security.decode(id));

			}
		}
		///try {
			if (user_id == null || user_id.equals(" ")) {
				msg = "请重新登录";
				return JsonUtil.getResponseJson(cood, msg, null, null);
			} else if (order_mode == null) {
				msg = "请填写收货地址";
				return JsonUtil.getResponseJson(cood, msg, null, null);
			}
             
			else if (trolley_id == null || trolley_id.length() == 0) {
				Integer numbers = IT_orderService.Queryinginventory(id.toString());// 查询商品信息
				T_product product = IT_orderService.Querysteda(id.toString());// 查询商品的信息
				if (order_number > numbers || order_number == 0) {
					cood = -1;
					msg = "库存数量不足，请修改购买数量";
					return JsonUtil.getResponseJson(cood, msg, null, order_no);
				} else if (product.getState() == 2) {
					cood = -1;
					msg = "商品已下架";
					return JsonUtil.getResponseJson(cood, msg, null, order_no);
				} else {
					
					Double jiage = product.getPrice().doubleValue() * order_number;
					int mum = IT_orderService.selectpase(id.toString(), jiage);// 查询优惠价格
					double jine = jiage - mum;
					/**
					 * 查询运费
					 */
					Integer yongfei = IT_orderService.yunfei(jiage);
			

					T_order T_order = order.T_order(user_id, order_no, order_mode, order_number.toString(), jine,
							cause_time, remarks, yongfei.toString());
					fig = IT_orderService.insert(T_order);
					T_shopping T_shopping = order.shopping(order_no, order_number, jine, mum,
							product.getPrice().doubleValue(), id.toString());
					fig = T_shoppingService.insert(T_shopping);
					/*
					 * 减去库存
					 */
					IT_orderService.updatenumbergoumai(order_number, id.toString());

				}
			} else {
				String[] str = trolley_id.split(",");
				String[] str1 = str;
				double zongjia = 0;
				Integer number = 0;// 总价，数量
				double ddzongjia = 0;
				double total = 0;
				
				for (int i = 0; i < str1.length; i++) {
		           System.out.println(Security.decode(str1[i])+"777777777777777777777777");
					T_trolley T_trolley = new T_trolley();
					 System.out.println(is_des+"deshgjkdhgklgghfjgjhgjkhglfgjg");
					if(is_des != null) {
					T_trolley = T_trolleyService.selectById(Security.decode(str1[i]));
					}else {
						T_trolley = T_trolleyService.selectById(str1[i]);
					}
					//;
					System.out.println(T_trolley.toString()+"666666666666666666666666");
					T_product product = new T_product();
					System.out.println(T_trolley.getProduct_id().toString()+"6666666666666666");
					product = T_trolleyService.T_produc(T_trolley.getProduct_id().toString());
					System.out.println(product+"6666666666666666");
					zongjia = product.getPrice().doubleValue() * T_trolley.getNumber();
					int mum = IT_orderService.selectpase(T_trolley.getProduct_id().toString().toString(), zongjia);// 查询优惠价格
					double jine = (zongjia - mum);
					
					T_shopping T_shopping = order.shopping(order_no, T_trolley.getNumber(), jine, mum,
							product.getPrice().doubleValue(), T_trolley.getProduct_id().toString());// 将所有值给对象
					fig = T_shoppingService.insert(T_shopping);
					number = T_trolley.getNumber() + number;
					ddzongjia = ddzongjia + zongjia - mum;
					total = total + zongjia;
					fig = T_trolleyService.deleteById(T_trolley.getTrolley_id());
					/*
					 * 减去库存
					 */

			        IT_orderService.updatenumbergoumai(T_trolley.getNumber(),T_trolley.getProduct_id().toString());
				}
				/**
				 * 查询运费
				 */
				Integer yongfei = IT_orderService.yunfei(zongjia);
				T_order T_order = order.T_order(user_id, order_no, order_mode, number.toString(), total, cause_time,
						remarks, yongfei.toString());
				fig = IT_orderService.insert(T_order);
			}

			if (fig) {
				cood = 1;
				msg = "商品购买成功";
			} else {
				cood = -1;
				msg = "商品购买失败";
			}
			return JsonUtil.getResponseJson(cood, msg, null, order_no);
//		} catch (Exception e) {
//			return JsonUtil.getResponseJson(cood, msg, null, null);
//		}

	}

	/**
	 * 订单取消,发货，签收，
	 */
	@RequestMapping("/ordercan")
	@ResponseBody
	public String ordercancelled(String order_id, String order_state, String cause_explain, String cause_type,
			String sales_cause, String order_shouhuo_id) {// 主键,订单状态,退货原因,退货类型,退货说明
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		int fig = 0;
		String sales_no = OrderCodeFactory.getOrderCode(8L);// 生产
       
		switch (order_state)

		{
		case "-1":
			T_order T_order = IT_orderService.selectById(order_id);// 取消订单查询购买量
			Map<String, Object> columnMap = new HashMap<String, Object>();
			columnMap.put("order_id", T_order.getOrder_no());

			List<T_shopping> T_shopping = T_shoppingService.selectByMap(columnMap);
			for (int i = 0; i < T_shopping.size(); i++) {
				IT_orderService.updatenqux(T_shopping.get(i).getNumber(), T_shopping.get(i).getProduct_id());
			}
			fig = IT_orderService.ordercancelled(order_id, order_state);
			break;
		case "2":
			IT_orderService.updatewuliudanhao(order_id, order_shouhuo_id);

			fig = IT_orderService.ordercancelled(order_id, order_state);
			break;
		case "5":
			Date cause_time = new Date();
			T_sales T_sales = new T_sales();
			T_sales.setCause_explain(cause_explain);
			T_sales.setCause_type(cause_type);
			T_sales.setOrder_id(order_id);
			T_sales.setSales_cause(sales_cause);
			T_sales.setCause_time(cause_time);
			T_sales.setSales_no(sales_no);
			T_sales.setStele("0");
			T_salesService.insert(T_sales);
			fig = IT_orderService.ordercancelled(order_id, order_state);
			break;
		case "8":
			fig = IT_orderService.ordercancelled(order_id, "5");
			break;
		default:
			fig = IT_orderService.ordercancelled(order_id, order_state);

			break;
		}

		if (fig > 0) {
			cood = 1;
			msg = "操作成功";
		} else {
			cood = -1;
			msg = "操作失败";
		}

		return JsonUtil.getResponseJson(cood, msg, null, sales_no);

	}

	/**
	 * user_id 用户id 订单列表 order_state 订单状态
	 */

	@RequestMapping("/orderlist")
	@ResponseBody
	public String orderlist(String id, String user_id, String order_state, RowBounds RowBounds, Integer page,
			Integer limit, Integer is_des) {//
		if (is_des != null) {
			user_id = Security.decode(user_id);

			System.out.println(user_id);

		}
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		System.out.println("user_id" + user_id + "order_state" + order_state + "page" + page + "limit" + limit);
		if (user_id == "" || user_id == "undefined" || page == null || limit == null) {
			cood = 152369;
			msg = "用户数据不正确，请重新登录";
		} else if (user_id == null || user_id.equals(" ")) {
			msg = "请重新登录";
			return JsonUtil.getResponseJson(cood, msg, null, null);
		} else {
			ArrayList<order_list> orderlist = IT_orderService.order_list(user_id, order_state, new RowBounds(page, limit),id);
			for (int i = 0; i < orderlist.size(); i++) {

				orderlist.get(i).setT_goods(goodsService.selectById(orderlist.get(i).getOrder_mode()));
//
				orderlist.get(i).setShping(IT_orderService.shopinglist(orderlist.get(i).getOrder_no(), order_state));

			}

			Map<String, Object> columnMap = new HashMap<String, Object>();
			columnMap.put("user_id", user_id);
			if (order_state != null) {
				columnMap.put("order_state", order_state);
			}
			int num2 = IT_orderService.selectByMap(columnMap).size();
			if (orderlist.size() > 0) {
				cood = 1;
				msg = "查询成功";
			} else {
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
			List<T_orderVo> some = IT_orderService.selectAllSecond(user_id);
			if (some.size() >= 0) {
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
	 * user_id 用户id web后台订单列表 order_state 订单状态
	 */
	@RequestMapping("/orderweblist")
	@ResponseBody
	public String orderweblist(String order_state, RowBounds RowBounds, Integer page, Integer limit, String date) {//
		page = (page - 1) * limit;
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		try {

			int num2 = IT_orderService.selectCount(null);
			List<order_list> orderlist = IT_orderService.order_list1(order_state, page, limit, date);
			for (int i = 0; i < orderlist.size(); i++) {
				orderlist.get(i).setT_goods(goodsService.selectById(orderlist.get(i).getOrder_mode()));
				System.out.println(
						goodsService.selectById(orderlist.get(i).getOrder_mode()) + "9999999999999999999999999");
				orderlist.get(i).setShping(IT_orderService.shopinglist(orderlist.get(i).getOrder_no(), order_state));
			}

			if (orderlist.size() > 0) {
				cood = 1;
				msg = "查询成功";
			} else {
				cood = 1;
				msg = "查询成功";

			}

			System.out.println(num2);
			return JsonUtil.getResponseJson(cood, msg, num2, orderlist);

		} catch (Exception e) {
			return JsonUtil.getResponseJson(cood, msg, null, null);
		}

	}

	/**
	 * user_id 用户id 查询优惠和运费 order_state 订单状态
	 */
	@RequestMapping("/qeryunfeiyouhui")
	@ResponseBody
	public String qeryunfeiyouhui(String trolley_id) {
		String[] str = trolley_id.split(",");
		String[] str1 = str;
		T_trolley T_trolley = new T_trolley();
		double zongjia = 0;
		Integer number = 0;// 总价，数量
		double ddzongjia = 0;
		double total = 0;

		for (int i = 0; i < str1.length; i++) {
			T_trolley = T_trolleyService.selectById(str1[i]);
			T_product product = new T_product();
			product = T_trolleyService.T_produc(T_trolley.getProduct_id().toString());
			zongjia = product.getPrice().doubleValue() * T_trolley.getNumber();
			int mum = IT_orderService.selectpase(T_trolley.getProduct_id().toString(), zongjia);// 查询优惠价格
			number = T_trolley.getNumber() + number;

			total = total + zongjia;
			ddzongjia = mum + ddzongjia;
		}


		Integer yongfei = IT_orderService.yunfei(total);

		return JsonUtil.getResponseJson(1, "查询成功", yongfei, ddzongjia);

	}

	/**
	 * user_id 用户id 查询库存 order_state 订单状态
	 */
	@RequestMapping("/qerkuc")
	@ResponseBody
	public String qekuc(String id) {
		Integer numbers = IT_orderService.Queryinginventory(id.toString());
		return JsonUtil.getResponseJson(1, "查询成功", null, numbers);

	}

	/**
	 * user_id 用户id 查询角标数字 order_state 订单状态
	 */
	@RequestMapping("/qercxjb")
	@ResponseBody

	public String qekucjiaobiao(String user_id, Integer is_des) {
		if (is_des != null) {
			user_id = Security.decode(user_id);
		}
		jiaobiao jiaobiao = IT_orderService.jiaobiao(user_id);
		return JsonUtil.getResponseJson(1, "查询成功", null, jiaobiao);

	}

	@RequestMapping("/queryh")
	@ResponseBody
	public String qeryunfeiyouhui(Double zongjia, String id) {

		int mum = IT_orderService.selectpase(id.toString(), zongjia);// 查询优惠价格

		Integer yongfei = IT_orderService.yunfei(zongjia);
		;

		return JsonUtil.getResponseJson(1, "查询成功", mum, yongfei);

	}

	/**
	 * 支付成功app回调状态
	 */
	@RequestMapping("/uporderpayment")
	@ResponseBody
	public String updatete(String order_id, String order_payment) {
		System.out.println(order_id + order_payment + "00000000000000000000000000000000000000000");

		int fig = IT_orderService.ordercancelled(order_id, "1");
		IT_orderService.updateorderpayment(order_id, order_payment);
		if (fig > 0) {
			return JsonUtil.getResponseJson(1, "查询成功", null, null);
		}
		return JsonUtil.getResponseJson(1, "查询成功", null, null);
	}

	/**
	 * 定时任务
	 */
//	@Scheduled(fixedDelay = 5000) //启动后每隔5秒运行一次
	public void timer() { // 获取当前时间
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("执行定时开始:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		Map<String, Object> columnMap = new HashMap<String, Object>();

		columnMap.put("order_state", 0);

		List<T_order> T_order = IT_orderService.selectByMap(columnMap);

		for (int i = 0; i < T_order.size(); i++) {
			Date cause_time = new Date();
			System.out.println(cause_time.getMonth());
			int hours = cause_time.getHours() - T_order.get(i).getOrder_time().getHours();
			int day = cause_time.getDay() - T_order.get(i).getOrder_time().getDate();
			int mose = cause_time.getMonth() - T_order.get(i).getOrder_time().getMonth();
			System.out.println(
					T_order.get(i).getOrder_time().getDate() + "t000000000000000000000000" + cause_time.getDay());
			if (hours > 2 || day > 0 || mose > 0) {

				Map<String, Object> mnMap = new HashMap<String, Object>();
				columnMap.put("order_id", T_order.get(i).getOrder_no());

				List<T_shopping> T_shopping = T_shoppingService.selectByMap(mnMap);
				for (int j = 0; j < T_shopping.size(); j++) {
					System.out.println(T_shopping.get(i).getNumber() + "           " + T_shopping.get(i).getProduct_id()
							+ "gjhrklglrk");
					int u = IT_orderService.updatenqux(T_shopping.get(i).getNumber(),
							T_shopping.get(i).getProduct_id());
				}
				int fig = IT_orderService.ordercancelled(T_order.get(i).getOrder_id().toString(), "-1");

			}
		}

		System.out.println("执行定时任务完成:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

	}

}
