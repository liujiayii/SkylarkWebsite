package com.websit.mapper;

import com.websit.entity.T_product;
import com.websit.entity.T_trolley;
import com.websit.entityvo.lt_trolleylst;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 购物车表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface T_trolleyMapper extends BaseMapper<T_trolley> {
	/**
	 * 
	 * @param user_id
	 * @return
	 */
	List <lt_trolleylst> lt_trolleylst(String user_id,RowBounds RowBounds);
	int shppingnum(@Param("product_id")String product_id,@Param("user_id")String user_id,@Param("Trolley_specifications_Id")String Trolley_specifications_Id);
	int updatemnum(@Param("num")int  num,@Param("product_id")String product_id,@Param("user_id")String user_id,@Param("Trolley_specifications_Id")String Trolley_specifications_Id);
	int number(@Param("product_id")String product_id);
	int updatemnum2(@Param("num")Integer  num,@Param("id")Integer id,@Param("user_id")String user_id,@Param("T_trolley_id")String T_trolley_id);
	T_product T_produc(String T_product_id);
	/**
	 * 已添加订单信息
	 * @param no
	 * @return
	 */
	int inslit(String no);
	/*/*
	 * 查询商品名称
	 */
	String  querproductname(String productId);
	
}
