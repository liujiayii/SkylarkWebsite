package com.websit.service;

import com.websit.entity.T_product;
import com.websit.entity.T_trolley;
import com.websit.entityvo.lt_trolleylst;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 购物车表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface IT_trolleyService extends IService<T_trolley> {
	List <lt_trolleylst> lt_trolleylst(String user_id,RowBounds RowBounds);

	int shppingnum(String product_id,String user_id);
	boolean updatemnum(int num,String product_id,String user_id);
	int number(String product_id);
	
	boolean updatemnum2(Integer  num,Integer id,String user_id);
	T_product T_produc(String T_product_id);
	boolean inslit(String no);
	/*/*
	 * 查询商品名称
	 */
	String  querproductname(String productId);
	

}
