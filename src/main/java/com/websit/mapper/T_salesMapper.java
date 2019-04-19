package com.websit.mapper;

import com.websit.entity.T_sales;
import com.websit.entityvo.order_listr;
import com.websit.entityvo.shopinglist;
import com.websit.entityvo.th_list;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 退货表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface T_salesMapper extends BaseMapper<T_sales> {
	/**
	 * 更改状态
	 * @param sales_id
	 * @param stale
	 * @return
	 */
	int updatestaletrtr(@Param("stale")String stale,@Param("sales_id")Integer sales_id);
	
	/**
	 * 退货列表
	 * @param date
	 * @param RowBounds
	 * @return
	 */
	List<th_list> th_list(String date,RowBounds RowBounds);
	/**
	 * 退货列表
	 * @param date
	 * @param RowBounds
	 * @return
	 */
	List<shopinglist> seleth_list(@Param("stale")String stale,@Param("user_id")String user_id,RowBounds RowBounds,@Param("no")String no);
	List<order_listr> order_listr(@Param("stale")String stale,@Param("user_id")String user_id,RowBounds RowBounds,@Param("no")String no);
}
