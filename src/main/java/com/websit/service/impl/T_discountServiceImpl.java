package com.websit.service.impl;

import com.websit.entity.T_discount;
import com.websit.mapper.T_discountMapper;
import com.websit.service.IT_discountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品优惠表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
@Service
public class T_discountServiceImpl extends ServiceImpl<T_discountMapper, T_discount> implements IT_discountService {

	@Autowired
	private T_discountMapper dismapper;
	
	@Override
	public List<T_discount> selectList() {
	
		return dismapper.selectList();
	}

	@Override
	public List<T_discount> pageOfDiscount(Integer page, Integer limit) {
		
		return dismapper.pageOfDiscount(page, limit);
	}

	@Override
	public Integer selectCoount() {
	
		return dismapper.selectCount();
	}

}
