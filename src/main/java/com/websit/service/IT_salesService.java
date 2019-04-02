package com.websit.service;

import com.websit.entity.T_sales;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.service.IService;
import com.websit.entityvo.th_list;
/**
 * <p>
 * 退货表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface IT_salesService extends IService<T_sales> {
	/**
	 * 退货审核
	 * @param sales_id
	 * @param stale
	 * @return
	 */
	boolean updatestale(String stale,Integer sales_id);
	/**
	 * 查询退货列表
	 */
	List<th_list> th_list(String date,RowBounds RowBounds);
	
}
