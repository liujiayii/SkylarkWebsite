package com.websit.service.impl;

import com.websit.entity.T_app;
import com.websit.mapper.T_appMapper;
import com.websit.service.IT_appService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * app版本控制 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-15
 */
@Service
public class T_appServiceImpl extends ServiceImpl<T_appMapper, T_app> implements IT_appService {
	@Autowired
	public T_appMapper  T_appMapper;
	@Override
	public boolean uodatevison(T_app app) {
		
		return T_appMapper.uodatevison(app);
	}

}
