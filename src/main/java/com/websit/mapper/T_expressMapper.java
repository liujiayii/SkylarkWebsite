package com.websit.mapper;

import com.websit.entity.T_express;
import com.websit.entityvo.ExpressDetailsVo;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 快递公司表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface T_expressMapper extends BaseMapper<T_express> {
	
	/**
	 * 通过订单号查询快递信息
	 *
	 * @Title: selectExpressDetails
	 * @description 
	 * @param map
	 * @return  
	 * ExpressDetailsVo    
	 * @author lujinpeng
	 * @createDate 2019年3月21日-下午4:06:01
	 */
	ExpressDetailsVo selectExpressDetails(Map<String, String> map);
	
}
