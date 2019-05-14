package com.websit.service;

import com.websit.entity.T_order;
import com.websit.entity.T_product;
import com.websit.entity.T_product_specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.service.IService;
import com.websit.entityvo.*;


/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface IT_orderService extends IService<T_order> {
	/**
	 * 查询库存
	 * @return
	 */
	int   Queryinginventory(String  order_product_id, Long specifications);
	/**
	 * 查询商品状态
	 * @return
	 */
	T_product   Querysteda(String  order_product_id);
	/**
	 * 送单取消
	 * @return
	 */
	int   ordercancelled(String  order_id,String order_state);
	/**
	 * 查询订单列表
	 */
	List<order_list> order_list(String user_id,String order_state,RowBounds RowBounds,String id);
	/**
	 * 商品订单
	 */
	List<shopinglist> shopinglist(String no,String order_state);
	/**
	 * 查询运费
	 * @param jiage
	 * @return
	 */
	
	int yunfei(Double jiage);
	/**
	 * 减去库存
	 * @param jiage
	 * @return
	 */
	int updatenumbergoumai(Integer number,String product_id,Long id);
	
	/**
	 * @Title: selectAllSecond
	 * @description 查询个人没有评价的商品列表
	 * @param @return    
	 * @return List<T_orderVo>    
	 * @author linghongyu
	 * @createDate 2019年3月24日
	 */
	public List<T_orderVo> selectAllSecond(long user_id);
	/**
	 * @Title: updateState
	 * @description 修改是否评价状态
	 * @param usre_id,product_id  
	 * @return int    
	 * @author linghongyu
	 * @createDate 2019年3月25日
	 */
	public int updateState(@Param("order_id")String order_id,@Param("product_id")String product_id);
	/**
	 * 添加物流单号
	 * @param usre_id
	 * @param product_id
	 * @return
	 */
	public int updatewuliudanhao(String order_id,String order_shouhuo_id);
	/**
	 * 查询优惠价格
	 * @param id
	 * @return
	 */
	public int selectpase(String id,Double jiage);
	/**
	 * 查询订单列表
	 */
	List<order_list> order_list1(String order_state,Integer page,Integer limit,String date);
	
	/**
	 * 查询角标
	 */
	jiaobiao jiaobiao(String user_id);
	/**
	 * 支付宝app修改状态
	 * @param order_id
	 * @param order_payment
	 * @return
	 */
	int updateorderpayment(String order_id,String order_payment);
	/**
	 * 取消订单加库存
	 * @param number
	 * @param product_id
	 * @return
	 */
	int updatenqux(Integer number,String product_id,String attribute);
	
	/**
	 * 根据订单号查用户id
	 * @param t
	 * @return
	 */
	T_order selectbyout_trade_no(String order_no);
	/**
	 * 商品单个退货
	 */
	public String sales(String order_id,String productid); 
	public T_product_specification specification(String product_id,String specifications);
	
}
