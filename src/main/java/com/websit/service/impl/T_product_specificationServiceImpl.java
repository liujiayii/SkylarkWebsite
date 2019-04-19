package com.websit.service.impl;

import com.websit.entity.T_product_specification;
import com.websit.mapper.T_product_specificationMapper;
import com.websit.service.IT_product_specificationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品规格表(pc) 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-18
 */
@Service
public class T_product_specificationServiceImpl extends ServiceImpl<T_product_specificationMapper, T_product_specification> implements IT_product_specificationService {

	@Autowired
	private T_product_specificationMapper specificationMapper;
	@Override
	public T_product_specification selectAllspecification(T_product_specification t) {
	
		return specificationMapper.selectAllspecification(t);
	}

}
