package com.websit.service.impl;

import com.websit.entity.T_access;
import com.websit.mapper.T_accessMapper;
import com.websit.mapper.T_userMapper;
import com.websit.service.IT_accessService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员与访问数量表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Service
public class T_accessServiceImpl extends ServiceImpl<T_accessMapper, T_access> implements IT_accessService {

	
	@Autowired
	private T_accessMapper accessMapper;

	@Override
	public T_access conent(String time) {
		
		
		return accessMapper.conent(time);
	}

	@Override
	public Integer insert1() {
		
		return accessMapper.insert(new Date());
	}

	@Override
	public Integer updatenumber(String time) {
		
		return accessMapper.updatenumber( time);
	}
	
	

}
