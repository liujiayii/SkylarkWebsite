package com.websit.service.impl;

import com.websit.entity.T_coupon;
import com.websit.mapper.T_couponMapper;
import com.websit.service.IT_couponService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券实体表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-19
 */
@Service
public class T_couponServiceImpl extends ServiceImpl<T_couponMapper, T_coupon> implements IT_couponService {
	
	@Autowired
	private T_couponMapper couponDao;

	@Override
	public void updateStatusById(Long id, int i) {

		couponDao.updateStatusById(id,i);
	}

}
