package com.websit.mapper;

import com.websit.entity.T_coupon;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 优惠券实体表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-19
 */
public interface T_couponMapper extends BaseMapper<T_coupon> {
     /**
      * 
     *
      * @Title: updateStatusById
     
      * @description 根据id修改优惠券状态
     *
      * @param @param id
      * @param @param i 
        
      * @return void    
     
      *
      * @author lishaozhang
      * @createDate 2019年4月19日
      */
	void updateStatusById(@Param("id") Long id, @Param("status") int status);

}
