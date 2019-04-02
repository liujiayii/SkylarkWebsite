package com.websit.service.impl;

import com.websit.entity.T_admin;
import com.websit.mapper.T_accessMapper;
import com.websit.mapper.T_adminMapper;
import com.websit.service.IT_adminService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-24
 */
@Service
public class T_adminServiceImpl extends ServiceImpl<T_adminMapper, T_admin> implements IT_adminService {

	@Autowired
	private T_adminMapper adminMapper;
	@Override
	public T_admin selectbyName(String name) {
		
		return adminMapper.selectbyName(name);
	}

	@Override
	public Integer selectby(T_admin t) {
	
		return adminMapper.selectby(t);
	}

}
