package com.websit.service;

import com.websit.entity.T_discount;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商品优惠表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
public interface IT_discountService extends IService<T_discount> {

	List<T_discount> selectList();

	List<T_discount> pageOfDiscount(@Param("page")Integer page, @Param("limit")Integer limit);

	Integer selectCoount();


}
