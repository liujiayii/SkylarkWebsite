package com.websit.service;

import com.websit.entity.T_plate;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 板块表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface IT_plateService extends IService<T_plate> {
	
	/**
	 * 查询版块信息
	 *
	 * @Title: selectPlateInfo
	 * @description 
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月15日-下午1:45:08
	 */
	String selectPlateInfo();
}
