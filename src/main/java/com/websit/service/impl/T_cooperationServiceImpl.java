package com.websit.service.impl;

import com.websit.entity.T_cooperation;
import com.websit.mapper.T_cooperationMapper;
import com.websit.service.IT_cooperationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 首页合作商 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Service
public class T_cooperationServiceImpl extends ServiceImpl<T_cooperationMapper, T_cooperation> implements IT_cooperationService {

	@Resource
	private T_cooperationMapper cooperationMapper;
	@Override
	public T_cooperation selectThink(T_cooperation cooperation) {
		// TODO Auto-generated method stub
		return cooperationMapper.selectThink(cooperation);
	}
	/* (non-Javadoc)
	 * @see com.websit.service.IT_cooperationService#selectThinkTwo(com.websit.entity.T_cooperation)
	 */
	@Override
	public T_cooperation selectThinkTwo(T_cooperation cooperation) {
		// TODO Auto-generated method stub
		return cooperationMapper.selectThinkTwo(cooperation);
	}

}
