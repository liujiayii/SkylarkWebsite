package com.websit.service;

import com.websit.entity.T_freight;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 运费表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-25
 */
public interface IT_freightService extends IService<T_freight> {
	List<T_freight>  T_freight(T_freight T_freight,RowBounds RowBounds);

}
