package com.websit.service;

import com.websit.entity.T_express;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 快递公司表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface IT_expressService extends IService<T_express> {

	/**
	 * 通过订单号查询快递信息
	 *
	 * @Title: selectExpressDetails
	 * @description 
	 * @param map 可将快递单号添加到map中作为查询条件
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月21日-下午4:08:01
	 */
	String selectExpressDetails(Map<String, String> map);
	
}
