package com.websit.service.impl;

import com.websit.entity.T_sales;
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
  
}
