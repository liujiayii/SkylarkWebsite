package com.websit.service.impl;

import com.websit.entity.T_product;
import com.websit.entity.T_trolley;
import com.websit.mapper.T_trolleyMapper;
import com.websit.service.IT_trolleyService;
import com.websit.until.specificationsuntil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Service
public class T_trolleyServiceImpl extends ServiceImpl<T_trolleyMapper, T_trolley> implements IT_trolleyService {
	@Autowired
	public T_trolleyMapper  T_trolleyMapper;
	@Override
	public List<com.websit.entityvo.lt_trolleylst> lt_trolleylst(String user_id,RowBounds RowBounds) {
		// TODO Auto-generated method stub
		return T_trolleyMapper.lt_trolleylst(user_id,RowBounds);
		
	}
	@Override
	public boolean shppingnum(String product_id,String user_id,String getTrolley_specifications) {
		List<T_trolley> T_trolley=T_trolleyMapper.shppingnum(product_id,user_id);
		for(int i=0;i<T_trolley.size();i++) {
			boolean fig=specificationsuntil.specification(T_trolley.get(i).getTrolley_specifications(),getTrolley_specifications);
			if(!fig) {
				return true;
			}else
				return false;
		}
		
		return true;
	}
	@Override
	public boolean updatemnum(int num,String product_id,String user_id) {
		int fig=T_trolleyMapper.updatemnum(num,product_id,user_id);
		if(fig>0) {
			return true;
		}
		return false;
	}
	@Override
	public int number(String product_id) {
		int mum=0;
		try {
			mum=T_trolleyMapper.number(product_id);
		} catch (Exception e) {
			return 0;
		}
		return mum;
		
	}
	@Override
	public boolean updatemnum2(Integer num, Integer id,String user_id,String T_trolley_id) {
		if(T_trolleyMapper.updatemnum2(num, id,user_id,T_trolley_id)>0)
		{
			return true;
		}
		return false;
	}
	@Override
	/**
	 * 查询商品信息
	 */
	public T_product T_produc(String T_product_id) {
		// TODO Auto-generated method stub
		return T_trolleyMapper.T_produc(T_product_id);
	}
	@Override
	/*  插入订单信息
	 * (non-Javadoc)
	 * @see com.websit.service.IT_trolleyService#inslit(java.lang.String)
	 */
	public boolean inslit(String no) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String querproductname(String productId) {
		// TODO Auto-generated method stub
		return T_trolleyMapper.querproductname(productId);
	}

}
