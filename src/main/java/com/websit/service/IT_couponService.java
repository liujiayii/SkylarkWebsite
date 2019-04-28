package com.websit.service;

import com.websit.entity.T_coupon;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 优惠券实体表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-19
 */
@Service
public interface IT_couponService extends IService<T_coupon> {
    /**
     * 
    *
     * @Title: updateStatusById
    
     * @description 修改优惠券状态
    *
     * @param @param id
     * @param @param i 
       
     * @return void    
    
     *
     * @author lishaozhang
     * @createDate 2019年4月19日
     */
	void updateStatusById(Long id, int i);

}
