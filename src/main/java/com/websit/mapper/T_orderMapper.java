package com.websit.mapper;

import com.websit.entity.T_order;
import com.websit.entity.T_product;
import com.websit.entityvo.T_orderVo;
import com.websit.entityvo.order_list;
import com.websit.entityvo.shopinglist;
import com.websit.entityvo.youhui;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface T_orderMapper extends BaseMapper<T_order> {
	/**
	 * 查询库存
	 * @return
	 */
	int   Queryinginventory(String  order_product_id);
	/**
	 * <p>
	 * 查询商品状态
	 * </p>
	 * @return
	 */
	T_product   Querysteda(String  order_product_id);
	/**
	 * 订单取消
	 * @return
	 */
	public int ordercancelled(@Param("order_id")String order_id,@Param("order_state")String order_state);
	/**
	 * 查询订单列表
	 */
	List<order_list> order_list(@Param("user_id")String user_id,@Param("order_state")String order_state,RowBounds RowBounds,@Param("id")String id);
	/**
	 * 商品订单
	 */
	List<shopinglist> shopinglist(@Param("no")String no,@Param("state")String state);
	/**
	 * 查询运费
	 * @param jiage
	 * @return
	 */
	Integer yunfei(Double yunfei);
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
	 * 减去库存
	 * @param jiage
	 * @return
	 */
	public int updatenumbergoumai(@Param("number")Integer number, @Param("product_id")String product_id);
	/**
	 * @Title: updateState
	 * @description 修改是否评价状态
	 * @param usre_id,product_id  
	 * @return int    
	 * @author linghongyu
	 * @createDate 2019年3月25日
	 */
	public int updateState(@Param("order_id")String order_id,@Param("product_id") String product_id);
	/**
	 * 添加物流单号
	 * @param usre_id
	 * @param product_id
	 * @return
	 */
	public int updatewuliudanhao(@Param("order_id")String order_id,@Param("order_shouhuo_id")String order_shouhuo_id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<youhui> selectpase(String id);
	public Integer selectyhjene(@Param("id")String id);
	/**
	 * 查询订单列表
	 */
	List<order_list> order_list1(@Param("order_state")String order_state,@Param("page")Integer page,@Param("limit")Integer limit,@Param("date")String date);
	//
	int  querdfk(String  user_id);
	int  yifukuan(String  user_id);
	int  yifahuo(String  user_id);
	int  yishouhuo(String  user_id);
	int  quantum(String  user_id);
	int updateorderpayment(@Param("order_id")String order_id,@Param("order_payment")String order_payment);
	int updatenqux(@Param("number")Integer number, @Param("product_id")String product_id);


}
