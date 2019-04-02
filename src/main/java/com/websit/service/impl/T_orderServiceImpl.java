package com.websit.service.impl;

import com.websit.entity.T_order;
import com.websit.entity.T_product;
import com.websit.entityvo.T_orderVo;
import com.websit.entityvo.youhui;
import com.websit.mapper.T_orderMapper;
import com.websit.service.IT_orderService;

import io.lettuce.core.dynamic.annotation.Param;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.websit.entityvo.*;
/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Service
public class T_orderServiceImpl extends ServiceImpl<T_orderMapper, T_order> implements IT_orderService {
	@Autowired
	public T_orderMapper T_orderMapper;
    /**
     *        查询库存
     */
	@Override
	public int Queryinginventory(String trolley_id) {
		int num=0;
		  try {
			 num= T_orderMapper.Queryinginventory(trolley_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return num;
	}
	/***
	 * 查询商品状态
	 */
	public T_product Querysteda(String order_product_id) {
		// TODO Auto-generated method stub
		return T_orderMapper.Querysteda(order_product_id);
	}
	@Override
	/**
	 * 查询订单列表
	 */
	public int ordercancelled(String order_id,String order_state) {
		
		
		return T_orderMapper.ordercancelled(order_id, order_state);
	}
	@Override
	public List<com.websit.entityvo.order_list> order_list(String user_id, String order_state,RowBounds RowBounds,String id) {
		// TODO Auto-generated method stub
		return T_orderMapper.order_list(user_id, order_state,RowBounds,id);
	}
	@Override
	/**
	 * 查询商品订单
	 */
	public List<com.websit.entityvo.shopinglist> shopinglist(String no) {
		// TODO Auto-generated method stub
		return T_orderMapper.shopinglist(no);
	}
	@Override
	/**
	 * 查询运费
	 */
	public int yunfei(Double yunfei) {
		   try {
			   if(T_orderMapper.yunfei(yunfei)==null) {
				   return 0;
			   }
				   
			return T_orderMapper.yunfei(yunfei);
		} catch (Exception e) {
			// TODO: handle exception
		}
		   return 0; 
	}
	/**
	 * @Title: selectAllSecond
	 * @description 查询个人没有评价的商品列表
	 * @param @return    
	 * @return List<T_orderVo>    
	 * @author linghongyu
	 * @createDate 2019年3月24日
	 */
	@Override
	public List<T_orderVo> selectAllSecond(long user_id) {
		return T_orderMapper.selectAllSecond(user_id);
	}
	@Override
	public int updatenumbergoumai(Integer number, String product_id) {
		// TODO Auto-generated method stub
		return T_orderMapper.updatenumbergoumai(number, product_id);
	}
	@Override
	/**
	 * 更新物流单号
	 */
	public int updatewuliudanhao(String order_id, String order_product_id) {
		// TODO Auto-generated method stub
		return T_orderMapper.updatewuliudanhao(order_id, order_product_id);
	}
	/**
	 * @Title: updateState
	 * @description 修改是否评价状态
	 * @param usre_id,product_id  
	 * @return int    
	 * @author linghongyu
	 * @createDate 2019年3月25日
	 */
	@Override
	public int updateState(String order_id,String product_id) {
		// TODO Auto-generated method stub
		return T_orderMapper.updateState(order_id, product_id);
	}
	@Override
	/**
	 * 查询优惠价格
	 */
	public int selectpase(String id,Double jiage) {
		List<youhui>mer=T_orderMapper.selectpase(id);
		youhui qujian=new  youhui();
		qujian.setId("0");
		qujian.setPrice(0);
		int  yhje=0;
		System.out.println(mer.toString()+"9999999999999999999999999999");
		try {
			
	
		for(int i=0;i<mer.size();i++) {
			if(mer.get(i).getPrice()<jiage) {
				if(mer.get(i).getPrice()>qujian.getPrice()) {
					qujian=mer.get(i);
					System.out.println("9999999999999999999999999999"+qujian);
				}
							    
			}
		}
		System.out.println("9999999999999999999999999999"+qujian.getId());
		yhje=T_orderMapper.selectyhjene(qujian.getId());
		} catch (Exception e) {
			yhje=0;
		}
		System.out.println(yhje+"测试");
		System.out.println("9999999999999999999999999999"+yhje);
		return yhje;
	}

	/**
	 * web端订单
	 */
	public List<com.websit.entityvo.order_list> order_list1( String order_state,RowBounds RowBounds,String date) {
		// TODO Auto-generated method stub
		return T_orderMapper.order_list1(order_state,RowBounds,date);
	}
	@Override
	public jiaobiao jiaobiao(String user_id) {
		System.out.println(user_id+"999999999999999999999999");  
		jiaobiao jiaobiao=new jiaobiao();
		jiaobiao.setDfk(T_orderMapper.querdfk(user_id));
		jiaobiao.setDaf(T_orderMapper. yifukuan(user_id));
		jiaobiao.setDsh(T_orderMapper.yifahuo(user_id));
		jiaobiao.setYsh((T_orderMapper.  yishouhuo(user_id)));
		jiaobiao.setQuantum(T_orderMapper.quantum(user_id));
		System.out.println(T_orderMapper.quantum(user_id)+"6666666666666666666666666666666666666666666666");
		return jiaobiao;
	}
	@Override
	public int updateorderpayment(String order_id, String order_payment) {
		// TODO Auto-generated method stub
		return T_orderMapper.updateorderpayment(order_id,order_payment);
	}

}
