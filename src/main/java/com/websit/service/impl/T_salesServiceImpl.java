package com.websit.service.impl;

import com.websit.entity.T_sales;
import com.websit.entityvo.order_listr;
import com.websit.entityvo.shopinglist;
import com.websit.mapper.T_salesMapper;
import com.websit.service.IT_salesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 退货表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Service
public class T_salesServiceImpl extends ServiceImpl<T_salesMapper, T_sales> implements IT_salesService {
	@Autowired
	public T_salesMapper T_salesMapper;
	@Override
	public boolean updatestale(String stale,Integer sales_id) {
	        int fig=(T_salesMapper.updatestaletrtr(stale,sales_id ));
	        if(fig>0) {
	        	return true;
	        }
		  return  false;
				 
	}
	@Override
	public List<com.websit.entityvo.th_list> th_list(String date,RowBounds RowBounds) {
		// TODO Auto-generated method stub
		return T_salesMapper.th_list(date,RowBounds);
	}
	@Override
	public List<shopinglist> seleth_list(String stale, String user_id, RowBounds RowBounds,String order_no) {
		// TODO Auto-generated method stub
		return T_salesMapper.seleth_list(stale, user_id, RowBounds,order_no);
	}
	@Override
	public List<order_listr> rder_listr(String stale, String user_id, RowBounds rowBounds, String order_no) {
		// TODO Auto-generated method stub
		return T_salesMapper.order_listr(stale, user_id, rowBounds, order_no);
	}
  
}
