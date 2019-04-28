package com.websit.service.impl;

import com.websit.entity.T_freight;
import com.websit.mapper.T_freightMapper;
import com.websit.mapper.T_goodsMapper;
import com.websit.service.IT_freightService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 运费表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-25
 */
@Service
public class T_freightServiceImpl extends ServiceImpl<T_freightMapper, T_freight> implements IT_freightService {
	@Autowired
	private T_freightMapper T_freightMapper;
	@Override
	public List<com.websit.entity.T_freight> T_freight(com.websit.entity.T_freight T_freight,RowBounds RowBounds) {
		// TODO Auto-generated method stub
		return T_freightMapper.T_freight(T_freight, RowBounds);
	}

}
