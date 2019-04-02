package com.websit.mapper;

import com.websit.entity.T_discount;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 商品优惠表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
public interface T_discountMapper extends BaseMapper<T_discount> {

	List<T_discount> selectList();

	List<T_discount> pageOfDiscount(@Param("page")Integer page, @Param("limit")Integer limit);

	Integer selectCount();

}
