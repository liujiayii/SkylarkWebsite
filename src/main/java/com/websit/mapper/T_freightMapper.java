package com.websit.mapper;

import com.websit.entity.T_freight;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 运费表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-25
 */
public interface T_freightMapper extends BaseMapper<T_freight> {
	List<T_freight>  T_freight(T_freight T_freight,RowBounds RowBounds);
}
