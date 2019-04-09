package com.websit.service.impl;

import com.websit.entity.T_cooperation;
import com.websit.mapper.T_cooperationMapper;
import com.websit.service.IT_cooperationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

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
	/**
	 * @Title: selectThink
	 * @description 查询合作名称是否重复
	 * @param @param cooperation
	 * @param @return    
	 * @return T_cooperation    
	 * @author linhongyu
	 * @createDate 2019年4月4日
	 */
	@Override
	public T_cooperation selectThink(T_cooperation cooperation) {
		return cooperationMapper.selectThink(cooperation);
	}
	/**
	 * @Title: selectThinkTwo
	 * @description 查询地址名称是否重复
	 * @param @param cooperation
	 * @param @return    
	 * @return T_cooperation    
	 * @author linhongyu
	 * @createDate 2019年4月4日
	 */
	@Override
	public T_cooperation selectThinkTwo(T_cooperation cooperation) {
		return cooperationMapper.selectThinkTwo(cooperation);
	}

}
