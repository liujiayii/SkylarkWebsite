package com.websit.service;

import com.websit.entity.T_plate;
import com.websit.entityvo.PlateCompanyVo;

import java.util.List;

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
	 * 查询所有论坛分类以及对应版块信息
	 *
	 * @Title: selectAllPlates
	 * @description 
	 * @return  
	 * String   
	 * @author lujinpeng
	 * @createDate 2019年3月18日-上午11:23:48
	 */
	String selectAllPlates();
	
	T_plate selectFindId(long id);
}
