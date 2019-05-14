package com.websit.web;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.T_order;
import com.websit.entity.T_product_specification;
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
import com.websit.until.Security;
import com.websit.until.order;
import com.websit.until.purchase;


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
	@RequestMapping(value = "/Generateorder", produces = "application/json; charset=utf-8")
	@ResponseBody

	public String Generateorder(String trolley_id, String id, Integer order_number, String order_mode, String user_id,

			String remarks, Integer is_des, String specifications) {// 商品id，数量,地址id

		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		try {

		String mas=purchase.purchasew(trolley_id, id, order_number, order_mode, user_id, remarks, is_des, specifications);
		return mas;
		} catch (Exception e) {
			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
	}

	/**
	 * 订单取消,发货，签收，退货
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/ordercan")
	@ResponseBody
	public String ordercancelled(String order_id, String order_state, String cause_explain, String cause_type,
			String sales_cause, String order_shouhuo_id) throws Exception {// 主键,订单状态,退货原因,退货类型,退货说明
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		int fig = 0;
		String sales_no = OrderCodeFactory.getOrderCode(8L);// 生产订单编号

		switch (order_state)

		{
		case "-1":
			T_order T_order = IT_orderService.selectById(order_id);// 取消订单查询购买量
			Map<String, Object> columnMap = new HashMap<String, Object>();
			columnMap.put("order_id", T_order.getOrder_no());

			List<T_shopping> T_shopping = T_shoppingService.selectByMap(columnMap);
			for (int i = 0; i < T_shopping.size(); i++) {
				T_shopping.get(i).setState("-1");
				T_shoppingService.updateById(T_shopping.get(i));
				T_product_specification T_product_specification = IT_orderService.specification(T_shopping.get(i).getProduct_id().toString(),
						T_shopping.get(i).getShoping_specifications());
				if(T_product_specification!=null) {
				IT_orderService.updatenqux(T_shopping.get(i).getNumber(), T_shopping.get(i).getProduct_id(),T_product_specification.getId().toString());
				fig = IT_orderService.ordercancelled(order_id, order_state);
			}else {
				fig = IT_orderService.ordercancelled(order_id, order_state);
			}
			
			}
			break;
		case "2":
			IT_orderService.updatewuliudanhao(order_id, order_shouhuo_id);

			fig = IT_orderService.ordercancelled(order_id, order_state);
			break;
		case "5":
			Map<String, Object> Map = new HashMap<String, Object>();
			Map.put("order_id", order_id);
			List<T_order> order = IT_orderService.selectByMap(Map);
			Date cause_time = new Date();
      
			T_sales T_sales =com.websit.until.order.sale(cause_explain,cause_type,order_id,sales_cause,cause_time,sales_no,order.get(0).getUser_id(),order.get(0).getOrder_state(),order.get(0).getOrder_number(),order.get(0).getOrder_payable());
			


			Map<String, Object> lumnMap = new HashMap<String, Object>();
			lumnMap.put("order_id", order_id);
			lumnMap.put("stele", "0");

			if (T_salesService.selectByMap(lumnMap).size() > 0) {
				msg = "已经在审核中，请稍等";
				return JsonUtil.getResponseJson(cood, msg, null, null);
			} else {

				T_salesService.insert(T_sales);
				fig = IT_orderService.ordercancelled(order_id, order_state);

				break;
			}
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

		} else {
			page = page - 1;
		}
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		int num2 = 0;
		if (user_id == "" || user_id == "undefined" || page == null || limit == null) {
			cood = 152369;
			msg = "用户数据不正确，请重新登录";
		} else if (user_id == null || user_id.equals(" ")) {
			msg = "请重新登录";
			return JsonUtil.getResponseJson(cood, msg, null, null);

		}

		else {
			List<order_list> orderlist = IT_orderService.order_list(user_id, order_state, new RowBounds(page, limit),
					id);
			//System.out.println(orderlist.size() + "ttttttttttttttttttttttttttttt");
			for (int i = 0; i < orderlist.size(); i++) {
				orderlist.get(i).setShping(IT_orderService.shopinglist(orderlist.get(i).getOrder_no(), order_state));

			}

			Map<String, Object> columnMap = new HashMap<String, Object>();
			columnMap.put("user_id", user_id);
			if (order_state != null) {
				columnMap.put("order_state", order_state);
			} else {
				num2 = IT_orderService.selectByMap(columnMap).size();
			}

			if (orderlist.size() > 0) {
				cood = 1;
				msg = "查询成功";
			} else {
				cood = 1;
				msg = "查询成功";

			}

			return JsonUtil.getResponseJson(cood, msg, orderlist.size(), orderlist);
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
			Map<String, Object> Map = new HashMap<String, Object>();
			if(order_state!=null&&order_state.length()!=0) {
			Map.put("order_state", order_state);
			}
			if(date!=null&&date.length()!=0) {
				Map.put("order_no", date);
				}
			int num2 = IT_orderService.selectByMap(Map).size();
			List<order_list> orderlist = IT_orderService.order_list1(order_state, page, limit, date);

			for (int i = 0; i < orderlist.size(); i++) {

				orderlist.get(i).setShping(IT_orderService.shopinglist(orderlist.get(i).getOrder_no(), order_state));
			}

			if (orderlist.size() > 0) {
				cood = 1;
				msg = "查询成功";
			} else {
				cood = 1;
				msg = "查询成功";

			}

			//System.out.println(num2);
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

			zongjia = T_trolley.getTrolley_price() * T_trolley.getNumber();
			int mum = IT_orderService.selectpase(T_trolley.getProduct_id().toString(), zongjia);// 查询优惠价格
			number = T_trolley.getNumber() + number;

			total = total + zongjia;
			ddzongjia = mum + ddzongjia;
		}

		Integer yongfei = IT_orderService.yunfei(total);

		return JsonUtil.getResponseJson(1, "查询成功", yongfei, ddzongjia);

	}

//	/**
//	 * user_id 用户id 查询库存 order_state 订单状态
//	 */
//	@RequestMapping("/qerkuc")
//	@ResponseBody
//	public String qekuc(String id,Long specifications) {
//		Integer numbers = IT_orderService.Queryinginventory(id.toString(),specifications);
//		return JsonUtil.getResponseJson(1, "查询成功", null, numbers);
//
//	}

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
	public String updatete(String order_no, String order_payment) {
		int fig=0;
		fig = IT_orderService.ordercancelled(order_no, "1");
		Map<String, Object> column = new HashMap<String, Object>();
		column.put("order_id", order_no);

		List<T_shopping> T_shopping = T_shoppingService.selectByMap(column);
		for (int i = 0; i < T_shopping.size(); i++) {
			T_shopping.get(i).setState("1");
			T_shoppingService.updateById(T_shopping.get(i));
		}

  	IT_orderService.updateorderpayment(order_no, order_payment);
		if (fig > 0) {
			return JsonUtil.getResponseJson(1, "查询成功", null, null);
		}
		return JsonUtil.getResponseJson(1, "查询成功", null, null);
	}

	/**
	 * 定时任务
	 */
	@Scheduled(fixedDelay = 6000) //启动后每隔5秒运行一次
	public void timer() { // 获取当前时间
		// System.out.println("执行了");
		Calendar s = Calendar.getInstance();
		Map<String, Object> columnMap = new HashMap<String, Object>();

		columnMap.put("order_state", 0);
		long diffDay = 0L;
		List<T_order> T_order = IT_orderService.selectByMap(columnMap);

		for (int i = 0; i < T_order.size(); i++) {
			Calendar now = Calendar.getInstance();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(T_order.get(i).getOrder_time());
			diffDay = (now.getTimeInMillis() - calendar.getTimeInMillis()) / (1000 * 60 * 60);
			/*
			 * // System.out.println(diffDay+"时间");
			 */			if (diffDay >= 2) {

				Map<String, Object> mnMap = new HashMap<String, Object>();
				columnMap.put("order_id", T_order.get(i).getOrder_no());

				List<T_shopping> T_shopping = T_shoppingService.selectByMap(mnMap);
				for (int j = 0; j < T_shopping.size(); j++) {
					T_shopping.get(i).setState("-1");
					T_shoppingService.updateById(T_shopping.get(i));
					T_product_specification T_product_specification = IT_orderService.specification(T_shopping.get(j).getProduct_id().toString(),
							T_shopping.get(j).getShoping_specifications());
					if(T_product_specification==null) {
						System.out.println(T_product_specification);
					}else {
					IT_orderService.updatenqux(T_shopping.get(j).getNumber(), T_shopping.get(j).getProduct_id(),T_product_specification.getId().toString());
					}
				}
				IT_orderService.ordercancelled(T_order.get(i).getOrder_id().toString(), "-1");

			}
		}

		/**
		 * 定时
		 */
		Map<String, Object> columnMap2 = new HashMap<String, Object>();

		columnMap2.put("order_state", 2);
		long diffDays = 0L;
		List<T_order> T_order2 = IT_orderService.selectByMap(columnMap2);

		for (int i = 0; i < T_order2.size(); i++) {
			Calendar now = Calendar.getInstance();
			Calendar calendare = Calendar.getInstance();
//			System.out.println(T_order2.get(i).getOrder_time());
			if (T_order2.get(i).getOrder_time() == null) {
				diffDays = 0L;
			} else {
				calendare.setTime(T_order2.get(i).getOrder_time());

				
				diffDays = (now.getTimeInMillis() - calendare.getTimeInMillis()) / (1000 * 60 * 60 * 24);

			}
			if (diffDays > 15) {

				IT_orderService.ordercancelled(T_order2.get(i).getOrder_id().toString(), "3");

			}
		}
//		System.out.println("执行成功");
		Calendar t = Calendar.getInstance();
//		System.out.println("执行成功时间"+(t.getTimeInMillis()-s.getTimeInMillis()));
	}
	@RequestMapping("/updateddjg")
	@ResponseBody
	public String updateddjg(Double order_payable, String order_id) {

		

		T_order T_order = IT_orderService.selectById(order_id);
		T_order.setOrder_payable(order_payable);
		boolean  fig=IT_orderService.updateAllColumnById(T_order);
		if(fig) {
			return JsonUtil.getResponseJson(1, "修改成功", null, null);
		}else{
			return JsonUtil.getResponseJson(-1, "修改失败", null, null);
		}
	}
	
	
	/**
	 * 订单取消,发货，签收，退货
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/ordercant")
	@ResponseBody
	public String ordercancelledt(String order_id, String order_state, String cause_explain, String cause_type,
			String sales_cause, String order_shouhuo_id) throws Exception {// 主键,订单状态,退货原因,退货类型,退货说明
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		int fig = 0;
		String sales_no = OrderCodeFactory.getOrderCode(8L);// 生产订单编号

		switch (order_state)

		{
		case "-1":
			T_order T_order = IT_orderService.selectById(order_id);// 取消订单查询购买量
			Map<String, Object> columnMap = new HashMap<String, Object>();
			columnMap.put("order_id", T_order.getOrder_no());

			List<T_shopping> T_shopping = T_shoppingService.selectByMap(columnMap);
			for (int i = 0; i < T_shopping.size(); i++) {
				T_shopping.get(i).setState("-1");
				T_shoppingService.updateById(T_shopping.get(i));
				T_product_specification T_product_specification = IT_orderService.specification(T_shopping.get(i).getProduct_id().toString(),
						T_shopping.get(i).getShoping_specifications());
				if(T_product_specification!=null) {
				IT_orderService.updatenqux(T_shopping.get(i).getNumber(), T_shopping.get(i).getProduct_id(),T_product_specification.getId().toString());
				fig = IT_orderService.ordercancelled(order_id, order_state);
			}else {
				fig = IT_orderService.ordercancelled(order_id, order_state);
			}
			
			}
			break;
		case "2":
			IT_orderService.updatewuliudanhao(order_id, order_shouhuo_id);

			fig = IT_orderService.ordercancelled(order_id, order_state);
			break;
		case "5":
			Map<String, Object> Map = new HashMap<String, Object>();
			Map.put("order_id", order_id);
			List<T_order> order = IT_orderService.selectByMap(Map);
			Date cause_time = new Date();
      
			T_sales T_sales =com.websit.until.order.sale(cause_explain,cause_type,order_id,sales_cause,cause_time,sales_no,order.get(0).getUser_id(),order.get(0).getOrder_state(),order.get(0).getOrder_number(),order.get(0).getOrder_payable());
			


			Map<String, Object> lumnMap = new HashMap<String, Object>();
			lumnMap.put("order_id", order_id);
			lumnMap.put("stele", "0");

			if (T_salesService.selectByMap(lumnMap).size() > 0) {
				msg = "已经在审核中，请稍等";
				return JsonUtil.getResponseJson(cood, msg, null, null);
			} else {

				T_salesService.insert(T_sales);
				fig = IT_orderService.ordercancelled(order_id, order_state);

				break;
			}
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


}
